package com.demo.repositories.admin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.models.Pay;

@Repository
public interface PayRepositoryAdmin extends CrudRepository<Pay, Integer> {

}
