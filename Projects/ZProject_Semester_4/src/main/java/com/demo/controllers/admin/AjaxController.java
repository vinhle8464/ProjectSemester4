package com.demo.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entites.AccountAjax;
import com.demo.entites.EmailAjax;
import com.demo.entites.PayAjax;
import com.demo.entites.RoleAjax;
import com.demo.services.admin.AccountServiceAdmin;
import com.demo.services.admin.EmailServiceAdmin;
import com.demo.services.admin.PayServiceAdmin;
import com.demo.services.admin.RoleServiceAdmin;

@RestController
@RequestMapping("admin/ajax")
public class AjaxController {

	@Autowired
	private AccountServiceAdmin accountServiceAdmin;
	
	@Autowired
	private RoleServiceAdmin roleServiceAdmin;
	
	@Autowired
	private PayServiceAdmin payServiceAdmin;
	
	
	@Autowired
	private EmailServiceAdmin emailServiceAdmin;
	
	
	
	@RequestMapping(value = {"findaccountbyid"}, method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public AccountAjax findAccountById(@RequestParam("accountId") int accountId) {
		
		return accountServiceAdmin.findByIdAjax(accountId);
		
	}

	@RequestMapping(value = {"findrolebyid"}, method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public RoleAjax findRoleById(@RequestParam("roleId") int roleId) {
		
		return roleServiceAdmin.findByIdAjax(roleId);
		
	}
	
	@RequestMapping(value = {"findpaybyid"}, method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public PayAjax findPayById(@RequestParam("payId") int payId) {
		
		return payServiceAdmin.findByIdAjax(payId);
		
	}
	
	@RequestMapping(value = {"findemailbyid"}, method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public EmailAjax findEmailById(@RequestParam("emailId") int emailId) {
		
		return emailServiceAdmin.findByIdAjax(emailId);
		
	}
	
//	@RequestMapping(value = {"findquizbyid"}, method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
//	public QuizAjax findQuizById(@RequestParam("quizId") int quizId) {
//		
//		return ;
//		
//	}
	
}
