package com.demo.services;

import java.util.List;


import com.demo.models.Account;
import com.demo.models.AccountInfo;
import com.demo.models.AccountInfoCreate;

public interface AccountService {

	public AccountInfo findByUsername(String username);
	
	public List<AccountInfo> findAllAccount();

	public Account find(int id);

	public AccountInfo create(AccountInfoCreate accountInfoCreate);

	public AccountInfo update(int id, AccountInfo accountInfo);

	public void delete(int id);

}
