package com.demo.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = {"user/about"})
public class AboutController {
	
	
	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String register(ModelMap modelMap) {

	
		return "user/about/index";
	}


}
