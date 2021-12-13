package com.demo.controllers.user;

import org.springframework.core.env.Environment;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.paypals.PayPalConfig;
import com.demo.paypals.PayPalResult;
import com.demo.paypals.PayPalSucess;
import com.demo.services.user.EmailService;

@Controller
@RequestMapping(value =  "user/paypal")
public class PaypalController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private EmailService mailService;
	
	// method index
	@RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		String authtoken = environment.getProperty("paypal.authtoken");
		String posturl = environment.getProperty("paypal.posturl");
		String business = environment.getProperty("paypal.business");
		String returnurl = environment.getProperty("paypal.returnurl");
		
		modelMap.put("authtoken", authtoken);
		modelMap.put("posturl", posturl);
		modelMap.put("business", business);
		modelMap.put("returnurl", returnurl);
		modelMap.put("products", mailService.listProduct());
		
		return "user/paypal/index";
	}
	
	@RequestMapping(value = "success", method = RequestMethod.GET)
	public String success(ModelMap modelMap, HttpServletRequest request) {
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
		System.out.println("city: " + result.getAddress_city());
		
		return "user/paypal/success";
	}
}
