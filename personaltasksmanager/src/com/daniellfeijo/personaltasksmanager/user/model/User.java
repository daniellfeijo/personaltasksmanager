package com.daniellfeijo.personaltasksmanager.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.servlet.http.HttpSession;

import com.daniellfeijo.personaltasksmanager.user.dao.UserDao;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;

	private boolean active;

	private String login;

	private String email;
	
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//other methods
	
	public void singIn(HttpSession session, UserDao dao){
		User loggedUser = dao.catchByEmail(this.getEmail());
		session.setAttribute("loggedUser", loggedUser);
	}

}
