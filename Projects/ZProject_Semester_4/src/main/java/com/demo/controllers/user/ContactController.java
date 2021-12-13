package com.demo.controllers.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.models.Email;
import com.demo.services.user.EmailService;

@Controller
@RequestMapping(value =  "user/contact")
public class ContactController {

	@Autowired
	private EmailService mailService;
	
	@RequestMapping(value = {"","index"}, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		Email email = new Email();
		modelMap.put("email", email);
		return "user/contact/index";
	}
	
	@RequestMapping(value = "sendContact", method = RequestMethod.POST)
	public String sendContact(ModelMap modelMap, @ModelAttribute("email") Email email) {
		
		email.setSendDate(new Date());
		
		mailService.save(email);
		return "user/contact/success";
	}
}
