package com.demo.controllers.user;



import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.models.Account;
import com.demo.models.Answer;
import com.demo.models.History;
import com.demo.models.HistoryId;
import com.demo.models.Question;
import com.demo.models.Quiz;
import com.demo.services.AccountService;
import com.demo.services.admin.CategoryServiceAdmin;
import com.demo.services.faculty.QuizServiceFaculty;
import com.demo.services.user.CourseService;

@Controller
@RequestMapping(value = { "user/course" })
public class CourseController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private CategoryServiceAdmin categoryServiceAdmin;

	@Autowired
	private QuizServiceFaculty quizServiceFaculty;

	private int categoryIdd;

	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(@RequestParam(name = "categoryId") int categoryId, ModelMap modelMap, Model model,
			Authentication authentication) {

		if (categoryId > 0) {
			this.categoryIdd = categoryId;
			modelMap.put("course", true);

			return pagination(1, 15, "quiz_id", modelMap, model, authentication);

		} else {
			this.categoryIdd = 0;

			modelMap.put("course", true);

			return pagination(1, 15, "quiz_id", modelMap, model, authentication);

		}

	}

	@RequestMapping(value = { "quizdetails" }, method = RequestMethod.GET)
	public String QuizDetails(@RequestParam("quizId") int quizId, ModelMap modelMap, Model model,
			Authentication authentication) {

		Account account = new Account();
		modelMap.put("account", account);
		modelMap.put("categories", categoryServiceAdmin.findAllCategory());
		modelMap.put("course", true);

		Account username = accountService.findByUsername(authentication.getName());
		modelMap.put("accountUsername", username);

		modelMap.put("quiz", quizServiceFaculty.findById(quizId));

		return "user/course/quizdetails";
	}

	
	@RequestMapping(value = { "starttest" }, method = RequestMethod.GET)
	public String StartTest(@RequestParam("quizId") int quizId, ModelMap modelMap, Model model,
			Authentication authentication) {

		Account account = new Account();
		Account username = accountService.findByUsername(authentication.getName());
		
		
		
		modelMap.put("account", account);
		modelMap.put("categories", categoryServiceAdmin.findAllCategory());
		modelMap.put("course", true);
		modelMap.put("accountUsername", username);
		modelMap.put("quiz", quizServiceFaculty.findById(quizId));

		return "user/course/starttest";
	}
	
	@RequestMapping(value = { "endtest" }, method = RequestMethod.POST)
	public String EndTest(@RequestParam("quizId") int quizId, ModelMap modelMap, Model model,
			Authentication authentication, HttpServletRequest request) {

		System.out.println("timesubmit==============: " + request.getParameter("timersubmit"));
		Account account = new Account();
		Account username = accountService.findByUsername(authentication.getName());
		
		// plus 1 time in times of quiz
		Quiz quiz = quizServiceFaculty.findById(quizId);
		quiz.setTimes(quiz.getTimes() + 1);
		quizServiceFaculty.update(quiz);

		// create new history 
		HistoryId historyId = new HistoryId();
		historyId.setDate(new Date());
		historyId.setQuizId(quizId);
		historyId.setAccountId(username.getAccountId());
		historyId.setStatus(true);
		historyId.setListQuestionId(request.getParameterValues("questionId").toString());
		
		// get list anserchoice
		List<String> listAnswerChoice = null;	
		String[] listQuestionId = request.getParameterValues("questionId");		
		int i = 0;
//		System.out.println("questionId size: " + questionId.length);
		for (String string : listQuestionId) {
			//System.out.println("questionId: " + string);
			
			String answer = "answer" + i;
			
			System.out.println("answer: "  + answer);
			System.out.println("answer this : " + request.getParameter(answer) );
			listAnswerChoice.add(request.getParameter(answer));
			
			i++;
		}
		historyId.setListAnswerChoice(listAnswerChoice.toString());
		historyId.setTimeDone(Integer.parseInt(request.getParameter("timersubmit")));
		
		
		// get number of right  answer_ choice
		List<Question> questions = (List<Question>) quiz.getQuestions();
		int t = 0;
		int rightAnswerChoice = 0;
		for (String questionId : listQuestionId) {
			
			for (Question question : questions) {
				
				if(Integer.parseInt(questionId)  == question.getQuestionId()) {
					String answer = "answer" + i;
					int answerChoice = Integer.parseInt(request.getParameter(answer));
					
					List<Answer> answers = (List<Answer>) question.getAnswers();
					String[] listAnswer = answers.toArray(new String[0]);
					for (String aaa : listAnswer) {
						System.out.println(aaa);
					}
					
//					if(answers.get(3)[0] == true) {
//						
//					}
				}
			}
			String answer = "answer" + i;
			listAnswerChoice.add(request.getParameter(answer));
			t++;
		}
		
		
		
		modelMap.put("account", account);
		modelMap.put("categories", categoryServiceAdmin.findAllCategory());
		modelMap.put("course", true);
		modelMap.put("accountUsername", username);
		modelMap.put("quiz", quizServiceFaculty.findById(quizId));

		return "redirect:/user/course/starttest?quizId=" + quizId;
	}
	
	
	@RequestMapping(value = { "pagination" }, method = RequestMethod.GET)
	public String pagination(@RequestParam(name = "currentPage") int currentPage,
			@RequestParam(name = "pageSize") int pageSize, @RequestParam(name = "sort") String sort, ModelMap modelMap,
			Model model, Authentication authentication) {

		
		if (accountService.findByUsername(authentication.getName()) != null) {
			modelMap.put("accountUsername", accountService.findByUsername(authentication.getName()));

		}

		int pageSizee = pageSize;

		Page<Quiz> pages = null;
		if (categoryIdd > 0) {
			pages = courseService.getAllQuizByCategoryId(currentPage, pageSizee, sort, categoryIdd);
		} else {

			pages = courseService.getPage(currentPage, pageSizee, sort);
		}

		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("totalElements", pages.getTotalElements());
		model.addAttribute("pageSize", pageSizee);
		model.addAttribute("sort", sort);
		model.addAttribute("quizs", pages.getContent());

		Account account = new Account();

		modelMap.put("account", account);
		modelMap.put("categories", categoryServiceAdmin.findAllCategory());

		return "user/course/index";
	}

}
