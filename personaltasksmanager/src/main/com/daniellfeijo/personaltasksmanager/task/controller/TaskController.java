package main.com.daniellfeijo.personaltasksmanager.task.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import main.com.daniellfeijo.personaltasksmanager.task.dao.TaskDao;
import main.com.daniellfeijo.personaltasksmanager.task.model.Task;

@Transactional
@Controller
public class TaskController {

	@Autowired
	private TaskDao dao;

	@RequestMapping("newTask")
	public String form() {
		return ("task/add/task_form");
	}

	@RequestMapping("addTask")
	public String add(@Valid Task task, BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			return "task/add/task_form";
		}
		task.addTask(dao, session);
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
		return "task/list/task-list";
	}

	@RequestMapping("removeTask")
	public String remove(Task task) {
		dao.remove(task);
		return "redirect:listTasks";

	}

	@RequestMapping("showTask")
	public String show(Long id, Model model) {
		model.addAttribute("task", dao.findById(id));
		return "task/edit/task_show";
	}

	@RequestMapping("finishTask")
	public void finish(Long id, HttpServletResponse response) {
		dao.finish(id);
		response.setStatus(200);
	}

}
