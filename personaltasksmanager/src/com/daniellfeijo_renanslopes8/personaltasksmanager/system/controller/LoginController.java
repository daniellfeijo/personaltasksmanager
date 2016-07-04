package com.daniellfeijo_renanslopes8.personaltasksmanager.system.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daniellfeijo_renanslopes8.personaltasksmanager.user.dao.UserDao;
import com.daniellfeijo_renanslopes8.personaltasksmanager.user.model.User;


@Controller
public class LoginController {
	
	@Autowired
	private UserDao dao;
	
	@RequestMapping("loginForm")
	public String loginForm(){
		return "formulario-login";
	}
	
	@Transactional
	@RequestMapping("makeLogin")
	public String makeLogin(User user, 
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
