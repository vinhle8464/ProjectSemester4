package com.demo.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AccountInfo {

	private String accountId;
	private String username;
	private String password;
	private String fullname;
	private String email;
	
	@JsonFormat(pattern = "dd/MM/yyy")
	private Date dob;
	private String addr;
	private boolean gender;
	private String phone;
	private String avatar;
	private boolean status;
	
	public AccountInfo() {
		super();
	}


	public AccountInfo(String accountId, String username, String password, String fullname, String email,
			Date dob, String addr, boolean gender, String phone, String avatar, boolean status) {
		super();
		this.accountId = accountId;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.dob = dob;
		this.addr = addr;
		this.gender = gender;
		this.phone = phone;
		this.avatar = avatar;
		this.status = status;
	}


	public AccountInfo(Account account) {
		this.accountId = account.getAccountId();
		this.username = account.getUsername();
		this.password = account.getPassword();
		this.fullname = account.getFullname();
		this.email = account.getEmail();
		this.dob = account.getDob();
		this.addr = account.getAddr();
		this.gender = account.isGender();
		this.phone = account.getPhone();
		this.avatar = account.getAvatar();
		this.status = account.isStatus();
		
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
}
