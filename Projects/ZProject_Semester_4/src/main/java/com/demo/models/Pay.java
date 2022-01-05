package com.demo.models;
// Generated Dec 29, 2021, 9:30:54 PM by Hibernate Tools 5.1.10.Final

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
 * Pay generated by hbm2java
 */
@Entity
@Table(name = "pay", catalog = "dbproject4")
public class Pay implements java.io.Serializable {

	private Integer payId;
	private Account account;
	private String payment;
	private String title;
	private float fee;
	private Date datePaid;
	private boolean payStatus;

	public Pay() {
	}

	public Pay(Account account, String payment, String title, float fee, Date datePaid, boolean payStatus) {
		this.account = account;
		this.payment = payment;
		this.title = title;
		this.fee = fee;
		this.datePaid = datePaid;
		this.payStatus = payStatus;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "pay_id", unique = true, nullable = false)
	public Integer getPayId() {
		return this.payId;
	}

	public void setPayId(Integer payId) {
		this.payId = payId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", nullable = false)
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Column(name = "payment", nullable = false, length = 100)
	public String getPayment() {
		return this.payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	@Column(name = "title", nullable = false, length = 250)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "fee", nullable = false, precision = 10, scale = 2)
	public float getFee() {
		return this.fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_paid", nullable = false, length = 26)
	public Date getDatePaid() {
		return this.datePaid;
	}

	public void setDatePaid(Date datePaid) {
		this.datePaid = datePaid;
	}

	@Column(name = "pay_status", nullable = false)
	public boolean isPayStatus() {
		return this.payStatus;
	}

	public void setPayStatus(boolean payStatus) {
		this.payStatus = payStatus;
	}

}
