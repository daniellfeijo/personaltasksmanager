package com.daniellfeijo.personaltasksmanager.user.dao;

import java.util.List;

import com.daniellfeijo.personaltasksmanager.user.model.User;

public interface UserDao {
	
	void add(User user);
	
	boolean existEmailUser(User user);
	
	boolean existUser(User user);
	
	boolean existEnabledUser(User user);
	
	User catchByEmail(String email);
	
	void disable(Long id);
	
	void enable(Long id);

	List<User> list();

}
