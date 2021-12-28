package com.demo.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.services.AccountService;

@Controller
@RequestMapping(value = {"admin/dashboard"})
public class DashboardAdminController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
	public String index(Authentication authentication, ModelMap modelMap) {
		modelMap.put("accountUsername", accountService.findByUsername(authentication.getName()));
		return "admin/dashboard/index";
	}
}
