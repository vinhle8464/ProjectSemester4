package com.demo.services.user;

import java.util.List;

import com.demo.models.Role;
public interface RoleServiceUser {

		public Role find(String roleId);
		
		public List<Role> findAllRole();
		
}
