package com.daniellfeijo_renanslopes8.personaltasksmanager.task.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daniellfeijo_renanslopes8.personaltasksmanager.task.dao.JdbcTaskDao;
import com.daniellfeijo_renanslopes8.personaltasksmanager.task.model.Task;

@Controller
public class TaskController {
	
	@RequestMapping("newTask")
	public String form(){
		return ("task/task_form");
	}
	
	@RequestMapping("addTask")
	public String add(@Valid Task task, BindingResult result){
		if(result.hasErrors()){
			return "task/task_form";
		}
		
		JdbcTaskDao dao = new JdbcTaskDao();
		dao.add(task);
		return("task/task_added");
	}
	
	@RequestMapping("editTask")
	public String edit(Task task){
		JdbcTaskDao dao = new JdbcTaskDao();
		dao.edit(task);
		return("redirect:listTasks");
	}
	
	@RequestMapping("listTasks")
	public String list(Model model){
		JdbcTaskDao dao = new JdbcTaskDao();
		List <Task> tasks = dao.list();
		model.addAttribute("tasks", tasks);
		return "task/task_list";
	}
		
	@RequestMapping("removeTask")
	public String remove(Task task){
		JdbcTaskDao dao = new JdbcTaskDao();
		dao.remove(task);
		return "redirect:listTasks";
		
	}
	
	@RequestMapping("showTask")
	public String show(Long id, Model model){
		JdbcTaskDao dao = new JdbcTaskDao();
		model.addAttribute("task", dao.findById(id));
		return "task/task_show";
	}
	
	@RequestMapping("finishTask")
	public String finish(Long id, Model model){
		JdbcTaskDao dao = new JdbcTaskDao();
		dao.finish(id);
		model.addAttribute("task", dao.findById(id));
		return "task/finishedTask";
	}

}
