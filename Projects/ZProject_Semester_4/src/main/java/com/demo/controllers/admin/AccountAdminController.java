package com.demo.controllers.admin;


import javax.servlet.ServletContext;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.helpers.UploadHelper;
import com.demo.models.Account;
import com.demo.services.admin.AccountServiceAdmin;

@Controller
@RequestMapping(value = {"admin/account"})
public class AccountAdminController implements ServletContextAware{

	@Autowired
	private AccountServiceAdmin accountServiceAdmin;
	
	private ServletContext servletContext;
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		
		this.servletContext = servletContext;
		
	}
	
	@RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		Account account = new Account();
		account.setGender(true);
		modelMap.put("accounts", accountServiceAdmin.findAllAccount());
		modelMap.put("account", account);
		return "admin/account/index";
	}
	
	@RequestMapping(value = { "create" }, method = RequestMethod.POST)
	public String create(@ModelAttribute("account") Account account, @RequestParam(value = "file") MultipartFile file, RedirectAttributes redirectAttributes, ModelMap modelMap) {
		if(accountServiceAdmin.findByUsername(account.getUsername().trim()) != null) {
			modelMap.put("accounts", accountServiceAdmin.findAllAccount());
			modelMap.put("account", account);
			modelMap.put("msg", "Username has already Existed!");
			return "admin/account/index";
			
		}else {
		String fileNameUpload = UploadHelper.upload(servletContext, file);
		redirectAttributes.addFlashAttribute("fileName", fileNameUpload);
		account.setPassword(BCrypt.hashpw(account.getPassword(), BCrypt.gensalt()));
		account.setAvatar(fileNameUpload);
		accountServiceAdmin.create(account);
		}
		
		return "redirect:/admin/account/index";
	}
	

	@RequestMapping(value = { "edit" }, method = RequestMethod.POST)
	public String edit(@ModelAttribute("account") Account account) {
		if(account.getPassword().isEmpty()) {
			account.setPassword(accountServiceAdmin.find(account.getAccountId()).getPassword());
		}else {
			account.setPassword(BCrypt.hashpw(account.getPassword(), BCrypt.gensalt()));
		}
		accountServiceAdmin.update(account);
		
		return "redirect:/admin/account/index";
	}

	@RequestMapping(value = { "delete" }, method = RequestMethod.GET)
	public String delete(@RequestParam("accountID") int accountID) {

		accountServiceAdmin.delete(accountID);

		return "redirect:/admin/account/index";
	}
	
}
