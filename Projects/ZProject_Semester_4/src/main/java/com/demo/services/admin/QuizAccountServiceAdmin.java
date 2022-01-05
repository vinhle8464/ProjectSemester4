package com.demo.services.admin;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.demo.entites.QuizAjax;
import com.demo.models.Quiz;

public interface QuizAccountServiceAdmin {

	
	public List<Quiz> findAllQuiz(int accountId);

}
