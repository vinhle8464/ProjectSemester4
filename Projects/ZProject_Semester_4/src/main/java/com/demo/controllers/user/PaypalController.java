package com.demo.controllers.user;

import org.springframework.core.env.Environment;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.models.Account;
import com.demo.models.Pay;
import com.demo.paypals.PayPalConfig;
import com.demo.paypals.PayPalResult;
import com.demo.paypals.PayPalSucess;
import com.demo.services.user.EmailService;
import com.demo.services.user.PayService;

@Controller
@RequestMapping(value =  "user/paypal")
public class PaypalController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private EmailService mailService;
	
	@Autowired
	private PayService payService;
	
	@RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		Account account = new Account();
		
		String authtoken = environment.getProperty("paypal.authtoken");
		String posturl = environment.getProperty("paypal.posturl");
		String business = environment.getProperty("paypal.business");
		String returnurl = environment.getProperty("paypal.returnurl");
		
		modelMap.put("authtoken", authtoken);
		modelMap.put("posturl", posturl);
		modelMap.put("business", business);
		modelMap.put("returnurl", returnurl);
		modelMap.put("products", mailService.listProduct());
		modelMap.put("account", account);
		
		return "user/paypal/index";
	}
	
	@RequestMapping(value = "success", method = RequestMethod.GET)
	public String success(HttpServletRequest request, @ModelAttribute("account") Account account) {
		PayPalConfig payPalConfig = new PayPalConfig();
		
		String authtoken = environment.getProperty("paypal.authtoken");
		String posturl = environment.getProperty("paypal.posturl");
		String business = environment.getProperty("paypal.business");
		String returnurl = environment.getProperty("paypal.returnurl");
		
		payPalConfig.setAuthToken(authtoken);
		payPalConfig.setPosturl(posturl);
		payPalConfig.setBusiness(business);
		payPalConfig.setReturnurl(returnurl);
		
		PayPalResult result = PayPalSucess.getPayPal(request, payPalConfig);
		System.out.println("fist name: " + result.getFirst_name());
		System.out.println("last name: " + result.getLast_name());
		System.out.println("email: " + result.getPayer_email());
		System.out.println("country: " + result.getAddress_country());
		System.out.println("payment_date: " + result.getPayment_date());
		System.out.println("mc_fee: " + result.getMc_fee());
		System.out.println("business: " + result.getBusiness());
		System.out.println("payment_type: " + result.getPayment_type());
		
		account.setAccountId(3);
		account.setUsername("tran");
		account.setPassword("1");
		account.setFullname("ngoctran");
		account.setEmail("tran@gmail.com");
		Date birthday = new Date("01/04/2001");
		account.setDob(birthday);
		account.setAddr("Tay Ninh");
		account.setGender(false);
		account.setPhone("0999999999");
		account.setAvatar("148fa5fab32d4e669482caa8943cfd38.jpg");
		account.setStatus(true);
		
		Pay pay = new Pay();
		pay.setAccount(account);
		pay.setPayment("card");
		pay.setTitle(result.getPayment_fee());
		pay.setFee(15);
		pay.setDatePaid(new Date());
		pay.setPayStatus(true);
		
		payService.save(pay);
		
		return "user/paypal/success";
	}
}
