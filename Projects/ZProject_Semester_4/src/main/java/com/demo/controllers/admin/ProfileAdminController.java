package com.demo.controllers.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.models.Account;
import com.demo.services.admin.AccountServiceAdmin;

@Controller
@RequestMapping(value = {"admin/profile"})
public class ProfileAdminController {
	
	@Autowired
	private AccountServiceAdmin accountServiceAdmin;

	@RequestMapping(value = {"","index"}, method = RequestMethod.GET)
	public String index(HttpSession session, ModelMap modelMap) {
		session.setAttribute("username", "ngoctran");
		Account account = accountServiceAdmin.findByUsername(session.getAttribute("username").toString());
		modelMap.put("account", account);
		return "admin/profile/index";
	}
}
