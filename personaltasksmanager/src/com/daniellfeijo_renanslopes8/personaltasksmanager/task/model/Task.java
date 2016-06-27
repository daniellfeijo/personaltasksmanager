package com.daniellfeijo_renanslopes8.personaltasksmanager.task.model;

import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Task {
	
	private Long id;
	
	@NotNull(message="{task.description.empty}")
	@Size(min=5, message="{task.description.little}")
	private String description;
	
	private boolean finished;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Calendar FinishedDate;

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
		return FinishedDate;
	}

	public void setFinishedDate(Calendar finishedDate) {
		FinishedDate = finishedDate;
	}

}
