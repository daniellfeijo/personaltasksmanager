package com.daniellfeijo.personaltasksmanager.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daniellfeijo.personaltasksmanager.system.exception.ExistEmailException;
import com.daniellfeijo.personaltasksmanager.system.exception.InvalidUserProfileException;
import com.daniellfeijo.personaltasksmanager.user.dao.UserDao;
import com.daniellfeijo.personaltasksmanager.user.model.User;


@Transactional
@Controller
public class UserController {
	
	@Autowired
	private UserDao dao;
	
	@RequestMapping("newUserRoot")
	public String form(HttpSession session) {
		session.setAttribute("emailException", "");
		session.setAttribute("userProfileException", "");
		session.setAttribute("user", new User());
		return ("user/user_form");
	}
	
	@RequestMapping("addUser")
	public String add(@Valid User user, BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			return "user/user_form";
		}
		try {
			user.addUser(dao);
		} catch (ExistEmailException e) {
			session.setAttribute("emailException", e.getMessage());
			session.setAttribute("user", user);
			return ("user/user_form");
		}catch (InvalidUserProfileException e) {
			session.setAttribute("userProfileException", e.getMessage());
			session.setAttribute("user", user);
			return ("user/user_form");
		}
		return ("redirect:listUsersRoot");
	}

	@RequestMapping("listUsersRoot")
	public String list(Model model) {
		List<User> users = dao.list();
		model.addAttribute("users", users);
		return "user/user_list";
	}
	
	
	@RequestMapping("disableUserRoot")
	public String disableUserRoot(Long id) {
		dao.disable(id);
		return ("redirect:listUsersRoot");
	}

	@RequestMapping("enableUserRoot")
	public String enableUserRoot(Long id) {
		dao.enable(id);
		return ("redirect:listUsersRoot");
	}


}
