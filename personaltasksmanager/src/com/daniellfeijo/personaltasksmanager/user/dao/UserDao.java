package com.daniellfeijo.personaltasksmanager.user.dao;

import java.util.List;

import com.daniellfeijo.personaltasksmanager.user.model.User;

public interface UserDao {
	
	boolean existUser(User user);
	
	boolean existActiveUser(User user);
	
	User catchByEmail(String email);

	List<User> list();

}
