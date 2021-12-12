package com.demo.services.admin;

import java.util.List;

import com.demo.models.Role;
public interface PayServiceAdmin {

		public Role find(String roleId);
		
		public List<Role> findAllRole();
		
}
