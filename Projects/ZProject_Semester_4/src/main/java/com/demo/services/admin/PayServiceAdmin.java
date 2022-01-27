package com.demo.services.admin;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.demo.entites.PayAjax;
import com.demo.models.Pay;
import com.demo.models.Salary;
public interface PayServiceAdmin {

	public List<Pay> findAllPay();

	public Pay findById(int id);

	public Pay create(Pay Pay);

	public Pay update(Pay Pay);

	public void deleteById(int id);

	public PayAjax findByIdAjax(int PayId);
	

	public Page<Pay> getPage(int currentPage, int pageSize, String sort);
	public Page<Pay> searchByUsername(int currentPage, int pageSize, String sort, String username);
		
}
