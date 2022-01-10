package com.demo.entites;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.demo.models.Account;
import com.demo.models.Quiz;

public class QuestionAjax {


	private Integer questionId;
	private Integer quizId;
	private String title;
	private String explain;
	private boolean status;
	
	
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Integer getQuizId() {
		return quizId;
	}
	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public QuestionAjax(Integer questionId, Integer quizId, String title, String explain, boolean status) {
		super();
		this.questionId = questionId;
		this.quizId = quizId;
		this.title = title;
		this.explain = explain;
		this.status = status;
	}
	public QuestionAjax() {
		super();
	}
	
	
	
	
	
	
}
