package com.demo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.paypals.PayPalConfig;
import com.demo.paypals.PayPalResult;
import com.demo.paypals.PayPalSucess;

@Controller
@RequestMapping(value = {"","demo"})
public class DemoController {

	@Autowired
	private Environment environment;
	
//	@Autowired
//	private ProductService productService;
//	
	@RequestMapping(value = {"","index"}, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		
		
		//modelMap.put("products", productService.findAll());
		modelMap.put("authtoken", environment.getProperty("paypal.authtoken"));
		modelMap.put("posturl", environment.getProperty("paypal.posturl"));
		modelMap.put("business", environment.getProperty("paypal.business"));
		modelMap.put("returnurl", environment.getProperty("paypal.returnurl"));
		return "demo/index";
	}
	
	//http://localhost:9799/demo/success?amt=33.00&cc=USD&st=Pending&tx=4C04172082468401T
	@RequestMapping(value = {"success"}, method = RequestMethod.GET)
	public String success(HttpServletRequest request) {
		PayPalConfig payPalConfig = new PayPalConfig();
		String authtoken = environment.getProperty("paypal.authtoken");
		
		String posturl = environment.getProperty("paypal.posturl");
	
		String business = environment.getProperty("paypal.business");
		
		String returnurl = environment.getProperty("paypal.returnurl");
		
		payPalConfig.setAuthToken(authtoken);
		payPalConfig.setBusiness(business);
		payPalConfig.setReturnurl(returnurl);
		payPalConfig.setPosturl(posturl);
		
		PayPalResult result = PayPalSucess.getPayPal(request, payPalConfig);
		System.out.println("first name: " + result.getFirst_name());
		System.out.println("last name: " + result.getLast_name());
		System.out.println("email: " + result.getPayer_email());
		System.out.println("country: " + result.getAddress_country());
		System.out.println("city: " + result.getAddress_city());
		
		return "demo/success";
	}
}
