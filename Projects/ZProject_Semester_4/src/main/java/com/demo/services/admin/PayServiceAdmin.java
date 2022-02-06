package com.demo.services.admin;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.demo.entites.PayAjax;
import com.demo.models.Pay;
public interface PayServiceAdmin {

	public List<Pay> findAllPay();

	public Pay findById(int id);

	public Pay create(Pay Pay);

	public Pay update(Pay Pay);

	public void deleteById(int id);

	public PayAjax findByIdAjax(int PayId);
	
	public List<PayAjax> findThisYear(int year, int month);
	
	public Page<Pay> getPage(int currentPage, int pageSize, String sort);
		
	public double sumadminsalarybyyearandmonth(int year,int month);
}
