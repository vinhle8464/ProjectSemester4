package com.demo.controllers.user;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.services.faculty.QuizServiceFaculty;


@Controller
@RequestMapping(value = {"user/course"})
public class CourseController {
	
	
	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(@RequestParam(name = "categoryId") int categoryId, ModelMap modelMap) {
				
		System.out.println("sdaflksfj" + categoryId);
		//System.out.println("size: " + quizServiceFaculty.findAllQuiz());
		//modelMap.put("quizs", quizServiceFaculty.findAllQuizByCategoryId(categoryId));
		
		return "user/course/index";
		
	}


}
