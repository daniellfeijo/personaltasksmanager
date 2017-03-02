package main.com.daniellfeijo.personaltasksmanager.task.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import main.com.daniellfeijo.personaltasksmanager.task.model.Task;

@Repository
public class JpaTaskDao implements TaskDao{
	
	@PersistenceContext
	EntityManager manager;
	
	public void add(Task task){
		manager.persist(task);
	}
	
	public void edit(Task task){
		manager.merge(task);
	}
	
	@SuppressWarnings("unchecked")
	public List<Task> list(){
		return manager.
				createQuery("select t from Task as t ORDER BY t.id DESC").getResultList();
	}
	
	public Task findById(Long id){
		return manager.find(Task.class, id);
	}
	
	public void remove(Task task){
		Task taskForRemove = findById(task.getId());
		manager.remove(taskForRemove);
	}
	
	public void finish(Long id){
		Task task = findById(id);
		task.setFinished(true);
		task.setFinishedDate(Calendar.getInstance());
	}

}
