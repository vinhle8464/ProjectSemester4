package com.demo.services.user;

import java.util.List;

import org.springframework.data.domain.Page;

import com.demo.models.Quiz;
public interface CourseService {

//	public List<Quiz> findAllQuizByCategoryId(int categoryId);
//	
	
	public Page<Quiz> getAllQuizByCategoryId(int currentPage, int pageSize, String sort, int categoryId);
	
	
}
