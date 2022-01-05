package com.demo.services.faculty;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.demo.entites.QuizAjax;
import com.demo.models.Quiz;
import com.demo.repositories.admin.QuizRepositoryAdmin;

@Service
public class QuizSeviceFacultyImpl implements QuizServiceFaculty{

	@Autowired
	private QuizRepositoryAdmin QuizRepositoryAdmin;

	@Override
	public Quiz findById(int id) {
		return QuizRepositoryAdmin.findById(id).get();
	}
	
	// this method was not be completed!
	@Override
	public Quiz create(Quiz Quiz) {
		Quiz.setStatus(true);
		return QuizRepositoryAdmin.save(Quiz);
	}
	
	// this method was not be completed!
	@Override
	public Quiz update(Quiz Quiz) {
		
		return QuizRepositoryAdmin.save(Quiz);
		
	}

	@Override
	public void deleteById(int id) {
		QuizRepositoryAdmin.deleteById(id);
	}

	@Override
	public List<Quiz> findAllQuiz() {
		
		return (List<Quiz>) QuizRepositoryAdmin.findAll();

	}


//	@Override
//	public QuizAjax findByIdAjax(int QuizId) {
//		return QuizRepositoryAdmin.findByIdAjax(QuizId);
//	}

	 public Page<Quiz> getPage(int currentPage, int pageSize, String sort){
		 Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by(sort).descending());
			return this.QuizRepositoryAdmin.findAll(pageable);
	    }

	
	
	

}
