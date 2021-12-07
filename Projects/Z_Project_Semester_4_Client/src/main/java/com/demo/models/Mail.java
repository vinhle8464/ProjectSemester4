package com.demo.models;

import java.util.Date;

public class Mail {
	
	private Integer mailId;
	private String title;
	private String emailUser;
	private String fullname;
	private String phoneNumber;
	private String content;
	private String replyContent;
	private Date sendDate;
	private Date replyDate;
	private boolean checked;
	private boolean status;
	
	public Mail(Integer mailId, String title, String emailUser, String fullname, String phoneNumber, String content,
			String replyContent, Date sendDate, Date replyDate, boolean checked, boolean status) {
		super();
		this.mailId = mailId;
		this.title = title;
		this.emailUser = emailUser;
		this.fullname = fullname;
		this.phoneNumber = phoneNumber;
		this.content = content;
		this.replyContent = replyContent;
		this.sendDate = sendDate;
		this.replyDate = replyDate;
		this.checked = checked;
		this.status = status;
	}
	
	public Mail() {
		super();
	}

	public Integer getMailId() {
		return mailId;
	}

	public void setMailId(Integer mailId) {
		this.mailId = mailId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
