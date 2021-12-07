package com.demo.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class AccountInfoCreate {

	private String accountId;
	private String roleId;
	private String username;
	private String password;
	private String email;
	private String avatar;
	private boolean status;
	private Set<Role> roles = new HashSet<Role>(0);
	
	public AccountInfoCreate(String accountId, String roleId, String username, String password, String email,
			String avatar, boolean status, Set<Role> roles) {
		super();
		this.accountId = accountId;
		this.roleId = roleId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.avatar = avatar;
		this.status = status;
		this.roles = roles;
	}

	public AccountInfoCreate() {
		super();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
}
