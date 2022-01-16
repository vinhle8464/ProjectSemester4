package com.demo.repositories.user;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.models.History;
import com.demo.models.Quiz;

@Repository
public interface HistoryRepository extends CrudRepository<History, Integer>{

	@Query(value = "SELECT * FROM history h WHERE h.account_id = ?1",
		    nativeQuery = true)
	public Page<History> getAllQuizByAccountId(int account_id, Pageable pageable);
	
	
}
