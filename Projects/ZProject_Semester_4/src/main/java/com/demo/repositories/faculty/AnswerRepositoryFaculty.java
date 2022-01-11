package com.demo.repositories.faculty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entites.PayAjax;
import com.demo.models.Answer;
import com.demo.models.Pay;
import com.demo.models.Quiz;

@Repository
public interface AnswerRepositoryFaculty extends JpaRepository<Answer, Integer> {


//	@Query("select new com.demo.entites.PayAjax(payId, account.accountId, account.username, payment, title, fee, datePaid, payStatus) from Pay where payId = :payId")
//	public PayAjax findByIdAjax(@Param("payId") int payId);
//	
}
