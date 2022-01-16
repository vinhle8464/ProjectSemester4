package com.demo.controllers.admin;

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
@RequestMapping(value = { "admin/dashboard" })
public class DashboardAdminController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		System.out.println("bao");
		System.out.println(account.getFullname());

		return "admin/dashboard/index";
	}
}
