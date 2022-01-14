package com.demo.repositories.user;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.models.Quiz;

@Repository
public interface CourseRepository extends CrudRepository<Quiz, Integer>{

//	@Query("from Quiz where category.categoryId=:categoryId")
//	public List<Quiz> findAllQuizByCategoryId(@Param("categoryId") int categoryId);
//	
	@Query(value = "SELECT * FROM quiz q WHERE q.category_id = ?1",
		    nativeQuery = true)
	public Page<Quiz> getAllQuizByCategoryId(int category_id, Pageable pageable);
	
	
}
