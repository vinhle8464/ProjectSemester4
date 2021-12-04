package com.demo.services;

import java.util.List;

import com.demo.models.Role;
import com.demo.models.RoleInfo;

public interface RoleService {

		public RoleInfo find(String roleId);
		
		public List<RoleInfo> findAllRole();
		
}
