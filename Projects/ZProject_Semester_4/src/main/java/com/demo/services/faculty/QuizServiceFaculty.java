package com.demo.services.faculty;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.demo.entites.QuizAccountAjax;
import com.demo.entites.QuizAjax;
import com.demo.models.Account;
import com.demo.models.Question;
import com.demo.models.Quiz;
public interface QuizServiceFaculty {

	public List<Quiz> findAllQuiz();

	public Quiz findById(int id);

	public Quiz create(Quiz quiz);

	public Quiz update(Quiz quiz);

	public void deleteById(int id);

	public QuizAjax findByIdAjax(int quizId);

	public Page<Quiz> getPage(int currentPage, int pageSize, String sort);

	public Page<Quiz> getAllQuizByAccountId(int currentPage, int pageSize, String sort, int accountId);
	
	
}
