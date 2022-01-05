package com.demo.repositories.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entites.PayAjax;
import com.demo.models.Pay;

@Repository
public interface PayRepositoryAdmin extends JpaRepository<Pay, Integer> {


	@Query("select new com.demo.entites.PayAjax(payId, account.accountId, account.username, payment, title, fee, datePaid, payStatus) from Pay where payId = :payId")
	public PayAjax findByIdAjax(@Param("payId") int payId);
	
}
