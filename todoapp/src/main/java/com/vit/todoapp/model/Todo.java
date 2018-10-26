package com.vit.todoapp.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.vit.todoapp.utils.State;

@Entity(name = "todo")
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@OneToMany
	@JoinColumn(name = "tasks")
	@Cascade(CascadeType.ALL)
	private Set<Task> tasks = new HashSet<Task>();

	private String title;
	private Date createdDate;
	private State state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
