package com.demo.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.models.Quiz;
import com.demo.models.Role;
import com.demo.services.AccountService;
import com.demo.services.admin.CategoryServiceAdmin;
import com.demo.services.admin.QuizServiceAdmin;

@Controller
@RequestMapping(value = {"admin/quiz"})
public class QuizController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private QuizServiceAdmin quizServiceAdmin;
	
	@Autowired
	private CategoryServiceAdmin categoryServiceAdmin;
	
	@RequestMapping(value = {"","index"}, method = RequestMethod.GET)
	public String index(ModelMap modelMap, Model model, Authentication authentication) {
		modelMap.put("accountUsername", accountService.findByUsername(authentication.getName()));
		modelMap.put("categories", categoryServiceAdmin.findAllCategory());
		return pagination(1, 5, "quizId", modelMap, model, authentication);
	}
	
	@RequestMapping(value = {"pagination"}, method = RequestMethod.GET)
	public String pagination(@RequestParam(name = "currentPage") int currentPage, @RequestParam(name = "pageSize") int pageSize, @RequestParam(name = "sort") String sort,
			ModelMap modelMap, Model model, Authentication authentication) {
		
		modelMap.put("accountUsername", accountService.findByUsername(authentication.getName()));
		
		int pageSizee = pageSize;

		Page<Quiz> pages = quizServiceAdmin.getPage(currentPage, pageSizee, sort);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("totalElements", pages.getTotalElements());
		model.addAttribute("pageSize", pageSizee);
		model.addAttribute("sort", sort);
		model.addAttribute("quizs", pages.getContent());

		Quiz quiz = new Quiz();		
		modelMap.put("quiz", quiz);


		return "admin/quiz/index";
	}
}
