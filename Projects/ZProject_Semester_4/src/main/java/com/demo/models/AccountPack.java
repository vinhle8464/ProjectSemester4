package com.demo.models;
// Generated Dec 29, 2021, 9:30:54 PM by Hibernate Tools 5.1.10.Final

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AccountPack generated by hbm2java
 */
@Entity
@Table(name = "account_pack", catalog = "dbproject4")
public class AccountPack implements java.io.Serializable {

	private AccountPackId id;
	private Account account;
	private Pack pack;
	private Date startDate;
	private boolean status;

	public AccountPack() {
	}

	public AccountPack(AccountPackId id, Account account, Pack pack, Date startDate, boolean status) {
		this.id = id;
		this.account = account;
		this.pack = pack;
		this.startDate = startDate;
		this.status = status;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "accountId", column = @Column(name = "account_id", nullable = false)),
			@AttributeOverride(name = "packId", column = @Column(name = "pack_id", nullable = false)) })
	public AccountPackId getId() {
		return this.id;
	}

	public void setId(AccountPackId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", nullable = false, insertable = false, updatable = false)
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pack_id", nullable = false, insertable = false, updatable = false)
	public Pack getPack() {
		return this.pack;
	}

	public void setPack(Pack pack) {
		this.pack = pack;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date", nullable = false, length = 10)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
