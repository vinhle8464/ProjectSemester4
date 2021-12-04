package com.demo.services;

import org.springframework.data.repository.query.Param;

import com.demo.models.Account;
import com.demo.models.AccountInfo;
import com.demo.models.AccountInfoCreate;

public interface AccountService {

	public AccountInfo findByUsername(String username);

	public Account find(int id);

	public AccountInfo create(AccountInfoCreate accountInfoCreate);

	public AccountInfo update(int id, AccountInfo accountInfo);

	public void delete(int id);

}
