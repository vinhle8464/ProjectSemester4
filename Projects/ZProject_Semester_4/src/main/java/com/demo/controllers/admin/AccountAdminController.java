package com.demo.controllers.admin;


import javax.servlet.ServletContext;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.helpers.UploadHelper;
import com.demo.models.Account;
import com.demo.services.AccountService;
import com.demo.services.admin.AccountServiceAdmin;

@Controller
@RequestMapping(value = { "admin/account" })
public class AccountAdminController implements ServletContextAware {

	@Autowired
	private AccountServiceAdmin accountServiceAdmin;

	@Autowired
	private AccountService accountService;
	
	private ServletContext servletContext;

	@Override
	public void setServletContext(ServletContext servletContext) {

		this.servletContext = servletContext;

	}

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap, Model model, Authentication authentication) {
		modelMap.put("accountUsername", accountService.findByUsername(authentication.getName()));
		return pagination(1, 5, "accountId", modelMap, model, authentication);

	}

	@RequestMapping(value = { "create" }, method = RequestMethod.POST)
	public String create(@ModelAttribute("account") Account account, @RequestParam(value = "file") MultipartFile file,
			RedirectAttributes redirectAttributes, ModelMap modelMap) {
		if (accountServiceAdmin.findByUsername(account.getUsername().trim()) != null) {
			modelMap.put("accounts", accountServiceAdmin.findAllAccount());
			modelMap.put("account", account);
			modelMap.put("msg", "Username has already Existed!");
			return "admin/account/index";

		} else {
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

		if (account.getPassword().isEmpty()) {
			account.setPassword(accountServiceAdmin.findById(account.getAccountId()).getPassword());
		} else {

			account.setPassword(BCrypt.hashpw(account.getPassword(), BCrypt.gensalt()));
		}
		accountServiceAdmin.update(account);

		return "redirect:/admin/account/index";
	}

	@RequestMapping(value = { "delete" }, method = RequestMethod.GET)
	public String delete(@RequestParam("accountID") int accountID) {

		accountServiceAdmin.deleteById(accountID);

		return "redirect:/admin/account/index";
	}

	


	@RequestMapping(value = {"pagination"}, method = RequestMethod.GET)
	public String pagination(@RequestParam(name = "currentPage") int currentPage, @RequestParam(name = "pageSize") int pageSize, @RequestParam(name = "sort") String sort,
			ModelMap modelMap, Model model, Authentication authentication) {
		modelMap.put("accountUsername", accountService.findByUsername(authentication.getName()));
		int pageSizee = pageSize;

		Page<Account> pages = accountServiceAdmin.getPage(currentPage, pageSizee, sort);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("totalElements", pages.getTotalElements());
		model.addAttribute("pageSize", pageSizee);
		model.addAttribute("sort", sort);
		model.addAttribute("accounts", pages.getContent());

		Account account = new Account();
		account.setGender(true);
		modelMap.put("account", account);

		// nothing 
		
		return "admin/account/index";
	}
}
