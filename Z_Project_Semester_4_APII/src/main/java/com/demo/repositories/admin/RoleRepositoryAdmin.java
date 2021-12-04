package com.demo.repositories.admin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.models.Account;
import com.demo.models.Role;

@Repository
public interface RoleRepositoryAdmin extends CrudRepository<Role, Integer> {

}
