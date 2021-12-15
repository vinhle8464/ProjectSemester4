package com.demo.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.services.admin.EmailServiceAdmin;
import com.demo.services.admin.PayServiceAdmin;

@Controller
@RequestMapping(value = {"admin/email"})
public class EmailAdminController {

	@Autowired
	private EmailServiceAdmin emailServiceAdmin;
	
	@RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		
		modelMap.put("emails", emailServiceAdmin.findAllEmail());
		return "admin/email/index";
	}
	

}
