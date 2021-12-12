package com.demo.repositories.admin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.models.Mail;

@Repository
public interface EmailRepositoryAdmin extends CrudRepository<Mail, Integer> {

}
