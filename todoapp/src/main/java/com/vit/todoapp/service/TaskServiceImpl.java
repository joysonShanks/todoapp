package com.vit.todoapp.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vit.todoapp.model.Task;
import com.vit.todoapp.repository.TaskRepository;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository taskRepository;

	@Override
	public Long save(Task task) {
		return taskRepository.save(task).getId();
	}

	@Override
	public Optional<Task> findTaskById(long id) {
		return taskRepository.findById(id);
	}

}
