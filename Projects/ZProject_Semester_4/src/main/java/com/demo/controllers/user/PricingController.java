package com.demo.controllers.user;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.demo.services.user.AccountPackService;
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
	
	@Autowired
	private AccountPackService accountPackService;
	
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
		
		HttpSession httpSession = request.getSession();
		System.out.println("pack id: " + httpSession.getAttribute("packId").toString());
		
		int pakcid = Integer.parseInt(httpSession.getAttribute("packId").toString());
		
		String authtoken = environment.getProperty("paypal.authtoken");
		String posturl = environment.getProperty("paypal.posturl");
		String business = environment.getProperty("paypal.business");
		String returnurl = environment.getProperty("paypal.returnurl");
		
		payPalConfig.setAuthToken(authtoken);
		payPalConfig.setPosturl(posturl);
		payPalConfig.setBusiness(business);
		payPalConfig.setReturnurl(returnurl);
		
		PayPalResult result = PayPalSucess.getPayPal(request, payPalConfig);
		
		Account account = accountService.findByUsername(authentication.getName());
		
		Pay pay = new Pay();
		pay.setAccount(account);
		pay.setPayment("PAYPAL");
		pay.setTitle("PAYMENT PACK - CODE: " + request.getParameter("tx"));
		pay.setFee(Float.parseFloat(request.getParameter("amt")));
		pay.setDatePaid(new Date());
		pay.setPayStatus(true);
		payService.save(pay);
		
		AccountPackId accountPackId = new AccountPackId();
		accountPackId.setAccountId(account.getAccountId());
		accountPackId.setPackId(pakcid);
		
		Pack pack = pricingService.findById(pakcid);
		
		AccountPack accountPack = new AccountPack();
		accountPack.setAccount(account);
		accountPack.setId(accountPackId);
		accountPack.setPack(pack);
		accountPack.setStartDate(new Date());
		accountPack.setStatus(true);
		accountPackService.save(accountPack);
		
		httpSession.removeAttribute("packId");
		
		return "user/pricing/success";
	}
}
