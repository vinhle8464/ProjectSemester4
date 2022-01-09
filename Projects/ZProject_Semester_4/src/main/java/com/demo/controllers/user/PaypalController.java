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
