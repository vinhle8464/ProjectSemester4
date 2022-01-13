package com.demo.services.user;

import java.util.List;

import com.demo.models.Quiz;
public interface CourseService {

	public List<Quiz> findAllQuizByCategoryId(int categoryId);
	
	
	
	
}
