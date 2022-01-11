package com.demo.services.faculty;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.demo.entites.QuizAjax;
import com.demo.models.Answer;
import com.demo.models.Question;
import com.demo.models.Quiz;
import com.demo.repositories.admin.QuizRepositoryAdmin;
import com.demo.repositories.faculty.AnswerRepositoryFaculty;
import com.demo.repositories.faculty.QuestionRepositoryFaculty;

@Service
public class AnswerSeviceFacultyImpl implements AnswerServiceFaculty{

	@Autowired
	private AnswerRepositoryFaculty answerRepositoryFaculty;

//	@Override
//	public Quiz findById(int id) {
//		return QuizRepositoryAdmin.findById(id).get();
//	}
	
	// this method was not be completed!
	@Override
	public Answer create(Answer answer) {
		return answerRepositoryFaculty.save(answer);
	}
	
	// this method was not be completed!
//	@Override
//	public Quiz update(Quiz Quiz) {
//		
//		return QuizRepositoryAdmin.save(Quiz);
//		
//	}
//
//	@Override
//	public void deleteById(int id) {
//		QuizRepositoryAdmin.deleteById(id);
//	}
//
//	@Override
//	public List<Quiz> findAllQuiz() {
//		
//		return (List<Quiz>) QuizRepositoryAdmin.findAll();
//
//	}

	
	

}