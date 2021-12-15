package com.demo.services.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.Account;
import com.demo.repositories.user.AccountRepositoryUser;

@Service
public class AccountSeviceAdminImpl implements AccountServiceAdmin{

	@Autowired
	private AccountRepositoryUser accountRepository;
	
	@Override
	public Account findByUsername(String username) {
		
		return accountRepository.findByUsername(username);
	}
	
	@Override
	public Account find(int id) {
		return accountRepository.findById(id).get();
	}
	
	// this method was not be completed!
	@Override
	public Account create(Account account) {
		account.setStatus(true);
		return accountRepository.save(account);
	}
	
	// this method was not be completed!
	@Override
	public Account update(Account account) {
		
		return accountRepository.save(account);
		
	}

	@Override
	public void delete(int id) {
		accountRepository.deleteById(id);
	}

	@Override
	public List<Account> findAllAccount() {
		
		return (List<Account>) accountRepository.findAll();
	}

}
