package com.demo.controllers.faculty;

import java.util.ArrayList;
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
	
		return "faculty/dashboard/index";
	}
	
	@RequestMapping(value = { "testt" }, method = RequestMethod.POST)
	public String testt(@RequestParam("quizId") int quizId, HttpServletRequest request) {
		
		String[] questions = request.getParameterValues("questions");
		
//		System.out.println("count question: " + questions.length);
//		for(String question : questions) {
//			System.out.println("value: " + question);
//		}
		for(String questionTitle : questions) {
			Question question2 = new Question();
			List<Answer> answers = new ArrayList<Answer>();
			
			if(questionTitle.contains("question")) {
				question2.setTitle(questionTitle);
				question2.setQuestionId(quizId);
				question2.setStatus(true);
				questions = ArrayUtils.removeElement(questions, questionTitle);
				System.out.println("count question: " + questions.length);
				
				for(String explain : questions) {
					if(explain.contains("explain")) {
						question2.setExplainDetail(explain);					
					}
					questions = ArrayUtils.removeElement(questions, explain);
					System.out.println("count question: " + questions.length);
					
				}
				Question question = questionServiceFaculty.create(question2);
				
				for(String answerTitle : questions) {
					if(answerTitle.contains("answer")) {
						if(answerTitle.contains("true"))
						//answers.add(new Answer(question, answerTitle, true, true));
						answerServiceFaculty.create(new Answer(question, answerTitle, true, true));
						}else {
						//answers.add(new Answer(question, answerTitle, false, true));
						answerServiceFaculty.create(new Answer(question, answerTitle, false, true));
					}
					questions = ArrayUtils.removeElement(questions, answerTitle);
					System.out.println("count question: " + questions.length);
					
				}
						
					
			}
		}

		System.out.println("count question: " + questions.length);

		return "faculty/dashboard/index";
	}
}
