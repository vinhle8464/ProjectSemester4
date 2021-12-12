package com.demo.services.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.Role;
import com.demo.repositories.admin.RoleRepositoryAdmin;
import com.demo.repositories.user.RoleRepositoryUser;

@Service
public class PaySeviceAdminImpl implements PayServiceAdmin{

	@Autowired
	private RoleRepositoryUser roleRepositoryUser;

	@Override
	public Role find(String roleId) {
		return roleRepositoryUser.findById(roleId);
		
	}

	@Override
	public List<Role> findAllRole() {
		return (List<Role>) roleRepositoryUser.findAll();
	}
	
	
	

}
