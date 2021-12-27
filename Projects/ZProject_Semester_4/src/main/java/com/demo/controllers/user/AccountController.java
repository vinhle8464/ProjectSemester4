package com.demo.controllers.user;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.client.RedirectStrategy;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.models.Account;
import com.demo.services.AccountService;
import com.demo.services.user.OAuth2LoginSuccessHandler;
import com.demo.services.user.RoleServiceUser;
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
public class AccountController {
	private static HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
	private static JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);
	private static final String USER_INDENTIFIER_KEY = "MY_DUMMY_USER";
	@Value("421409099908-5lb16kre20s6reehaji71bh54j4ktavr.apps.googleusercontent.com")
	private String clientid;
	@Value("nocrGDp0uRZTdDtAXprvHlP1")
	private String clientsecret;
	@Value("http://localhost:9799/login/oauth2/code/google")
	private String redirecturl;
	@Autowired
	private RoleServiceUser roleServiceUser;
	@Autowired
	private AccountService accountService;

	private GoogleAuthorizationCodeFlow flow;

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

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(ModelMap modelMap) {

		Account account = new Account();
		account.setDob(new Date());
		modelMap.put("account", account);
		return "user/account/register";
	}

	@PostConstruct
	public void init() throws Exception {
		flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientid, clientsecret, SCOPES)
				.build();
	}

	@RequestMapping(value = "googlelogin", method = RequestMethod.GET)
	public String google(ModelMap modelMap, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		modelMap.put("msg", "Login As Google Account " + session.getAttribute("name"));
		return "/user/home/profile";

	}

	@RequestMapping(value = { "register" }, method = RequestMethod.POST)
	public String register(@ModelAttribute("account") Account account, @RequestParam("role") int[] roles,
			@RequestParam("repassword") String repassword) {
		if (account.getPassword().equalsIgnoreCase(repassword)) {
			String hash = new BCryptPasswordEncoder().encode(account.getPassword());
			account.setPassword(hash);

			if (roles != null && roles.length > 0) {
				for (int role : roles) {
					account.getRoles().add(roleServiceUser.find(role));
				}
			}

			accountService.save(account);
			return "user/account/login";
		}
		return "redirect:/user/account/register";

	}

	@RequestMapping(value = "welcome", method = RequestMethod.GET)
	public String welcome(Authentication authentication) {

		System.out.println("hello" + authentication.getAuthorities().toString());

		if (authentication.getAuthorities().toString().equalsIgnoreCase("[ROLE_ADMIN, ROLE_USER]")
				|| authentication.getAuthorities().toString().equalsIgnoreCase("[ROLE_ADMIN]")) {
			return "redirect:/admin/dashboard";
		} else if (authentication.getAuthorities().toString().equalsIgnoreCase("[ROLE_USER]")) {
			return "redirect:/user/home/index";
		}
		return "account/welcome";
	}

	@RequestMapping(value = "accessDenied", method = RequestMethod.GET)
	public String accessDenied() {

		return "404/index";
	}
}
