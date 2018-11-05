package com.joyson.todoapp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joyson.todoapp.model.Todo;
import com.joyson.todoapp.repository.TodoRepository;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoRepository todoRepository;

	@Override
	public Long save(Todo todo) {
		return todoRepository.save(todo).getId();
	}

	@Override
	public Optional<Todo> findById(long id) {
		return todoRepository.findById(id);
	}

	@Override
	public List<Todo> findAll() {
		return todoRepository.findAll();
	}

}
