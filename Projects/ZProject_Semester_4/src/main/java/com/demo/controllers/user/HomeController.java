package com.demo.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.services.admin.CategoryServiceAdmin;

@Controller
@RequestMapping(value = { "user/home" })
public class HomeController {
	@Autowired
	private CategoryServiceAdmin categoryServiceAdmin;

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String register(ModelMap modelMap) {
		modelMap.put("categories", categoryServiceAdmin.findAllCategory());

		return "user/home/index";
	}

}
