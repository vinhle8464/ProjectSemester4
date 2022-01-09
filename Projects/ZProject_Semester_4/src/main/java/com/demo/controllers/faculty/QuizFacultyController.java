package com.demo.controllers.faculty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.models.Account;
import com.demo.models.Category;
import com.demo.models.Quiz;
import com.demo.services.AccountService;
import com.demo.services.admin.CategoryServiceAdmin;
import com.demo.services.faculty.QuizServiceFaculty;

@Controller
@RequestMapping(value = {"faculty/quiz"})
public class QuizFacultyController {

	@Autowired
	private QuizServiceFaculty quizServiceFaculty;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CategoryServiceAdmin categoryServiceAdmin;
	
	@RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
	public String index(ModelMap modelMap, Model model, Authentication authentication) {
		
		modelMap.put("accountUsername", accountService.findByUsername(authentication.getName()));
		modelMap.put("categories", categoryServiceAdmin.findAllCategory());
		return pagination(1, 5, "quizId", modelMap, model, authentication);
	}
	
	
	
	@RequestMapping(value = { "create" }, method = RequestMethod.POST)
	public String create(@ModelAttribute("quiz") Quiz quiz, ModelMap modelMap) {
		
		quizServiceFaculty.create(quiz);

		return "redirect:/faculty/quiz/index";
	}

	@RequestMapping(value = { "edit" }, method = RequestMethod.POST)
	public String edit(@ModelAttribute("quiz") Quiz quiz,  Authentication authentication, 
			@RequestParam(value = "categoryId") int categoryId, ModelMap modelMap, Model model) {
		
		Account account = accountService.findByUsername(authentication.getName());
		Category category = categoryServiceAdmin.findById(categoryId);
		quiz.setCategory(category);
		quiz.setAccount(account);
		quizServiceFaculty.update(quiz);
		return pagination(1, 50, "title", modelMap, model, authentication);
	}

	@RequestMapping(value = { "delete" }, method = RequestMethod.GET)
	public String delete(@RequestParam("quizID") int quizID) {

		quizServiceFaculty.deleteById(quizID);

		return "redirect:/faculty/quiz/index";
	}

	
	
	@RequestMapping(value = {"pagination"}, method = RequestMethod.GET)
	public String pagination(@RequestParam(name = "currentPage") int currentPage, @RequestParam(name = "pageSize") int pageSize, @RequestParam(name = "sort") String sort,
			ModelMap modelMap, Model model, Authentication authentication) {
		
		modelMap.put("accountUsername", accountService.findByUsername(authentication.getName()));
		modelMap.put("categories", categoryServiceAdmin.findAllCategory());
		int pageSizee = pageSize;

		Page<Quiz> pages = quizServiceFaculty.getPage(currentPage, pageSizee, sort);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("totalElements", pages.getTotalElements());
		model.addAttribute("pageSize", pageSizee);
		model.addAttribute("sort", sort);
		model.addAttribute("quizs", pages.getContent());

		Quiz quiz = new Quiz();		
		modelMap.put("quiz", quiz);


		return "faculty/quiz/index";
	}

}
