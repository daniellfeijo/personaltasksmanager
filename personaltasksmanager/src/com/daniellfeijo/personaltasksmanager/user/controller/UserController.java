package com.daniellfeijo.personaltasksmanager.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daniellfeijo.personaltasksmanager.user.dao.UserDao;
import com.daniellfeijo.personaltasksmanager.user.model.User;


@Transactional
@Controller
public class UserController {
	
	@Autowired
	private UserDao dao;
	
	@RequestMapping("newUserRoot")
	public String form() {
		return ("user/user_form");
	}

	@RequestMapping("listUsersRoot")
	public String list(Model model) {
		List<User> users = dao.list();
		model.addAttribute("users", users);
		return "user/user_list";
	}


}
