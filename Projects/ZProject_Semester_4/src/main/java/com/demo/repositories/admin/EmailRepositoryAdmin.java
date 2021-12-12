package com.demo.repositories.admin;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmailRepositoryAdmin extends CrudRepository<com.demo.models.Email, Integer> {

}
