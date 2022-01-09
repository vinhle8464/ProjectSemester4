package com.demo.controllers.faculty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entites.QuizAjax;
import com.demo.services.faculty.QuizServiceFaculty;

@RestController
@RequestMapping("faculty/ajax")
public class AjaxFacultyController {

	@Autowired
	private QuizServiceFaculty quizServiceFaculty;
	
	@RequestMapping(value = {"findquizbyid"}, method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public QuizAjax findQuizById(@RequestParam("quizId") int quizId) {
		
		return quizServiceFaculty.findByIdAjax(quizId);
		
	}

}
