package com.demo.services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.demo.entites.QuizAccountAjax;
import com.demo.entites.QuizAjax;
import com.demo.models.Account;
import com.demo.models.Quiz;
import com.demo.repositories.admin.QuizRepositoryAdmin;
import com.demo.repositories.faculty.QuizRepositoryFaculty;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private QuizRepositoryFaculty quizRepositoryFaculty;

	
	@Override
	public List<Quiz> findAllQuizByCategoryId(int categoryId) {
		return quizRepositoryFaculty.findAllQuizByCategoryId(categoryId);
	}
	
	

}
