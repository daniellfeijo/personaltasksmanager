package com.daniellfeijo.personaltasksmanager.task.dao;

import java.util.List;

import com.daniellfeijo.personaltasksmanager.task.model.Task;

public interface TaskDao {
	Task findById(Long id);
	List<Task> list();
	void add(Task task);
	void edit(Task task);
	void remove(Task task);
	void finish(Long id);

}
