package com.demo.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value =  "aboutus")
public class AboutusController {
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index() {
		
	
		return "aboutus/index";
	}
}
