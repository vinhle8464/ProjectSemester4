package com.demo.services.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		CustomOAuth2User auth2ServiceUserImpl = (CustomOAuth2User) authentication.getPrincipal();
		String email = auth2ServiceUserImpl.getEmail();
		String name = auth2ServiceUserImpl.getName();
		String picture=auth2ServiceUserImpl.getPicture();
		System.out.println(name);
		System.out.println(email);
		System.out.println(picture);
		super.onAuthenticationSuccess(request, response, authentication);
	}

}
