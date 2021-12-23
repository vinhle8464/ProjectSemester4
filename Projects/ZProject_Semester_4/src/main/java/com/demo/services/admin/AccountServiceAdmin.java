package com.demo.services.admin;

import java.util.List;

import org.springframework.data.domain.Page;


import com.demo.models.Account;
import com.demo.models.AccountAjax;

public interface AccountServiceAdmin {

	public Account findByUsername(String username);
	
	public List<Account> findAllAccount();

	public Account findById(int id);

	public Account create(Account account);

	public Account update(Account account);

	public void deleteById(int id);

	public AccountAjax findByIdAjax(int accountId);
	

	public Page<Account> getPage(int currentPage, int pageSize, String sort);

}
