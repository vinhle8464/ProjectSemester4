package com.demo.repositories.user;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.models.History;

@Repository
public interface HistoryRepository extends CrudRepository<History, Integer>{


	
}
