package com.demo.controllers.admin;

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

import com.demo.models.Pay;
import com.demo.services.AccountService;
import com.demo.services.admin.PayServiceAdmin;

@Controller
@RequestMapping(value = {"admin/pay"})
public class PayAdminController {

	@Autowired
	private PayServiceAdmin payServiceAdmin;
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
	public String index(ModelMap modelMap, Model model, Authentication authentication) {
		
		modelMap.put("accountUsername", accountService.findByUsername(authentication.getName()));
		return pagination(1, 5, "payId", modelMap, model, authentication);
		
	}
	
	
	
	@RequestMapping(value = { "create" }, method = RequestMethod.POST)
	public String create(@ModelAttribute("pay") Pay pay, ModelMap modelMap) {
		
		payServiceAdmin.create(pay);

		return "redirect:/admin/pay/index";
	}

	@RequestMapping(value = { "edit" }, method = RequestMethod.PUT)
	public String edit(@ModelAttribute("pay") Pay pay) {

		
		payServiceAdmin.update(pay);

		return "redirect:/admin/pay/index";
	}

	@RequestMapping(value = { "delete" }, method = RequestMethod.GET)
	public String delete(@RequestParam("payID") int payID) {

		payServiceAdmin.deleteById(payID);

		return "redirect:/admin/pay/index";
	}

	
	
	@RequestMapping(value = {"pagination"}, method = RequestMethod.GET)
	public String pagination(@RequestParam(name = "currentPage") int currentPage, @RequestParam(name = "pageSize") int pageSize, @RequestParam(name = "sort") String sort,
			ModelMap modelMap, Model model, Authentication authentication) {
		
		modelMap.put("accountUsername", accountService.findByUsername(authentication.getName()));
		
		int pageSizee = pageSize;

		Page<Pay> pages = payServiceAdmin.getPage(currentPage, pageSizee, sort);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("totalElements", pages.getTotalElements());
		model.addAttribute("pageSize", pageSizee);
		model.addAttribute("sort", sort);
		model.addAttribute("pays", pages.getContent());

		Pay pay = new Pay();		
		modelMap.put("pay", pay);


		return "admin/pay/index";
	}

}
