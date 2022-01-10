package com.demo.controllers.user;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.helpers.UploadHelper;
import com.demo.models.Account;
import com.demo.services.AccountService;
import com.demo.services.user.AccountServiceUser;
import com.demo.services.user.OAuth2LoginSuccessHandler;
import com.demo.services.user.RoleServiceUser;
import com.demo.validators.AccountValidator;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.DriveScopes;

@Controller
@RequestMapping(value = { "", "user/account", "login/oauth2/code" })
public class AccountController implements ServletContextAware {
	@Autowired
	private AccountValidator accountValidator;
	@Autowired
	private RoleServiceUser roleServiceUser;
	@Autowired
	private AccountService accountService;

	private ServletContext servletContext;
	
	@Autowired
	private AccountServiceUser accountServiceUser;

	@Override
	public void setServletContext(ServletContext servletContext) {

		this.servletContext = servletContext;

	}

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	@RequestMapping(value = { "", "login" }, method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, ModelMap modelMap) {

		if (error != null) {
			modelMap.put("msg", "Invalid!");
		}
		if (logout != null) {
			modelMap.put("msg", "Logout Successfully!");
		}

		return "user/account/login";
	}

	@RequestMapping(value = { "processlogin" }, method = RequestMethod.GET)
	public String login(@RequestParam("username") String username, @RequestParam("password") String Password) {

		return "user/account/process-login";
	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(ModelMap modelMap) {

		Account account = new Account();
		account.setDob(new Date());
		modelMap.put("account", account);
		return "user/account/register";
	}

	@RequestMapping(value = "googlelogin", method = RequestMethod.GET)
	public String google(ModelMap modelMap, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		if (accountService.findByUsername(email) == null) {
			int[] roles = { 2 };
			Account account = new Account();
			account.setUsername((String) session.getAttribute("email"));
			String hash = new BCryptPasswordEncoder().encode((String) session.getAttribute("email"));
			account.setPassword(hash);
			account.setEmail((String) session.getAttribute("email"));
			account.setFullname((String) session.getAttribute("name"));
			account.setAddr("no");
			account.setGender(true);
			account.setAvatar((String) session.getAttribute("picture"));
			account.setStatus(true);
			if (roles != null && roles.length > 0) {
				for (int role : roles) {
					account.getRoles().add(roleServiceUser.find(role));
				}
			}
			accountService.save(account);
		} else {

		}

		modelMap.put("msg", "Login As Google Account " + session.getAttribute("name"));
		return "redirect:/user/account/welcome";

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(accountService);
	}

	@RequestMapping(value = { "register" }, method = RequestMethod.POST)
	public String register(ModelMap modelMap, @RequestParam(value = "terms", required = false) boolean terms,
			@ModelAttribute("account") @Valid Account account, @RequestParam("role") int[] roles,
			@RequestParam(value = "file") MultipartFile file, @RequestParam("repassword") String repassword,
			RedirectAttributes redirectAttributes, BindingResult bindingResult) {
		accountValidator.validate(account, bindingResult);
		if (bindingResult.hasErrors()) {
			return "user/account/register";
		}
		if (terms) {
			if (account.getPassword().equalsIgnoreCase(repassword)) {
				String hash = new BCryptPasswordEncoder().encode(account.getPassword());
				account.setPassword(hash);
				String fileNameUpload = UploadHelper.upload(servletContext, file);
				redirectAttributes.addFlashAttribute("fileName", fileNameUpload);
				account.setAvatar(fileNameUpload);
				if (roles != null && roles.length > 0) {
					for (int role : roles) {
						account.getRoles().add(roleServiceUser.find(role));
					}
				}
				accountService.save(account);
				return "user/account/login";
			} else {
				modelMap.put("msg", "Retype Password Is Not Correct! ");
				return "redirect:/user/account/register";
			}
		} else {
			modelMap.put("msg", "Accept Our Term To Continue Signing Up! ");
			return "redirect:/user/account/register";
		}

	}

	@RequestMapping(value = "welcome", method = RequestMethod.GET)
	public String welcome(Authentication authentication, HttpServletRequest request, ModelMap modelMap) {
		HttpSession session = request.getSession();
		System.out.println("hello" + authentication.getAuthorities().toString());
		System.out.println("hello" + authentication.getName().toString());
		if (authentication.getAuthorities().toString().equalsIgnoreCase("[ROLE_ADMIN]")) {
			session.setAttribute("account", accountService.findByUsername(authentication.getName()));
			return "redirect:/admin/dashboard/index";
		} else if (authentication.getAuthorities().toString().equalsIgnoreCase("[ROLE_USER_FACULTY]")) {
			session.setAttribute("account", accountService.findByUsername(authentication.getName()));
			return "redirect:/faculty/dashboard/index";
		} else if (authentication.getAuthorities().toString().equalsIgnoreCase("[ROLE_USER_CANDIDATE]")) {
			session.setAttribute("account", accountService.findByUsername(authentication.getName()));
			session.setAttribute("counta", accountServiceUser.countAccountUser());
			return "redirect:/user/home/index";
		} else if (authentication.getAuthorities().toString().equalsIgnoreCase(
				"[ROLE_USER, SCOPE_https://www.googleapis.com/auth/userinfo.email, SCOPE_https://www.googleapis.com/auth/userinfo.profile, SCOPE_openid]")) {
			session.setAttribute("account", accountService.findByUsername((String) session.getAttribute("email")));
			return "redirect:/user/home/index";
		}
		return "account/welcome";
	}

	@RequestMapping(value = "accessDenied", method = RequestMethod.GET)
	public String accessDenied() {

		return "404/index";
	}
}