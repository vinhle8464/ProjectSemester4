package com.demo.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Account {

	private String accountId;
	private String roleId;
	private String username;
	private String password;
	private String fullname;
	private String email;
	private Date dob;
	private String addr;
	private boolean gender;
	private String phone;
	private String avatar;
	private boolean status;
	private Set<Role> roles = new HashSet<Role>(0);
	private Set<Pay> pays = new HashSet<Pay>(0);

	public Account() {
	}

	public Account(String accountId, String roleId, String username, String password, String fullname, String email,
			Date dob, String addr, boolean gender, String phone, String avatar, boolean status) {
		this.accountId = accountId;
		this.roleId = roleId;
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

	public Account(String accountId, String roleId, String username, String password, String fullname, String email,
			Date dob, String addr, boolean gender, String phone, String avatar, boolean status, Set<Role> roles,
			Set<Pay> pays) {
		this.accountId = accountId;
		this.roleId = roleId;
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
		this.roles = roles;
		this.pays = pays;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Pay> getPays() {
		return pays;
	}

	public void setPays(Set<Pay> pays) {
		this.pays = pays;
	}

	
	
}
