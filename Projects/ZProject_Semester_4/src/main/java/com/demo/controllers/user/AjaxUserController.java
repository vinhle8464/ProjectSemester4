package com.demo.controllers.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entites.AccountAjax;
import com.demo.services.user.AccountServiceUser;

@RestController
@RequestMapping("user/ajax")
public class AjaxUserController {
	
	@Autowired
	private AccountServiceUser accountServiceUser;

	@RequestMapping(value = {"sessionpackid"}, method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public void sessionPackId(@RequestParam("packId") int packId, HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("packId", packId);
		
	}
	
	@RequestMapping(value = {"findaccountbyid"}, method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public AccountAjax findAccountById(@RequestParam("accountId") int accountId) {
		
		return accountServiceUser.findByIdAjax(accountId);
		
	}
}
