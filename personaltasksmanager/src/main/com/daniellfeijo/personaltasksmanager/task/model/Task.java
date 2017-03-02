package main.com.daniellfeijo.personaltasksmanager.task.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import main.com.daniellfeijo.personaltasksmanager.task.dao.TaskDao;
import main.com.daniellfeijo.personaltasksmanager.user.model.User;

@Entity
public class Task {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull(message = "{task.description.empty}")
	@Size(min = 5, message = "{task.description.little}")
	private String description;

	private boolean finished;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Calendar openDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Calendar finishedDate;

	@ManyToOne
	@JoinColumn(name = "userOpening_id", nullable = true)
	private User userOpening;

	@ManyToOne
	@JoinColumn(name = "userDestination_id", nullable = true)
	private User userDestination;
	
	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public Calendar getFinishedDate() {
		return finishedDate;
	}

	public void setFinishedDate(Calendar finishedDate) {
		this.finishedDate = finishedDate;
	}

	public User getUserOpening() {
		return userOpening;
	}

	public void setUserOpening(User userOpening) {
		this.userOpening = userOpening;
	}

	public User getUserDestination() {
		return userDestination;
	}

	public void setUserDestination(User userDestination) {
		this.userDestination = userDestination;
	}
	
	public Calendar getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Calendar openDate) {
		this.openDate = openDate;
	}
	
	
	
	
	//others methods
	
	

	public void addTask(TaskDao dao, HttpSession session){
		//when the opening user and destination user are the same
		this.setUserOpening((User) session.getAttribute("loggedUser"));
		this.setUserDestination((User) session.getAttribute("loggedUser"));
		this.setOpenDate(Calendar.getInstance());

		dao.add(this);
	}	

}
