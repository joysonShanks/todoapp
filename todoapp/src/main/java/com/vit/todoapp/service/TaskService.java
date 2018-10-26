package com.vit.todoapp.service;

import java.util.Optional;

import com.vit.todoapp.model.Task;

public interface TaskService {

	public Long save(Task task);
	
	public Optional<Task> findTaskById(long id);
}
