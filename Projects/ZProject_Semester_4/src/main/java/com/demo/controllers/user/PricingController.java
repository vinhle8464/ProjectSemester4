	package com.demo.controllers.user;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.models.Account;
import com.demo.models.AccountPack;
import com.demo.models.AccountPackId;
import com.demo.models.Pack;
import com.demo.models.Pay;
import com.demo.paypals.PayPalConfig;
import com.demo.paypals.PayPalResult;
import com.demo.paypals.PayPalSucess;
import com.demo.services.AccountService;
import com.demo.services.user.PayService;
import com.demo.services.user.PricingService;


@Controller
@RequestMapping(value = {"user/pricing"})
public class PricingController {
	
	@Autowired
	private PricingService pricingService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private PayService payService;
	
	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String register(ModelMap modelMap, Authentication authentication) {
		String authtoken = environment.getProperty("paypal.authtoken");
		String posturl = environment.getProperty("paypal.posturl");
		String business = environment.getProperty("paypal.business");
		String returnurl = environment.getProperty("paypal.returnurl");
		
		modelMap.put("authtoken", authtoken);
		modelMap.put("posturl", posturl);
		modelMap.put("business", business);
		modelMap.put("returnurl", returnurl);
		
		modelMap.put("packs", pricingService.findAll());
		modelMap.put("account", accountService.findByUsername(authentication.getName()));
		
		return "user/pricing/index";
	}


	@RequestMapping(value = "success", method = RequestMethod.GET)
	public String success(HttpServletRequest request, Authentication authentication) {
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
		
		System.out.println("getMc_currency: " + result.getMc_currency());
		System.out.println("Fee: " + request.getParameter("amt"));
		
		Account account = accountService.findByUsername(authentication.getName());
		
		Pay pay = new Pay();
		pay.setAccount(account);
		pay.setPayment("PAYPAL");
		pay.setTitle("PAYMENT PACK");
		pay.setFee(11);
		pay.setDatePaid(new Date());
		pay.setPayStatus(true);
		payService.save(pay);
		
		AccountPackId accountPackId = new AccountPackId();
		accountPackId.setAccountId(account.getAccountId());
		accountPackId.setPackId(0);
		
		AccountPack accountPack = new AccountPack();
		accountPack.setAccount(account);
		accountPack.setId(accountPackId);
		accountPack.setPack(null);
		
		return "user/pricing/success";
	}
}
