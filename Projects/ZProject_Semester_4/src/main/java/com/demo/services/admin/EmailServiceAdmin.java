package com.demo.services.admin;

import java.util.List;

import com.demo.models.Email;
public interface EmailServiceAdmin {

		public Email find(int mailId);
		
		public List<Email> findAllEmail();
		
}
