package com.demo.controllers.faculty;

import javax.management.Query;

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

import com.demo.models.Question;
import com.demo.models.Quiz;
import com.demo.services.AccountService;
import com.demo.services.faculty.QuestionServiceFaculty;
import com.demo.services.faculty.QuizServiceFaculty;

@Controller
@RequestMapping(value = { "faculty/question" })
public class QuestionFacultyController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private QuestionServiceFaculty questionServiceFaculty;

	@Autowired
	private QuizServiceFaculty quizServiceFaculty;

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap, Model model, Authentication authentication) {

		modelMap.put("accountUsername", accountService.findByUsername(authentication.getName()));
		return pagination(1, 10, "questionId", modelMap, model, authentication);

	}

	@RequestMapping(value = { "create" }, method = RequestMethod.POST)
	public String create(@ModelAttribute("question") Question question, @RequestParam("quizId") int quizId, ModelMap modelMap) {
		

		Question question2 = new Question();
		question2.setTitle("aa");
		question2.setQuiz(quizServiceFaculty.findById(quizId));
		question2.setExplainDetail("sss");
		question2.setStatus(true);
		
		System.out.println(question2.toString());

		//question.setQuiz(quizServiceFaculty.findById(quizId));
		
		questionServiceFaculty.create(question2);

		return "redirect:/faculty/question/index";
	}

	@RequestMapping(value = { "edit" }, method = RequestMethod.PUT)
	public String edit(@ModelAttribute("question") Question question) {

		questionServiceFaculty.update(question);

		return "redirect:/faculty/question/index";
	}

	@RequestMapping(value = { "delete" }, method = RequestMethod.GET)
	public String delete(@RequestParam("questionID") int questionID) {

		questionServiceFaculty.deleteById(questionID);

		return "redirect:/faculty/question/index";
	}

	@RequestMapping(value = { "pagination" }, method = RequestMethod.GET)
	public String pagination(@RequestParam(name = "currentPage") int currentPage,
			@RequestParam(name = "pageSize") int pageSize, @RequestParam(name = "sort") String sort, ModelMap modelMap,
			Model model, Authentication authentication) {

		modelMap.put("accountUsername", accountService.findByUsername(authentication.getName()));

		int pageSizee = pageSize;

		Page<Question> pages = questionServiceFaculty.getPage(currentPage, pageSizee, sort);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("totalElements", pages.getTotalElements());
		model.addAttribute("pageSize", pageSizee);
		model.addAttribute("sort", sort);
		model.addAttribute("questions", pages.getContent());

		
		Question question = new Question();
		modelMap.put("question", question);
			
		
		return "faculty/question/index";
	}

}
