package com.demo.repositories.faculty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entites.QuizAjax;
import com.demo.models.Quiz;

@Repository
public interface QuizRepositoryFaculty extends JpaRepository<Quiz, Integer> {

//	@Query("select new com.demo.entites.QuizAjax(quizId, title, account.fullname, description, times, timer, fee, status) from Quiz where account.accountId = :accountId")
//	public List<QuizAccountAjax> findByAccountIdAjax(@Param("accountId") int accountId);	
	
	@Query("select new com.demo.entites.QuizAjax(quizId, category.categoryId, category.title, title, description, times, timer, fee, status) from Quiz where quizId = :quizId")
	public QuizAjax findByIdAjax(@Param("quizId") int quizId);
	
	
	
	
	
}
