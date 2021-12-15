package com.demo.services.user;

import java.util.List;

import com.demo.models.Email;
import com.demo.models.Product;

public interface EmailService {

	public Email save(Email email);
	
	public List<Product> listProduct();
}
