package main.com.daniellfeijo.personaltasksmanager.user.dao;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import main.com.daniellfeijo.personaltasksmanager.user.model.User;

public interface UserDao {
	
	void add(User user);
	
	boolean existEmailUser(User user);
	
	boolean existUser(User user);
	
	boolean existEnabledUser(User user) throws NoSuchAlgorithmException;
	
	User catchByEmail(String email);
	
	void disable(Long id);
	
	void enable(Long id);

	List<User> list();

}
