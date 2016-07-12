package com.daniellfeijo_renanslopes8.personaltasksmanager.user.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.daniellfeijo_renanslopes8.personaltasksmanager.user.model.User;

@Repository
public class JpaUserDao implements UserDao{
	
	@PersistenceContext
	EntityManager manager;

	
	@SuppressWarnings("unchecked")
	public boolean existUser(User user){
		Query query =  manager.
				createQuery("select u from User as u " + "where u.email= :parameterEmail and u.password = :parameterPassword");
				query.setParameter("parameterEmail", user.getEmail());
				query.setParameter("parameterPassword", user.getPassword());
		List<User> users = query.getResultList();
		if(users.isEmpty()){
			return false;
		}else{
			return true;
		}
	}


}
