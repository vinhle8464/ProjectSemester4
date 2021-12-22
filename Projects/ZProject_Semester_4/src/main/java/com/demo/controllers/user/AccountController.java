package com.demo.controllers.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.demo.services.user.RoleServiceUser;
@Controller
@RequestMapping(value = { "", "user/account" })
public class AccountController {
	
	@Autowired
	private RoleServiceUser roleServiceUser;
	@Autowired
	private AccountService accountService;

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

	@RequestMapping(value = "google", method = RequestMethod.GET)
	public String google(ModelMap modelMap) {
		
		modelMap.put("msg", "Login as google account");
		
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
