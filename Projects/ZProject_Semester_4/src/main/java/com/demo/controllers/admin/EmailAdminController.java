package com.demo.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"admin/email"})
public class EmailAdminController {

	@RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
	public String index() {
		
	
		return "admin/email/index";
	}
	

}
