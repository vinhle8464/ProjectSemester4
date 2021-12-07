package com.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.Account;
import com.demo.models.AccountInfo;
import com.demo.models.AccountInfoCreate;
import com.demo.models.Role;
import com.demo.repositories.user.AccountRepositoryUser;

@Service
public class AccountSeviceImpl implements AccountService{

	@Autowired
	private AccountRepositoryUser accountRepository;
	
	@Override
	public AccountInfo findByUsername(String username) {
		
		return accountRepository.findByUsername(username);
	}
	
	@Override
	public Account find(int id) {
		return accountRepository.findById(id).get();
	}
	
	// this method was not be completed!
	@Override
	public AccountInfo create(AccountInfoCreate accountInfoCreate) {
		Account account = new Account();
		account.setAccountId(accountInfoCreate.getAccountId());
		
		return new AccountInfo(accountRepository.save(account));
	}
	
	// this method was not be completed!
	@Override
	public AccountInfo update(int id, AccountInfo accountInfo) {
		Account account = find(id);
		accountRepository.save(account);
		return new AccountInfo(account);
	}

	@Override
	public void delete(int id) {
		accountRepository.deleteById(id);
	}

	@Override
	public List<AccountInfo> findAllAccount() {
		
		return accountRepository.findAllAccount();
	}

}
