package com.demo.services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.Quiz;
import com.demo.repositories.user.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository courseRepository;

	
	@Override
	public List<Quiz> findAllQuizByCategoryId(int categoryId) {
		return courseRepository.findAllQuizByCategoryId(categoryId);
	}
	
	

}
