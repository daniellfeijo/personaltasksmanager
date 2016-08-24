package com.daniellfeijo.personaltasksmanager.system.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daniellfeijo.personaltasksmanager.user.dao.UserDao;
import com.daniellfeijo.personaltasksmanager.user.model.User;


@Controller
public class LoginController {
	
	@Autowired
	private UserDao dao;
	
	@RequestMapping("loginForm")
	public String loginForm(){
		return "formulario-login";
	}
	
	@RequestMapping("main")
	public String main(){
		return "main";
	}

	@RequestMapping("changeLangue")
	public String changeLangue(HttpServletRequest request){
		String language = request.getParameter("langue");
		Locale locale = new Locale(language);

		Config.set(request.getSession(), Config.FMT_LOCALE, locale);
		Config.set(request.getSession(), Config.FMT_FALLBACK_LOCALE, locale);
		
		
		return "formulario-login";
	}
	
	@Transactional
	@RequestMapping("makeLogin")
	public String makeLogin(User user, 
			HttpSession session){
		try {
			if(dao.existEnabledUser(user)){
				user.singIn(session, dao);
				return "main";
			}
		} catch (NoSuchAlgorithmException e) {
			return "redirect:loginForm";
			//e.printStackTrace();
		}
		return "redirect:loginForm";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:loginForm";
		
	}
}
