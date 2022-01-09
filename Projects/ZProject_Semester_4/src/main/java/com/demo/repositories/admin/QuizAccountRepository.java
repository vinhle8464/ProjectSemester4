package com.demo.repositories.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.entites.QuizAccountAjax;

public interface QuizAccountRepository extends JpaRepository<com.demo.models.Quiz, Integer>{
	
//	@Query("select new com.demo.entites.QuizAccountAjax(quizId, title, description, times, timer, fee, status) from Quiz where account.accountId = :accountId")
//	public QuizAccountAjax findByAccountIdAjax(@Param("accountId") int accountId);
}
