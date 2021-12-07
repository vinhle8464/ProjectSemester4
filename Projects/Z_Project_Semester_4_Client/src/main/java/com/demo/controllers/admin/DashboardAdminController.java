package com.demo.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"admin/dashboard"})
public class DashboardAdminController {

	@RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
	public String index() {
		
	
		return "admin/dashboard/index";
	}
}
