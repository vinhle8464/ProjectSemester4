package com.demo.controllers.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/ajax")
public class AjaxUserController {

	@RequestMapping(value = {"sessionpackid"}, method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public void sessionPackId(@RequestParam("packId") int packId, HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("packId", packId);
		
	}
}
