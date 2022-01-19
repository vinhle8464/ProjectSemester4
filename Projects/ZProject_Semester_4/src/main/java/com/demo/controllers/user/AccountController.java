package com.demo.controllers.user;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
//=======
//>>>>>>> 18b0a0865199bb8f160a6df834d1ff640e621545
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.configurations.MyConstants;
import com.demo.helpers.UploadHelper;
import com.demo.models.Account;
import com.demo.services.AccountService;
import com.demo.services.user.AccountServiceUser;
import com.demo.services.user.RoleServiceUser;
import com.demo.validators.AccountValidator;

@Controller
@RequestMapping(value = { "user/account", "login/oauth2/code" })
public class AccountController implements ServletContextAware {
	@Autowired
	private AccountValidator accountValidator;
	@Autowired
	private RoleServiceUser roleServiceUser;
	@Autowired
	private AccountService accountService;

	private ServletContext servletContext;

	@Autowired
	private AccountServiceUser accountServiceUser;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void setServletContext(ServletContext servletContext) {

		this.servletContext = servletContext;

	}

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	@RequestMapping(value = { "login" }, method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, ModelMap modelMap) {

		if (error != null) {
			modelMap.put("msg", "Invalid!");
		}
		if (logout != null) {
			modelMap.put("msg", "Logout Successfully!");
		}

		return "user/account/login";
	}

	@RequestMapping(value = { "processlogin" }, method = RequestMethod.GET)
	public String login(@RequestParam("username") String username, @RequestParam("password") String Password) {

		return "user/account/process-login";
	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(ModelMap modelMap) {

		Account account = new Account();
		account.setDob(new Date());
		modelMap.put("account", account);
		return "user/account/register";
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(accountService);
	}

	@RequestMapping(value = { "register" }, method = RequestMethod.POST)
	public String register(ModelMap modelMap, @RequestParam(value = "terms", required = false) boolean terms,
			@ModelAttribute("account") @Valid Account account, @RequestParam("role") int[] roles,
			@RequestParam(value = "file") MultipartFile file, @RequestParam("repassword") String repassword,
			RedirectAttributes redirectAttributes, BindingResult bindingResult) {
		accountValidator.validate(account, bindingResult);
		if (bindingResult.hasErrors()) {
			return "user/account/register";
		}
		if (terms) {
			if (account.getPassword().equalsIgnoreCase(repassword)) {
				String hash = new BCryptPasswordEncoder().encode(account.getPassword());
				account.setPassword(hash);
				String fileNameUpload = UploadHelper.upload(servletContext, file);
				redirectAttributes.addFlashAttribute("fileName", fileNameUpload);
				account.setAvatar(fileNameUpload);
				if (roles != null && roles.length > 0) {
					for (int role : roles) {
						account.getRoles().add(roleServiceUser.find(role));
					}
				}
				
				SimpleMailMessage message = new SimpleMailMessage();
				message.setTo(account.getEmail());
				message.setSubject("Validation Link From Trắc Nghiệm Online!");
				
				message.setText(
						"<head>\r\n    <title></title>\r\n    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n    <style type=\"text/css\">\r\n        #outlook a {\r\n            padding: 0;\r\n        }\r\n\r\n        .ReadMsgBody {\r\n            width: 100%;\r\n        }\r\n\r\n        .ExternalClass {\r\n            width: 100%;\r\n        }\r\n\r\n            .ExternalClass * {\r\n                line-height: 100%;\r\n            }\r\n\r\n        body {\r\n            margin: 0;\r\n            padding: 0;\r\n            -webkit-text-size-adjust: 100%;\r\n            -ms-text-size-adjust: 100%;\r\n        }\r\n\r\n        table, td {\r\n            border-collapse: collapse;\r\n            mso-table-lspace: 0pt;\r\n            mso-table-rspace: 0pt;\r\n        }\r\n\r\n        img {\r\n            border: 0;\r\n            height: auto;\r\n            line-height: 100%;\r\n            outline: none;\r\n            text-decoration: none;\r\n            -ms-interpolation-mode: bicubic;\r\n        }\r\n\r\n        p {\r\n            display: block;\r\n            margin: 13px 0;\r\n        }\r\n    </style>\r\n    <!--[if !mso]><!-->\r\n    <style type=\"text/css\">\r\n  @media only screen and (max-width:480px) {\r\n    @-ms-viewport { width:320px; }\r\n    @viewport { width:320px; }\r\n  }\r\n    </style>\r\n    <!--<![endif]-->\r\n    <!--[if mso]>\r\n    <xml>\r\n      <o:OfficeDocumentSettings>\r\n        <o:AllowPNG/>\r\n        <o:PixelsPerInch>96</o:PixelsPerInch>\r\n      </o:OfficeDocumentSettings>\r\n    </xml>\r\n    <![endif]-->\r\n    <style type=\"text/css\">\r\n  @media only screen and (min-width:480px) {\r\n    .mj-column-per-100, * [aria-labelledby=\"mj-column-per-100\"] { width:100%!important; }\r\n.mj-column-per-80, * [aria-labelledby=\"mj-column-per-80\"] { width:80%!important; }\r\n.mj-column-per-30, * [aria-labelledby=\"mj-column-per-30\"] { width:30%!important; }\r\n.mj-column-per-70, * [aria-labelledby=\"mj-column-per-70\"] { width:70%!important; }\r\n  }\r\n    </style>\r\n</head>\r\n<body style=\"background: #E3E5E7;\">\r\n    <div style=\"background-color:#E3E5E7;\">\r\n        <!--[if mso | IE]>\r\n        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" align=\"center\" style=\"width:600px;\">\r\n          <tr>\r\n            <td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\">\r\n        <![endif]-->\r\n        <div style=\"margin:0 auto;max-width:600px;background:white;\">\r\n            <table cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:0px;width:100%;background:white;\" align=\"center\" border=\"0\">\r\n                <tbody>\r\n                    <tr>\r\n                        <td style=\"text-align:center;vertical-align:top;font-size:0px;padding:20px 0px;\">\r\n                            <!--[if mso | IE]>\r\n                            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"vertical-align:top;width:600px;\">\r\n                            <![endif]-->\r\n                            <div aria-labelledby=\"mj-column-per-100\" class=\"mj-column-per-100\" style=\"vertical-align:top;display:inline-block;font-size:13px;text-align:left;width:100%;\"><table cellpadding=\"0\" cellspacing=\"0\" style=\"vertical-align:top;\" width=\"100%\" border=\"0\"><tbody><tr><td style=\"word-break:break-word;font-size:0px;padding:10px 25px;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-spacing:0px;\" align=\"center\" border=\"0\"><tbody><tr><td style=\"width:80px;\"><a href=\"about:blank\" target=\"_blank\"><img alt=\"auth0\" title=\"\" height=\"auto\" src=\"https://s27.postimg.org/ca1957db7/huntr_logo.png\" style=\"border:none;border-radius:;display:block;outline:none;text-decoration:none;width:100%;height:auto;\" width=\"80\"></a></td></tr></tbody></table></td></tr></tbody></table></div>\r\n                            <!--[if mso | IE]>\r\n                            </td></tr></table>\r\n                            <![endif]-->\r\n                        </td>\r\n                    </tr>\r\n                </tbody>\r\n            </table>\r\n        </div>\r\n        <!--[if mso | IE]>\r\n        </td></tr></table>\r\n        <![endif]-->\r\n        <!--[if mso | IE]>\r\n        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" align=\"center\" style=\"width:600px;\">\r\n          <tr>\r\n            <td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\">\r\n        <![endif]-->\r\n        <div style=\"margin:0 auto;max-width:600px;background:#222228;\">\r\n            <table cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:0px;width:100%;background:#222228;\" align=\"center\" border=\"0\">\r\n                <tbody>\r\n                    <tr>\r\n                        <td style=\"text-align:center;vertical-align:top;font-size:0px;padding:20px 0px;\">\r\n                            <!--[if mso | IE]>\r\n                            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"vertical-align:top;width:480px;\">\r\n                            <![endif]-->\r\n                            <div aria-labelledby=\"mj-column-per-80\" class=\"mj-column-per-80\" style=\"vertical-align:top;display:inline-block;font-size:13px;text-align:left;width:100%;\">\r\n                                <table cellpadding=\"0\" cellspacing=\"0\" style=\"vertical-align:top;\" width=\"100%\" border=\"0\">\r\n                                    <tbody>\r\n                                        <tr><td style=\"word-break:break-word;font-size:0px;padding:10px 25px;padding-top:30px;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-spacing:0px;\" align=\"center\" border=\"0\"><tbody><tr><td style=\"width:80px;\"><img alt=\"Zero To Launch\" title=\"\" height=\"auto\" src=\"https://cdn.auth0.com/website/emails/product/top-verify.png\" style=\"border:none;border-radius:;display:block;outline:none;text-decoration:none;width:100%;height:auto;\" width=\"80\"></td></tr></tbody></table></td></tr>\r\n                                        <tr>\r\n                                            <td style=\"word-break:break-word;font-size:0px;padding:0px 20px 0px 20px;\" align=\"center\">\r\n                                                <div style=\"cursor:auto;color:white;font-family:'Avenir Next', Avenir, sans-serif;font-size:32px;line-height:60ps;\">\r\n                                                    Verify Your Account\r\n                                                </div>\r\n                                            </td>\r\n                                        </tr>\r\n                                    </tbody>\r\n                                </table>\r\n                            </div>\r\n                            <!--[if mso | IE]>\r\n                            </td></tr></table>\r\n                            <![endif]-->\r\n                        </td>\r\n                    </tr>\r\n                </tbody>\r\n            </table>\r\n        </div>\r\n        <!--[if mso | IE]>\r\n        </td></tr></table>\r\n        <![endif]-->\r\n        <!--[if mso | IE]>\r\n        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" align=\"center\" style=\"width:600px;\">\r\n          <tr>\r\n            <td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\">\r\n        <![endif]-->\r\n        <div style=\"margin:0 auto;max-width:600px;background:white;\">\r\n            <table cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:0px;width:100%;background:white;\" align=\"center\" border=\"0\">\r\n                <tbody>\r\n                    <tr>\r\n                        <td style=\"text-align:center;vertical-align:top;font-size:0px;padding:40px 25px 0px;\">\r\n                            <!--[if mso | IE]>\r\n                            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"vertical-align:top;width:600px;\">\r\n                            <![endif]-->\r\n                            <div aria-labelledby=\"mj-column-per-100\" class=\"mj-column-per-100\" style=\"vertical-align:top;display:inline-block;font-size:13px;text-align:left;width:100%;\">\r\n                                <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n                                    <tbody>\r\n                                        <tr>\r\n                                            <td style=\"word-break:break-word;font-size:0px;padding:0px 0px 25px;\" align=\"left\">\r\n                                                <div style=\"cursor:auto;color:#222228;font-family:'Avenir Next', Avenir, sans-serif;font-size:18px;font-weight:500;line-height:30px;\">\r\n                                                    Your account information\r\n                                                </div>\r\n                                            </td>\r\n                                        </tr>\r\n                                    </tbody>\r\n                                </table>\r\n                            </div>\r\n                            <!--[if mso | IE]>\r\n                            </td><td style=\"vertical-align:top;width:180px;\">\r\n                            <![endif]-->\r\n                            <div aria-labelledby=\"mj-column-per-30\" class=\"mj-column-per-30\" style=\"vertical-align:top;display:inline-block;font-size:13px;text-align:left;width:100%;\">\r\n                                <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n                                    <tbody>\r\n                                        <tr>\r\n                                            <td style=\"word-break:break-word;font-size:0px;padding:0px 0px 10px;\" align=\"left\">\r\n                                                <div style=\"cursor:auto;color:#222228;font-family:'Avenir Next', Avenir, sans-serif;font-size:16px;line-height:30px;\">\r\n                                                    <strong style=\"font-weight: 500; white-space: nowrap;\">Account</strong>\r\n                                                </div>\r\n                                            </td>\r\n                                        </tr>\r\n                                    </tbody>\r\n                                </table>\r\n                            </div>\r\n                            <!--[if mso | IE]>\r\n                            </td><td style=\"vertical-align:top;width:420px;\">\r\n                            <![endif]-->\r\n                            <div aria-labelledby=\"mj-column-per-70\" class=\"mj-column-per-70\" style=\"vertical-align:top;display:inline-block;font-size:13px;text-align:left;width:100%;\">\r\n                                <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n                                    <tbody>\r\n                                        <tr>\r\n                                            <td style=\"word-break:break-word;font-size:0px;padding:0px 0px 10px;\" align=\"left\">\r\n                                                <div style=\"cursor:auto;color:#222228;font-family:'Avenir Next', Avenir, sans-serif;font-size:16px;line-height:30px;\">\r\n                                                    hello@SmilesDavis.yeah\r\n                                                </div>\r\n                                            </td>\r\n                                        </tr>\r\n                                    </tbody>\r\n                                </table>\r\n                            </div>\r\n                            <!--[if mso | IE]>\r\n                            </td><td style=\"vertical-align:top;width:180px;\">\r\n                            <![endif]-->\r\n                            <div aria-labelledby=\"mj-column-per-30\" class=\"mj-column-per-30\" style=\"vertical-align:top;display:inline-block;font-size:13px;text-align:left;width:100%;\">\r\n                                <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n                                    <tbody>\r\n                                        <tr>\r\n                                            <td style=\"word-break:break-word;font-size:0px;padding:0px 0px 10px;\" align=\"left\">\r\n                                                <div style=\"cursor:auto;color:#222228;font-family:'Avenir Next', Avenir, sans-serif;font-size:16px;line-height:30px;\">\r\n                                                    <strong style=\"font-weight: 500; white-space: nowrap;\">Verify Link</strong>\r\n                                                </div>\r\n                                            </td>\r\n                                        </tr>\r\n                                    </tbody>\r\n                                </table>\r\n                            </div>\r\n                            <!--[if mso | IE]>\r\n                            </td><td style=\"vertical-align:top;width:420px;\">\r\n                            <![endif]-->\r\n                            <div aria-labelledby=\"mj-column-per-70\" class=\"mj-column-per-70\" style=\"vertical-align:top;display:inline-block;font-size:13px;text-align:left;width:100%;\">\r\n                                <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n                                    <tbody>\r\n                                        <tr>\r\n                                            <td style=\"word-break:break-word;font-size:0px;padding:0px 0px 25px;\" align=\"left\">\r\n                                                <div style=\"cursor:auto;color:#222228;font-family:'Avenir Next', Avenir, sans-serif;font-size:16px;line-height:30px;\">\r\n                                                    <a href=\"#\" style=\"color:#0a84ae; text-decoration:none\" target=\"_blank\">https://renniehaylock.auth0.com/lo/verify_email?ticket=650RRIMIAyQBzATAomrffF650tTjuPbD#</a>\r\n                                                </div>\r\n                                            </td>\r\n                                        </tr>\r\n                                    </tbody>\r\n                                </table>\r\n                            </div>\r\n                            <!--[if mso | IE]>\r\n                            </td></tr></table>\r\n                            <![endif]-->\r\n                        </td>\r\n                    </tr>\r\n                </tbody>\r\n            </table>\r\n        </div>\r\n        <!--[if mso | IE]>\r\n        </td></tr></table>\r\n        <![endif]-->\r\n        <!--[if mso | IE]>\r\n        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" align=\"center\" style=\"width:600px;\">\r\n          <tr>\r\n            <td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\">\r\n        <![endif]-->\r\n        <div style=\"margin:0 auto;max-width:600px;background:white;\">\r\n            <table cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:0px;width:100%;background:white;\" align=\"center\" border=\"0\">\r\n                <tbody>\r\n                    <tr>\r\n                        <td style=\"text-align:center;vertical-align:top;font-size:0px;padding:0px 30px;\">\r\n                            <!--[if mso | IE]>\r\n                            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"vertical-align:undefined;width:600px;\">\r\n                            <![endif]-->\r\n                            <p style=\"font-size:1px;margin:0 auto;border-top:1px solid #E3E5E7;width:100%;\"></p><!--[if mso | IE]><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:1px;margin:0 auto;border-top:1px solid #E3E5E7;width:100%;\" width=\"600\"><tr><td style=\"height:0;line-height:0;\"> </td></tr></table><![endif]-->\r\n                            <!--[if mso | IE]>\r\n                            </td></tr></table>\r\n                            <![endif]-->\r\n                        </td>\r\n                    </tr>\r\n                </tbody>\r\n            </table>\r\n        </div>\r\n        <!--[if mso | IE]>\r\n        </td></tr></table>\r\n        <![endif]-->\r\n        <!--[if mso | IE]>\r\n        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" align=\"center\" style=\"width:600px;\">\r\n          <tr>\r\n            <td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\">\r\n        <![endif]-->\r\n        <div style=\"margin:0 auto;max-width:600px;background:white;\">\r\n            <table cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:0px;width:100%;background:white;\" align=\"center\" border=\"0\">\r\n                <tbody>\r\n                    <tr>\r\n                        <td style=\"text-align:center;vertical-align:top;font-size:0px;padding:20px 0px;\">\r\n                            <!--[if mso | IE]>\r\n                            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"vertical-align:top;width:600px;\">\r\n                            <![endif]-->\r\n                            <div aria-labelledby=\"mj-column-per-100\" class=\"mj-column-per-100\" style=\"vertical-align:top;display:inline-block;font-size:13px;text-align:left;width:100%;\">\r\n                                <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n                                    <tbody>\r\n                                        <tr>\r\n                                            <td style=\"word-break:break-word;font-size:0px;padding:10px 25px;\" align=\"center\">\r\n                                                <table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" border=\"0\">\r\n                                                    <tbody>\r\n                                                        <tr>\r\n                                                            <td style=\"border-radius:3px;color:white;cursor:auto;\" align=\"center\" valign=\"middle\" bgcolor=\"#EB5424\">\r\n                                                                <a href=\""
								+ "hellobao"
								+ "\" style=\"display:inline-block;text-decoration:none;background:#EB5424;border-radius:3px;color:white;font-family:'Avenir Next', Avenir, sans-serif;font-size:14px;font-weight:500;line-height:35px;padding:10px 25px;margin:0px;\" target=\"_blank\">\r\n                                                                    VERIFY YOUR ACCOUNT\r\n                                                                </a>\r\n                                                            </td>\r\n                                                        </tr>\r\n                                                    </tbody>\r\n                                                </table>\r\n                                            </td>\r\n                                        </tr>\r\n                                    </tbody>\r\n                                </table>\r\n                            </div>\r\n                            <!--[if mso | IE]>\r\n                            </td></tr></table>\r\n                            <![endif]-->\r\n                        </td>\r\n                    </tr>\r\n                </tbody>\r\n            </table>\r\n        </div>\r\n        <!--[if mso | IE]>\r\n        </td></tr></table>\r\n        <![endif]-->\r\n        <!--[if mso | IE]>\r\n        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" align=\"center\" style=\"width:600px;\">\r\n          <tr>\r\n            <td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\">\r\n        <![endif]-->\r\n        <div style=\"margin:0 auto;max-width:600px;background:white;\">\r\n            <table cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:0px;width:100%;background:white;\" align=\"center\" border=\"0\">\r\n                <tbody>\r\n                    <tr>\r\n                        <td style=\"text-align:center;vertical-align:top;font-size:0px;padding:20px 0px;\">\r\n                            <!--[if mso | IE]>\r\n                            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"vertical-align:top;width:600px;\">\r\n                            <![endif]-->\r\n                            <div aria-labelledby=\"mj-column-per-100\" class=\"mj-column-per-100\" style=\"vertical-align:top;display:inline-block;font-size:13px;text-align:left;width:100%;\">\r\n                                <table cellpadding=\"0\" cellspacing=\"0\" style=\"vertical-align:top;\" width=\"100%\" border=\"0\">\r\n                                    <tbody>\r\n                                        <tr>\r\n                                            <td style=\"word-break:break-word;font-size:0px;padding:0px 25px 15px;\" align=\"left\">\r\n                                                <div style=\"cursor:auto;color:#222228;font-family:'Avenir Next', Avenir, sans-serif;font-size:16px;line-height:30px;\">\r\n                                                    If you are having any issues with your account, please don't hesitate to contact us by replying to this mail.\r\n                                                    <br>Thanks!\r\n                                                </div>\r\n                                            </td>\r\n                                        </tr>\r\n                                    </tbody>\r\n                                </table>\r\n                            </div>\r\n                            <!--[if mso | IE]>\r\n                            </td></tr></table>\r\n                            <![endif]-->\r\n                        </td>\r\n                    </tr>\r\n                </tbody>\r\n            </table>\r\n        </div>\r\n        <!--[if mso | IE]>\r\n        </td></tr></table>\r\n        <![endif]-->\r\n        <!--[if mso | IE]>\r\n        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" align=\"center\" style=\"width:600px;\">\r\n          <tr>\r\n            <td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\">\r\n        <![endif]-->\r\n        <div style=\"margin:0 auto;max-width:600px;background:#F5F7F9;\">\r\n            <table cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:0px;width:100%;background:#F5F7F9;\" align=\"center\" border=\"0\">\r\n                <tbody>\r\n                    <tr>\r\n                        <td style=\"text-align:center;vertical-align:top;font-size:0px;padding:20px 0px;\">\r\n                            <!--[if mso | IE]>\r\n                            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"vertical-align:top;width:600px;\">\r\n                            <![endif]-->\r\n                            <div aria-labelledby=\"mj-column-per-100\" class=\"mj-column-per-100\" style=\"vertical-align:top;display:inline-block;font-size:13px;text-align:left;width:100%;\">\r\n                                <table cellpadding=\"0\" cellspacing=\"0\" style=\"vertical-align:top;\" width=\"100%\" border=\"0\">\r\n                                    <tbody>\r\n                                        <tr>\r\n                                            <td style=\"word-break:break-word;font-size:0px;padding:0px 20px;\" align=\"center\">\r\n                                                <div style=\"cursor:auto;color:#222228;font-family:'Avenir Next', Avenir, sans-serif;font-size:13px;line-height:20px;\">\r\n                                                    You’re receiving this email because you have an account in Huntr.\r\n                                                    If you are not sure why you’re receiving this, please contact us.\r\n                                                </div>\r\n                                            </td>\r\n                                        </tr>\r\n                                    </tbody>\r\n                                </table>\r\n                            </div>\r\n                            <!--[if mso | IE]>\r\n                            </td></tr></table>\r\n                            <![endif]-->\r\n                        </td>\r\n                    </tr>\r\n                </tbody>\r\n            </table>\r\n        </div>\r\n        <!--[if mso | IE]>\r\n        </td></tr></table>\r\n        <![endif]-->\r\n        <!--[if mso | IE]>\r\n        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" align=\"center\" style=\"width:600px;\">\r\n          <tr>\r\n            <td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\">\r\n        <![endif]-->\r\n        <div></div>\r\n        <!--[if mso | IE]>\r\n        </td></tr></table>\r\n        <![endif]-->\r\n    </div>\r\n    <img src=\"https://mandrillapp.com/track/open.php?u=9812467&amp;id=bca57efeee894396adad890ad5feefe1\" height=\"1\" width=\"1\">\r\n\r\n\r\n</body>");
				javaMailSender.send(message);
				accountService.save(account);
				return "user/account/login";
			} else {
				modelMap.put("msg", "Retype Password Is Not Correct! ");
				return "redirect:/user/account/register";
			}
		} else {
			modelMap.put("msg", "Accept Our Term To Continue Signing Up! ");
			return "redirect:/user/account/register";
		}

	}

	@RequestMapping(value = "welcome", method = RequestMethod.GET)
	public String welcome(Authentication authentication, HttpServletRequest request, ModelMap modelMap) {
		HttpSession session = request.getSession();
		System.out.println("hello" + authentication.getAuthorities().toString());
		System.out.println("hello" + authentication.getName().toString());
		if (authentication.getAuthorities().toString().equalsIgnoreCase("[ROLE_ADMIN]")) {
			session.setAttribute("account", accountService.findByUsername(authentication.getName()));
			return "redirect:/admin/dashboard/index";
		} else if (authentication.getAuthorities().toString().equalsIgnoreCase("[ROLE_USER_FACULTY]")) {
			session.setAttribute("account", accountService.findByUsername(authentication.getName()));
			return "redirect:/faculty/dashboard/index";
		} else if (authentication.getAuthorities().toString().equalsIgnoreCase("[ROLE_USER_CANDIDATE]")) {
			session.setAttribute("account", accountService.findByUsername(authentication.getName()));
			session.setAttribute("counta", accountServiceUser.countAccountUser());
			return "redirect:/user/home/index";
		} else if (authentication.getAuthorities().toString().equalsIgnoreCase(
				"[ROLE_USER, SCOPE_https://www.googleapis.com/auth/userinfo.email, SCOPE_https://www.googleapis.com/auth/userinfo.profile, SCOPE_openid]")) {
			session.setAttribute("account", accountService.findByUsername((String) session.getAttribute("email")));
			return "redirect:/user/home/index";
		}
		return "account/welcome";
	}

	@RequestMapping(value = "accessDenied", method = RequestMethod.GET)
	public String accessDenied() {

		return "404/index";
	}
}