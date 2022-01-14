package com.demo.controllers.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.models.Account;
import com.demo.services.AccountService;
import com.demo.services.admin.CategoryServiceAdmin;

@Controller
@RequestMapping(value = {"user/profile"})
public class ProfileController {

	@Autowired
	private CategoryServiceAdmin categoryServiceAdmin;
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "index/{id}", method = RequestMethod.GET)
	public String register(ModelMap modelMap, @PathVariable("id") int id) {
		modelMap.put("categories", categoryServiceAdmin.findAllCategory());
		Account account = new Account();
		account.setDob(new Date());
		modelMap.put("account", account);
		
		// Page Profile
		Account accountProfile = accountService.findById(id);
		modelMap.put("accountProfile", accountProfile);
		
		return "user/profile/index";
	}
}
