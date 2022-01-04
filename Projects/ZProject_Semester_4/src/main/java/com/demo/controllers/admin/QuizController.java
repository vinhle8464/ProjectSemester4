package com.demo.controllers.admin;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"admin/quiz"})
public class QuizController {

	@RequestMapping(value = {"","index"}, method = RequestMethod.GET)
	public String index(ModelMap modelMap, Authentication authentication) {
		
		return "admin/quiz/index";
	}
	
}
