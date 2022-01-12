package com.demo.entites;

import java.util.List;

import com.demo.models.Answer;
import com.demo.models.Question;

public class QuestionAnswer {

	private Question question;
	private Answer answer;

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	

	public QuestionAnswer(Question question, Answer answer) {
		super();
		this.question = question;
		this.answer = answer;
	}

	public QuestionAnswer() {
		super();
	}

	
}
