package com.demo.services.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import com.demo.models.Quiz;
import com.demo.models.Role;
import com.demo.entites.QuizAjax;
import com.demo.entites.RoleAjax;
import com.demo.repositories.admin.QuizAccountRepository;
import com.demo.repositories.admin.QuizRepositoryAdmin;
import com.demo.repositories.admin.RoleRepositoryAdmin;

@Service
public class QuizAccountServiceAdminImpl implements QuizAccountServiceAdmin{

	@Autowired
	private QuizAccountRepository quizAccountRepository;
	
	@Override
	public List<Quiz> findAllQuiz(int accountId) {
		return (List<Quiz>) quizAccountRepository.findByAccountIdAjax(accountId);
	}

	

}
