package com.demo.entites;

public class QuizAccountAjax {

	private Integer quizId;
	private String title;
	private String fullname;
	private String description;
	private int times;
	private byte timer;
	private boolean fee;
	private boolean status;
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
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public byte getTimer() {
		return timer;
	}
	public void setTimer(byte timer) {
		this.timer = timer;
	}
	public boolean isFee() {
		return fee;
	}
	public void setFee(boolean fee) {
		this.fee = fee;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public QuizAccountAjax(Integer quizId, String title, String fullname, String description, int times, byte timer,
			boolean fee, boolean status) {
		super();
		this.quizId = quizId;
		this.title = title;
		this.fullname = fullname;
		this.description = description;
		this.times = times;
		this.timer = timer;
		this.fee = fee;
		this.status = status;
	}
	public QuizAccountAjax() {
		super();
	}
	
	
	
}
