package com.demo.models;

import java.util.HashSet;
import java.util.Set;

public class Role {

	private String roleId;
	private String roleName;
	private String description;
	private boolean status;

	public Role(String roleId, String roleName, String description, boolean status) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.description = description;
		this.status = status;
	}

	public Role() {
		super();
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
