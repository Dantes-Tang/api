package com.capgemini.drms.web.ldap;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.apache.bcel.classfile.Constant;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class MyAccessDeniedHandler implements AccessDeniedHandler {
	private String accessDeniedUrl;
	 
    public  MyAccessDeniedHandler() {
		// TODO Auto-generated constructor stub
	}
 
    public MyAccessDeniedHandler(String accessDeniedUrl) {
    	
    	this.accessDeniedUrl = accessDeniedUrl;
    }
	
	
	public String getAccessDeniedUrl() {
		return accessDeniedUrl;
	}

	public void setAccessDeniedUrl(String accessDeniedUrl) {
		this.accessDeniedUrl = accessDeniedUrl;
	}

	@Override
	public void handle(HttpServletRequest request,
			HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException,
			ServletException {
		// TODO Auto-generated method stub
		
		response.sendRedirect("DRMS/accessDenied.html");
		return;
	
		
		/*	String deniedMessage = accessDeniedException.getMessage();
		String rp = request.getRequestURI();
	    request.getSession().setAttribute(Cons, deniedMessage);
		*/
	}

	
}
