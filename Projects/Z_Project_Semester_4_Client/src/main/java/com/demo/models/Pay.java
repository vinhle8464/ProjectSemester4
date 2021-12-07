package com.demo.models;

import java.util.Date;

public class Pay {

	private Integer payId;
	private Account account;
	private String payment;
	private String title;
	private long fee;
	private Date datePaid;
	private boolean payStatus;
	
	public Pay() {
		super();
	}
	
	public Pay(Integer payId, Account account, String payment, String title, long fee, Date datePaid,
			boolean payStatus) {
		super();
		this.payId = payId;
		this.account = account;
		this.payment = payment;
		this.title = title;
		this.fee = fee;
		this.datePaid = datePaid;
		this.payStatus = payStatus;
	}
	
	public Integer getPayId() {
		return payId;
	}
	public void setPayId(Integer payId) {
		this.payId = payId;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getFee() {
		return fee;
	}
	public void setFee(long fee) {
		this.fee = fee;
	}
	public Date getDatePaid() {
		return datePaid;
	}
	public void setDatePaid(Date datePaid) {
		this.datePaid = datePaid;
	}
	public boolean isPayStatus() {
		return payStatus;
	}
	public void setPayStatus(boolean payStatus) {
		this.payStatus = payStatus;
	}
	
	
}
