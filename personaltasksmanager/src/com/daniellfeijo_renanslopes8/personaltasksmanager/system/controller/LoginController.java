package com.daniellfeijo_renanslopes8.personaltasksmanager.system.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daniellfeijo_renanslopes8.personaltasksmanager.user.dao.JdbcUserDao;
import com.daniellfeijo_renanslopes8.personaltasksmanager.user.model.Users;


@Controller
public class LoginController {
	
	@RequestMapping("loginForm")
	public String loginForm(){
		return "formulario-login";
	}
	
	@RequestMapping("makeLogin")
	public String makeLogin(Users user, 
			HttpSession session){
		if(new JdbcUserDao().existUser(user)){
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
