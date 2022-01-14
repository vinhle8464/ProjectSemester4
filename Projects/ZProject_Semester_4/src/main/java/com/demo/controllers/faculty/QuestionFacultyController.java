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

import com.demo.models.Answer;
import com.demo.models.Question;
import com.demo.services.AccountService;
import com.demo.services.faculty.AnswerServiceFaculty;
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
	private AnswerServiceFaculty answerServiceFaculty;

	@Autowired
	private QuizServiceFaculty quizServiceFaculty;

	private int quizIdd;

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(@RequestParam("quizId") int quizId, ModelMap modelMap, Model model,
			Authentication authentication) {
		this.quizIdd = quizId;
		modelMap.put("accountUsername", accountService.findByUsername(authentication.getName()));
		return pagination(1, 25, "question_id", modelMap, model, authentication);

	}

	@RequestMapping(value = { "create" }, method = RequestMethod.POST)
	public String create(@ModelAttribute("question") Question question,
			@RequestParam("answerTitle") String[] answerTitle, @RequestParam("answerStatus") String[] answerStatus) {

	
		
		// add question
		question.setQuiz(quizServiceFaculty.findById(quizIdd));
		question.setStatus(true);

		question = questionServiceFaculty.create(question);

		int i = 0;
		// add list answers
		for (String title : answerTitle) {
			Answer answer = new Answer();
			answer.setTitle(title);
			answer.setQuestion(question);

			if (answerStatus[i].equalsIgnoreCase("0")) {
				answer.setAnswerStatus(false);

			} else {
				answer.setAnswerStatus(true);
			}
			answer.setStatus(true);
			answerServiceFaculty.create(answer);
			i++;

		}

		return "redirect:/faculty/question/index?quizId=" + quizIdd;
	}

	@RequestMapping(value = { "update" }, method = RequestMethod.POST)
	public String edit(@ModelAttribute("question") Question question, @RequestParam("answerId") String[] answerId,
			@RequestParam("answerTitle") String[] answerTitle, @RequestParam("answerStatus") String[] answerStatus) {

		// update question
		question.setQuiz(quizServiceFaculty.findById(quizIdd));
		question.setStatus(true);

		question = questionServiceFaculty.update(question);

		// update answers		
		for (int i = 0; i < answerTitle.length; i++) {
			Answer answer = new Answer();

			if (answerId.length > i) {
				answer.setAnswerId(Integer.parseInt(answerId[i].toString()));
			}
			answer.setTitle(answerTitle[i]);
			answer.setQuestion(question);

			if (answerStatus[i].equalsIgnoreCase("0")) {
				answer.setAnswerStatus(false);
			} else {
				answer.setAnswerStatus(true);
			}
			answer.setStatus(true);

			answerServiceFaculty.update(answer);

		}

		return "redirect:/faculty/question/index?quizId=" + quizIdd;
	}

	@RequestMapping(value = { "delete" }, method = RequestMethod.GET)
	public String delete(@RequestParam("questionID") int questionID) {

		answerServiceFaculty.deleteByQuestionId(questionID);
		questionServiceFaculty.deleteById(questionID);

		return "redirect:/faculty/question/index?quizId=" + quizIdd;
	}

	@RequestMapping(value = { "pagination" }, method = RequestMethod.GET)
	public String pagination(@RequestParam(name = "currentPage") int currentPage,
			@RequestParam(name = "pageSize") int pageSize, @RequestParam(name = "sort") String sort, ModelMap modelMap,
			Model model, Authentication authentication) {

		modelMap.put("accountUsername", accountService.findByUsername(authentication.getName()));

		int pageSizee = pageSize;

		Page<Question> pages = questionServiceFaculty.getAllQuestionByQuizId(currentPage, pageSizee, sort, quizIdd);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("totalElements", pages.getTotalElements());
		model.addAttribute("pageSize", pageSizee);
		model.addAttribute("sort", sort);
		model.addAttribute("questions", pages.getContent());

		Question question = new Question();
		modelMap.put("question", question);
		modelMap.put("quizId", quizIdd);

		return "faculty/question/index";
	}

}
