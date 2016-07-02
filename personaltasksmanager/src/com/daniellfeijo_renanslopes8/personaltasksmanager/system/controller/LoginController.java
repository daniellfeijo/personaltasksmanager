package com.daniellfeijo_renanslopes8.personaltasksmanager.system.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daniellfeijo_renanslopes8.personaltasksmanager.user.dao.JdbcUserDao;
import com.daniellfeijo_renanslopes8.personaltasksmanager.user.model.Users;


@Controller
public class LoginController {
	
	private JdbcUserDao dao;
	
	@Inject
	public LoginController(JdbcUserDao dao){
		this.dao = dao;
	}

	@RequestMapping("loginForm")
	public String loginForm(){
		return "formulario-login";
	}
	
	@RequestMapping("makeLogin")
	public String makeLogin(Users user, 
			HttpSession session){
		if(dao.existUser(user)){
			session.setAttribute("loggedUser", user);
			return "main";
		}
		return "redirect:loginForm";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:loginForm";
		
	}
}
