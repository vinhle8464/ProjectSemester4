package com.demo.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.models.Account;
import com.demo.models.AccountInfo;
import com.demo.models.RoleInfo;

@Repository
public interface AccountRepositoryUser extends CrudRepository<Account, Integer> {

	@Query("from Account where username = :username")
	public Account findByUsername(@Param("username") String username);
	
	@Query("select new com.demo.models.AccountInfo(accountId, roleId, username, password, fullname, email, dob, addr, gender, phone, avatar, status, roles) from Account")
	public List<AccountInfo> findAllAccount();
	
}
