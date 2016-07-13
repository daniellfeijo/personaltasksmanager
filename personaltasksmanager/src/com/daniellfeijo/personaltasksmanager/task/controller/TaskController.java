package com.daniellfeijo.personaltasksmanager.task.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daniellfeijo.personaltasksmanager.task.dao.TaskDao;
import com.daniellfeijo.personaltasksmanager.task.model.Task;
import com.daniellfeijo.personaltasksmanager.user.model.User;

@Transactional
@Controller
public class TaskController {

	@Autowired
	private TaskDao dao;

	@RequestMapping("newTask")
	public String form() {
		return ("task/task_form");
	}

	@RequestMapping("addTask")
	public String add(@Valid Task task, BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			return "task/task_form";
		}
		task.setUserOpening((User) session.getAttribute("loggedUser"));
		dao.add(task);
		return ("redirect:listTasks");
	}

	@RequestMapping("editTask")
	public String edit(Task task) {
		dao.edit(task);
		return ("redirect:listTasks");
	}

	@RequestMapping("listTasks")
	public String list(Model model) {
		List<Task> tasks = dao.list();
		model.addAttribute("tasks", tasks);
		return "task/task_list";
	}

	@RequestMapping("removeTask")
	public String remove(Task task) {
		dao.remove(task);
		return "redirect:listTasks";

	}

	@RequestMapping("showTask")
	public String show(Long id, Model model) {
		model.addAttribute("task", dao.findById(id));
		return "task/task_show";
	}

	@RequestMapping("finishTask")
	public String finish(Long id, Model model) {
		dao.finish(id);
		model.addAttribute("task", dao.findById(id));
		return "task/finishedTask";
	}

}
