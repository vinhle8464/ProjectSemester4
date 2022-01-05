package com.demo.controllers.faculty;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.models.Account;
import com.demo.services.AccountService;

@Controller
@RequestMapping(value = { "faculty/dashboard" })
public class DashboardFacultyController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(Authentication authentication, ModelMap modelMap, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		modelMap.put("accountUsername", accountService.findByUsername(authentication.getName()));

		return "faculty/dashboard/index";
	}
}
