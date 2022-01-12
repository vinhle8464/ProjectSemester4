package com.demo.controllers.faculty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entites.QuestionAnswer;
import com.demo.models.Account;
import com.demo.models.Answer;
import com.demo.models.Question;
import com.demo.models.Quiz;
import com.demo.services.AccountService;
import com.demo.services.faculty.AnswerServiceFaculty;
import com.demo.services.faculty.QuestionServiceFaculty;
import com.demo.services.faculty.QuizServiceFaculty;

@Controller
@RequestMapping(value = { "faculty/dashboard" })
public class DashboardFacultyController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private QuizServiceFaculty quizServiceFaculty;

	@Autowired
	private QuestionServiceFaculty questionServiceFaculty;

	@Autowired
	private AnswerServiceFaculty answerServiceFaculty;

	
	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(Authentication authentication, ModelMap modelMap, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		modelMap.put("accountUsername", accountService.findByUsername(authentication.getName()));
	
		QuestionAnswer questionAnswer = new QuestionAnswer();
		modelMap.put("questionAnswer", questionAnswer);
		
		Question question = new Question();
		modelMap.put("question", question);
		
		return "faculty/dashboard/index";
	}
	

	
	
	@RequestMapping(value = { "test2" }, method = RequestMethod.POST)
	public String test2(@ModelAttribute("questionAnswer") QuestionAnswer questionAnswer, @RequestParam("quizId") int quizId, @RequestParam("answerTitle") String[] answerTitle, @RequestParam("answerStatus") String[] answerStatus, HttpServletRequest request) {
		
		//String[] questions = request.getParameterValues("questions");
//		
//		List<String> convertedAnswerTitle = Arrays.asList(questionAnswer.getAnswer().getTitle().split(",", -1));
//		
		
		System.out.println("title "  + quizId);
		System.out.println("title "  + questionAnswer.getQuestion().getTitle());
		System.out.println("title "  + questionAnswer.getQuestion().getExplainDetail());
	
		for(String title : answerTitle) {
			System.out.println("title: " + title);
		}
		
		for(String status : answerStatus) {
			System.out.println("status: " + status);
		}
		System.out.println("==================== "  );
		
		
		return "faculty/dashboard/index";
	}
}
