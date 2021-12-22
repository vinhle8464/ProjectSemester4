package com.demo.repositories.admin;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.demo.models.Account;
import com.demo.models.AccountAjax;

@Repository
public interface AccountRepositoryAdmin extends JpaRepository<Account, Integer> {

	@Query("from Account where username = :username")
	public Account findByUsername(@Param("username") String username);
	
	
	@Query("select new com.demo.models.AccountAjax(accountId, username, password, fullname, email, dob, addr, gender, phone, avatar, status) from Account where accountId = :accountId")
	public AccountAjax findByIdAjax(@Param("accountId") int accountId);
	
//	 Page<Account> findByFullname(String fullname, Pageable pageable);
//
//	  Page<Account> findByUsernameContaining(String username, Pageable pageable);
//	  
//	  List<Account> findByUsernameContaining(String username, Sort sort);
	
}
