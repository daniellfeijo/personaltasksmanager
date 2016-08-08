package com.daniellfeijo.personaltasksmanager.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.servlet.http.HttpSession;

import com.daniellfeijo.personaltasksmanager.system.exception.ExistEmailException;
import com.daniellfeijo.personaltasksmanager.user.dao.UserDao;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;

	private boolean enabled;

	private String profile;

	private String email;
	
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
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
	

	public void addUser(UserDao dao) throws ExistEmailException{		
		if (dao.existEmailUser(this)){
			throw new ExistEmailException("Email já existe");
		}
		this.setEnabled(true);
		this.setPassword("123");
		
		dao.add(this);
	}	


}
