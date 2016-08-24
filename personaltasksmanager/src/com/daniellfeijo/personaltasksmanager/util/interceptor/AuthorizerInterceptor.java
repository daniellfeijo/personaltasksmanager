package com.daniellfeijo.personaltasksmanager.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.daniellfeijo.personaltasksmanager.user.model.User;

public class AuthorizerInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object controller)
				throws Exception{
		String uri = request.getRequestURI();
		if(uri.endsWith("loginForm") 
				|| uri.endsWith("makeLogin") 
				|| uri.contains("resource")
				|| uri.contains("changeLangue")){
			return true;
		}
		if(request.getSession().getAttribute("loggedUser") != null){
			if(uri.endsWith("Root")) {
				User loggedUser = (User) request.getSession().getAttribute("loggedUser");
				if(loggedUser.getProfile().equals("root")){
					return true;
				}else{
					response.sendRedirect("loginForm");
					return false;
				}
			}
			return true;
		}
		response.sendRedirect("loginForm");
		return false;
	}

}
