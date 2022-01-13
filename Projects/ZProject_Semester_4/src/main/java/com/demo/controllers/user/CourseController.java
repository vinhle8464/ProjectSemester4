package com.demo.controllers.user;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.models.Account;
import com.demo.services.admin.CategoryServiceAdmin;
import com.demo.services.user.CourseService;


@Controller
@RequestMapping(value = {"user/course"})
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CategoryServiceAdmin categoryServiceAdmin;
	
	
	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(@RequestParam(name = "categoryId") int categoryId, ModelMap modelMap) {
		modelMap.put("categories", categoryServiceAdmin.findAllCategory());
		Account account = new Account();
		account.setDob(new Date());
		modelMap.put("account", account);
		System.out.println("sdaflksfj" + categoryId);
		modelMap.put("quizs", courseService.findAllQuizByCategoryId(categoryId));
		
		return "user/course/index";
		
	}


}
