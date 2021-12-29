package com.demo.controllers.admin;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.helpers.UploadHelper;
import com.demo.models.Account;
import com.demo.services.AccountService;

@Controller
@RequestMapping(value = {"admin/profile"})
public class ProfileAdminController {
	
	@Autowired
	private AccountService accountService;


	@RequestMapping(value = {"","index"}, method = RequestMethod.GET)
	public String index(ModelMap modelMap, Authentication authentication) {
		Account account = accountService.findByUsername(authentication.getName());
		modelMap.put("account", account);
		modelMap.put("accountUsername", accountService.findByUsername(authentication.getName()));
		return "admin/profile/index";
	}
	
	@RequestMapping(value = "editProfile", method = RequestMethod.GET)
	public String editProfile(ModelMap modelMap, Authentication authentication) {
		modelMap.put("accountUsername", accountService.findByUsername(authentication.getName()));
		return "admin/profile/edit";
	}
	
	@RequestMapping(value = "editProfile", method = RequestMethod.POST)
	public String editProfile(ModelMap modelMap, @ModelAttribute("accountUsername") Account account, @RequestParam("id") int id) {
		Account accountNew = accountService.findById(id);
		accountNew.setFullname(account.getFullname());
		accountNew.setEmail(account.getEmail());
		accountNew.setDob(account.getDob());
		accountNew.setAddr(account.getAddr());
		accountNew.setPhone(account.getPhone());

		accountService.update(accountNew);
		return "redirect:/admin/profile/index";
	}
}
