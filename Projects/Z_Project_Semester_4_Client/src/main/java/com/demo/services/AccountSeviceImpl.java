package com.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.models.Account;
import com.demo.models.Role;

@Service
public class AccountSeviceImpl implements AccountService{
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			
			AccountAPIService accountAPIService = APIClient.getClient().create(AccountAPIService.class);
			Account account = accountAPIService.findById(username); // get account from accountapi
			
			// get list role of account
			if(account == null) {
				throw new UsernameNotFoundException("UsernameNotFound");
			}else {
				List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
				for (Role role : account.getRoles()) {
					grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
				}
				return new User(account.getUsername(), account.getPassword(), grantedAuthorities);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
