package com.demo.services.user;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.demo.entites.QuizAccountAjax;
import com.demo.entites.QuizAjax;
import com.demo.models.Account;
import com.demo.models.Question;
import com.demo.models.Quiz;
public interface CourseService {

	public List<Quiz> findAllQuizByCategoryId(int categoryId);
	
	
	
	
}
