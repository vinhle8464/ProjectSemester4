package com.demo.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.models.Account;
import com.demo.models.AccountAjax;
import com.demo.models.Product;
import com.demo.services.admin.AccountServiceAdmin;

@RestController
@RequestMapping("admin/ajax")
public class AjaxController {

	@Autowired
	private AccountServiceAdmin accountServiceAdmin;
	
	@RequestMapping(value = {"findaccountbyid"}, method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public AccountAjax findAccountById(@RequestParam("accountId") int accountId) {
		
		return accountServiceAdmin.findByIdAjax(accountId);
		
	}

}
