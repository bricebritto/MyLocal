package com.siemens.tracker.web.security;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

 
@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();		 
		/*String role = auth.getName();
		String role1 = auth.getAuthorities();
		System.out.println("Roles are:" + role);*/
	String targetUrl = "";
	
	Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
	 
    List<String> roles = new ArrayList<String>();

    for (GrantedAuthority a : authorities) {
        roles.add(a.getAuthority());
    }
System.out.println("role is" + roles);
	
	 if(roles.contains("ROLE_ADMIN")) {
	 targetUrl = "/admin";
	 } else if(roles.contains("ROLE_USER")) {
	 targetUrl = "/recon";
	 }
	 /*System.out.println("targetURL" + targetUrl);*/
	 return targetUrl;
	 }
	
	
}	
