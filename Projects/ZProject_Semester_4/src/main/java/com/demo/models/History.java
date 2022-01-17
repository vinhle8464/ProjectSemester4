package com.demo.models;
// Generated Jan 17, 2022, 9:56:49 PM by Hibernate Tools 5.1.10.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * History generated by hbm2java
 */
@Entity
@Table(name = "history", catalog = "dbproject4")
public class History implements java.io.Serializable {

	private Integer historyId;
	private Account account;
	private Quiz quiz;
	private Date date;
	private boolean status;
	private String listQuestionId;
	private String listAnswerChoice;
	private int timeDone;
	private int numberRightAnswer;

	public History() {
	}

	public History(Account account, Quiz quiz, Date date, boolean status, String listQuestionId,
			String listAnswerChoice, int timeDone, int numberRightAnswer) {
		this.account = account;
		this.quiz = quiz;
		this.date = date;
		this.status = status;
		this.listQuestionId = listQuestionId;
		this.listAnswerChoice = listAnswerChoice;
		this.timeDone = timeDone;
		this.numberRightAnswer = numberRightAnswer;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "history_id", unique = true, nullable = false)
	public Integer getHistoryId() {
		return this.historyId;
	}

	public void setHistoryId(Integer historyId) {
		this.historyId = historyId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", nullable = false)
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "quiz_id", nullable = false)
	public Quiz getQuiz() {
		return this.quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", nullable = false, length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Column(name = "list_question_id", nullable = false, length = 65535)
	public String getListQuestionId() {
		return this.listQuestionId;
	}

	public void setListQuestionId(String listQuestionId) {
		this.listQuestionId = listQuestionId;
	}

	@Column(name = "list_answer_choice", nullable = false, length = 65535)
	public String getListAnswerChoice() {
		return this.listAnswerChoice;
	}

	public void setListAnswerChoice(String listAnswerChoice) {
		this.listAnswerChoice = listAnswerChoice;
	}

	@Column(name = "time_done", nullable = false)
	public int getTimeDone() {
		return this.timeDone;
	}

	public void setTimeDone(int timeDone) {
		this.timeDone = timeDone;
	}

	@Column(name = "number_right_answer", nullable = false)
	public int getNumberRightAnswer() {
		return this.numberRightAnswer;
	}

	public void setNumberRightAnswer(int numberRightAnswer) {
		this.numberRightAnswer = numberRightAnswer;
	}

}
