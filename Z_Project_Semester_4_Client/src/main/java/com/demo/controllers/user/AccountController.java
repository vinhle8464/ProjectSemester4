package com.demo.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value =  "account")
public class AccountController {
	
	@RequestMapping(value = "myaccount", method = RequestMethod.GET)
	public String myaccount() {
		
	
		return "account/myaccount";
	}
	
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register() {
		
	
		return "account/register";
	}
}
