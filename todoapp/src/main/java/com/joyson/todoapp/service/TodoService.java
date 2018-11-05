package com.joyson.todoapp.service;

import java.util.List;
import java.util.Optional;

import com.joyson.todoapp.model.Todo;

public interface TodoService {

	public Long save(Todo todo);

	public Optional<Todo> findById(long id);

	public List<Todo> findAll();
}
