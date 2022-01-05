package com.demo.controllers.admin;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.helpers.UploadHelper;
import com.demo.models.Account;
import com.demo.models.Role;
import com.demo.services.AccountService;
import com.demo.services.admin.RoleServiceAdmin;

@Controller
@RequestMapping(value = {"admin/role"})
public class RoleAdminController {

	@Autowired
	private RoleServiceAdmin roleServiceAdmin;
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
	public String index(ModelMap modelMap, Model model, Authentication authentication) {
		
		modelMap.put("accountUsername", accountService.findByUsername(authentication.getName()));
		return pagination(1, 5, "roleId", modelMap, model, authentication);
		
	}
	
	@RequestMapping(value = { "create" }, method = RequestMethod.POST)
	public String create(@ModelAttribute("role") Role role, ModelMap modelMap) {
		
		roleServiceAdmin.create(role);

		return "redirect:/admin/role/index";
	}

	@RequestMapping(value = { "edit" }, method = RequestMethod.PUT)
	public String edit(@ModelAttribute("role") Role role) {

		
		roleServiceAdmin.update(role);

		return "redirect:/admin/role/index";
	}

	@RequestMapping(value = { "delete" }, method = RequestMethod.GET)
	public String delete(@RequestParam("roleID") int roleID) {

		roleServiceAdmin.deleteById(roleID);

		return "redirect:/admin/role/index";
	}

	
	
	@RequestMapping(value = {"pagination"}, method = RequestMethod.GET)
	public String pagination(@RequestParam(name = "currentPage") int currentPage, @RequestParam(name = "pageSize") int pageSize, @RequestParam(name = "sort") String sort,
			ModelMap modelMap, Model model, Authentication authentication) {
		
		modelMap.put("accountUsername", accountService.findByUsername(authentication.getName()));
		
		int pageSizee = pageSize;

		Page<Role> pages = roleServiceAdmin.getPage(currentPage, pageSizee, sort);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("totalElements", pages.getTotalElements());
		model.addAttribute("pageSize", pageSizee);
		model.addAttribute("sort", sort);
		model.addAttribute("roles", pages.getContent());

		Role role = new Role();		
		modelMap.put("role", role);


		return "admin/role/index";
	}
}
