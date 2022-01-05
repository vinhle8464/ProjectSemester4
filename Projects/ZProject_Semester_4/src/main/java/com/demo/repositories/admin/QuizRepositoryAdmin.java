package com.demo.repositories.admin;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entites.EmailAjax;


@Repository
public interface QuizRepositoryAdmin extends JpaRepository<com.demo.models.Quiz, Integer> {

	@Query("select new com.demo.entites.EmailAjax(emailId, title, emailUser, fullname, phoneNumber, content, replyContent, sendDate, replyDate, checked, status) from Email where emailId = :emailId")
	public EmailAjax findByIdAjax(@Param("emailId") int emailId);
	
	
	
}
