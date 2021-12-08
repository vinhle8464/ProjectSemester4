package com.demo.services.admin;

import java.util.List;

import com.demo.models.Role;
import com.demo.models.RoleInfo;

public interface RoleService {

		public RoleInfo find(String roleId);
		
		public List<RoleInfo> findAllRole();
		
}
