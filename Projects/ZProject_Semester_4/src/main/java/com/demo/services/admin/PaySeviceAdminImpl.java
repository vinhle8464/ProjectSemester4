package com.demo.services.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.Pay;
import com.demo.models.Role;
import com.demo.repositories.admin.PayRepositoryAdmin;
import com.demo.repositories.admin.RoleRepositoryAdmin;
import com.demo.repositories.user.RoleRepositoryUser;

@Service
public class PaySeviceAdminImpl implements PayServiceAdmin{

	@Autowired
	private PayRepositoryAdmin payRepositoryAdmin;

	@Override
	public Pay find(int payId) {
		return payRepositoryAdmin.findById(payId).get();
		
	}

	@Override
	public List<Pay> findAllPay() {
		return (List<Pay>) payRepositoryAdmin.findAll();
	}
	
	
	

}
