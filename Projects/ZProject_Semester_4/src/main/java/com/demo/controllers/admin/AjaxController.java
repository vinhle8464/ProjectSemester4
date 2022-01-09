package com.demo.controllers.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entites.AccountAjax;
import com.demo.entites.CategoryAjax;
import com.demo.entites.EmailAjax;
import com.demo.entites.PackAjax;
import com.demo.entites.PayAjax;
import com.demo.entites.RoleAjax;
import com.demo.models.Pack;
import com.demo.services.admin.AccountServiceAdmin;
import com.demo.services.admin.CategoryServiceAdmin;
import com.demo.services.admin.EmailServiceAdmin;
import com.demo.services.admin.PackServiceAdmin;
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
	
	@Autowired
	private PackServiceAdmin packServiceAdmin;
	
	@Autowired
	private CategoryServiceAdmin categoryServiceAdmin;
	
	
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

	@RequestMapping(value = {"findpackbyid"}, method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public PackAjax findPackById(@RequestParam("packId") int packId) {
		
		return packServiceAdmin.findByIdAjax(packId);
		
	}
	
	@RequestMapping(value = {"findcategorybyid"}, method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public CategoryAjax findCategoryById(@RequestParam("categoryId") int categoryId) {
		
		return categoryServiceAdmin.findByIdAjax(categoryId);
		
	}

}
