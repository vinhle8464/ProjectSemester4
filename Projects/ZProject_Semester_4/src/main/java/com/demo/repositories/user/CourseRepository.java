package com.demo.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.models.Quiz;

@Repository
public interface CourseRepository extends CrudRepository<Quiz, Integer>{

	@Query("from Quiz where category.categoryId=:categoryId")
	public List<Quiz> findAllQuizByCategoryId(@Param("categoryId") int categoryId);
	
	
}
