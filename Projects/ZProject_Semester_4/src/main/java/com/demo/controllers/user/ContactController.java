 package com.demo.controllers.user;

import java.io.IOException;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.configurations.MyConstants;
import com.demo.models.Email;
import com.demo.services.user.EmailService;

@Controller
@RequestMapping(value =  "user/contact")
public class ContactController {

	@Autowired
	private EmailService mailService;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@RequestMapping(value = {"","index"}, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		Email email = new Email();
		modelMap.put("email", email);
		return "user/contact/index";
	}
	
	@ResponseBody
	@RequestMapping(value = "sendContact", method = RequestMethod.POST)
	public String sendContact(ModelMap modelMap, @ModelAttribute("email") Email email) {
		
		SimpleMailMessage message = new SimpleMailMessage();
        
        message.setTo(email.getEmailUser());
        message.setSubject(email.getTitle());
        message.setText(email.getContent());

        
     // Send Message!
        javaMailSender.send(message);
		
		email.setSendDate(new Date());
		mailService.save(email);
		return "user/contact/success";
	}
	
	@RequestMapping(value = "success", method = RequestMethod.POST)
	public String success() {
		// hello
		
		return "user/contact/success";
	}
}
