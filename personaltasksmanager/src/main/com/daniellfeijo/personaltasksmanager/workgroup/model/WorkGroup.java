package main.com.daniellfeijo.personaltasksmanager.workgroup.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import main.com.daniellfeijo.personaltasksmanager.user.model.User;

@Entity
public class WorkGroup {

	@Id
	@GeneratedValue
	private Long id;

	private boolean enabled;

	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	private User owner;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<User> members;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}


}
