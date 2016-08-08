package com.daniellfeijo.personaltasksmanager.user.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.daniellfeijo.personaltasksmanager.user.model.User;

@Repository
public class JpaUserDao implements UserDao{
	
	@PersistenceContext
	EntityManager manager;

	public void add(User user){
		manager.persist(user);
	}

	
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

	@SuppressWarnings("unchecked")
	public boolean existEnabledUser(User user){
		Query query =  manager.
				createQuery("select u from User as u " + 
						"where u.email= :parameterEmail " + 
							"and u.password = :parameterPassword " +
								"and u.enabled = :parameterEnabled");
				query.setParameter("parameterEmail", user.getEmail());
				query.setParameter("parameterPassword", user.getPassword());
				query.setParameter("parameterEnabled", true);
		List<User> users = query.getResultList();
		if(users.isEmpty()){
			return false;
		}else{
			return true;
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean existEmailUser(User user){
		Query query =  manager.
				createQuery("select u from User as u " + 
						"where u.email= :parameterEmail");
				query.setParameter("parameterEmail", user.getEmail());
		List<User> users = query.getResultList();
		if(users.isEmpty()){
			return false;
		}else{
			return true;
		}
	}
	
	
	public User catchByEmail(String email){
		Query query = manager.
				createQuery("select u from User as u " +
						"where u.email= :parameterEmail");
		query.setParameter("parameterEmail", email);
		User user = (User) query.getSingleResult();
		return user;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<User> list(){
		return manager.
				createQuery("select u from User as u ORDER BY u.id ASC").getResultList();
	}



}
