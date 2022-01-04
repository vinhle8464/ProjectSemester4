package com.demo.models;
// Generated Dec 29, 2021, 9:30:54 PM by Hibernate Tools 5.1.10.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * HistoryId generated by hbm2java
 */
@Embeddable
public class HistoryId implements java.io.Serializable {

	private int historyId;
	private Date date;
	private int quizId;
	private int accountId;
	private boolean status;

	public HistoryId() {
	}

	public HistoryId(int historyId, Date date, int quizId, int accountId, boolean status) {
		this.historyId = historyId;
		this.date = date;
		this.quizId = quizId;
		this.accountId = accountId;
		this.status = status;
	}

	@Column(name = "history_id", nullable = false)
	public int getHistoryId() {
		return this.historyId;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

	@Column(name = "date", nullable = false, length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "quiz_id", nullable = false)
	public int getQuizId() {
		return this.quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	@Column(name = "account_id", nullable = false)
	public int getAccountId() {
		return this.accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof HistoryId))
			return false;
		HistoryId castOther = (HistoryId) other;

		return (this.getHistoryId() == castOther.getHistoryId())
				&& ((this.getDate() == castOther.getDate()) || (this.getDate() != null && castOther.getDate() != null
						&& this.getDate().equals(castOther.getDate())))
				&& (this.getQuizId() == castOther.getQuizId()) && (this.getAccountId() == castOther.getAccountId())
				&& (this.isStatus() == castOther.isStatus());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getHistoryId();
		result = 37 * result + (getDate() == null ? 0 : this.getDate().hashCode());
		result = 37 * result + this.getQuizId();
		result = 37 * result + this.getAccountId();
		result = 37 * result + (this.isStatus() ? 1 : 0);
		return result;
	}

}