package com.demo.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.models.Account;
import com.demo.services.admin.AccountServiceAdmin;

@RestController
@RequestMapping("admin/ajax")
public class AjaxController {

	@Autowired
	private AccountServiceAdmin accountServiceAdmin;
	
	@RequestMapping(value = {"findaccountbyid"}, method = RequestMethod.POST, produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public Account findAccountById(@RequestParam("accountId") int accountId) {
		
		return accountServiceAdmin.find(accountId);
		
	}
}
