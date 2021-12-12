package com.demo.services.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.Email;
import com.demo.models.Pay;
import com.demo.models.Role;
import com.demo.repositories.admin.EmailRepositoryAdmin;
import com.demo.repositories.admin.PayRepositoryAdmin;
import com.demo.repositories.admin.RoleRepositoryAdmin;
import com.demo.repositories.user.RoleRepositoryUser;

@Service
public class EmailSeviceAdminImpl implements EmailServiceAdmin{

	@Autowired
	private EmailRepositoryAdmin emailRepositoryAdmin;

	@Override
	public Email find(int mailId) {
		return emailRepositoryAdmin.findById(mailId).get();
		
	}

	@Override
	public List<Email> findAllEmail() {
		return (List<Email>) emailRepositoryAdmin.findAll();
	}
	
	
	

}
