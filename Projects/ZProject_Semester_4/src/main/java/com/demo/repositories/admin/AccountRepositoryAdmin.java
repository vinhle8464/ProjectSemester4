package com.demo.repositories.admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.models.Account;
import com.demo.entites.AccountAjax;

@Repository
public interface AccountRepositoryAdmin extends JpaRepository<Account, Integer> {

	@Query("from Account where username = :username")
	public Account findByUsername(@Param("username") String username);

	@Query("select new com.demo.entites.AccountAjax(accountId, username, password, fullname, email, dob, addr, gender, phone, avatar, status, createDate) from Account where accountId = :accountId")
	public AccountAjax findByIdAjax(@Param("accountId") int accountId);

	@Query("select new com.demo.entites.AccountAjax(accountId, username, password, fullname, email, dob, addr, gender, phone, avatar, status, createDate) from Account where year(createDate) = :year and month(createDate) = :month")
	public List<AccountAjax> findThisYear(@Param("year") int year,@Param("month") int month);
}
