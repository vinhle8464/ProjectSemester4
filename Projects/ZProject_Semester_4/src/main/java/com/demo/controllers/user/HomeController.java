package com.demo.controllers.user;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.models.Account;
import com.demo.services.AccountService;
import com.demo.services.admin.CategoryServiceAdmin;
import com.demo.services.user.PricingService;
import com.demo.services.user.RoleServiceUser;

@Controller
@RequestMapping(value = { "", "user/home" })
public class HomeController {
	@Autowired
	private CategoryServiceAdmin categoryServiceAdmin;
	@Autowired
	private RoleServiceUser roleServiceUser;
	@Autowired
	private AccountService accountService;
	@Autowired
	private PricingService pricingService;

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String register(ModelMap modelMap) {
		modelMap.put("categories", categoryServiceAdmin.findAllCategory());
		Account account = new Account();
		
		modelMap.put("account", account);
		modelMap.put("home", true);
		modelMap.put("packs", pricingService.findAll());
		
		return "user/home/index";
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

}
