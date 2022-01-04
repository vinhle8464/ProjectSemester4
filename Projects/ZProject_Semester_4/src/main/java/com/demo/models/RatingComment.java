package com.demo.models;
// Generated Dec 29, 2021, 9:30:54 PM by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RatingComment generated by hbm2java
 */
@Entity
@Table(name = "rating_comment", catalog = "dbproject4")
public class RatingComment implements java.io.Serializable {

	private Integer ratingCommentId;
	private Account account;
	private Quiz quiz;
	private byte star;
	private String comment;
	private boolean status;

	public RatingComment() {
	}

	public RatingComment(Account account, Quiz quiz, byte star, String comment, boolean status) {
		this.account = account;
		this.quiz = quiz;
		this.star = star;
		this.comment = comment;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "rating_comment_id", unique = true, nullable = false)
	public Integer getRatingCommentId() {
		return this.ratingCommentId;
	}

	public void setRatingCommentId(Integer ratingCommentId) {
		this.ratingCommentId = ratingCommentId;
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

	@Column(name = "star", nullable = false)
	public byte getStar() {
		return this.star;
	}

	public void setStar(byte star) {
		this.star = star;
	}

	@Column(name = "comment", nullable = false, length = 65535)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}