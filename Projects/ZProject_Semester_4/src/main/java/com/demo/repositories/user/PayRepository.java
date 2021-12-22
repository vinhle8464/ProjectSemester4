package com.demo.repositories.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.models.Pay;

@Repository
public interface PayRepository extends CrudRepository<Pay, Integer>{

}
