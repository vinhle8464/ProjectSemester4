package com.demo.repositories.admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entites.QuizAjax;

@Repository
public interface QuizRepositoryAdmin extends JpaRepository<com.demo.models.Quiz, Integer> {

	@Query("select new com.demo.entites.QuizAjax(quizId, category.categoryId, category.title, title, description, times, timer, fee, image, status, dateCreated) from Quiz where quizId = :quizId")
	public QuizAjax findByIdAjax(@Param("quizId") int quizId);
	
	@Query("select new com.demo.entites.QuizAjax(quizId, category.categoryId, category.title, title, description, times, timer, fee, image, status, dateCreated) from Quiz")
	public List<QuizAjax> findAllAjaxByCategoryId();
	
	@Query("select new com.demo.entites.QuizAjax(quizId, category.categoryId, category.title, title, description, times, timer, fee, image, status, dateCreated) from Quiz where category.categoryId = :categoryId")
	public List<QuizAjax> findAjaxByCategoryId(@Param("categoryId") int categoryId);
	
	
}
