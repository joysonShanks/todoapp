package com.joyson.todoapp.service;

import java.util.Optional;

import com.joyson.todoapp.model.Task;

public interface TaskService {

	public Long save(Task task);
	
	public Optional<Task> findTaskById(long id);
}
