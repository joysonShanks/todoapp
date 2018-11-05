package com.joyson.todoapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joyson.todoapp.model.Task;
import com.joyson.todoapp.model.Todo;
import com.joyson.todoapp.model.TodoResponse;
import com.joyson.todoapp.service.TaskService;
import com.joyson.todoapp.service.TodoService;

@RequestMapping(path = "/todo-app")
@RestController
public class TodoController {

	@Autowired
	TodoService todoService;

	@Autowired
	TaskService taskService;

	@PostMapping("/task")
	public ResponseEntity<TodoResponse> saveTask(@RequestBody Task task) {
		TodoResponse todoResponse = new TodoResponse();
		try {
			todoResponse.setId(taskService.save(task));
			todoResponse.setMessage("Task created");
		} catch (Exception ex) {
			todoResponse.setId(0);
			todoResponse.setMessage(ex.getMessage());
			return new ResponseEntity<TodoResponse>(todoResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<TodoResponse>(todoResponse, HttpStatus.CREATED);
	}

	@GetMapping("/task/{taskId}")
	public ResponseEntity<Task> getTask(@PathVariable Long taskId) {
		Optional<Task> task = taskService.findTaskById(taskId);
		if (!task.isPresent()) {
			new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Task>(task.get(), HttpStatus.OK);
	}

	@PostMapping("/todo")
	public ResponseEntity<TodoResponse> saveTask(@RequestBody Todo todo) {
		TodoResponse todoResponse = new TodoResponse();
		try {
			todoResponse.setId(todoService.save(todo));
			todoResponse.setMessage("Todo created");
		} catch (Exception ex) {
			todoResponse.setId(0);
			todoResponse.setMessage(ex.getMessage());
			return new ResponseEntity<TodoResponse>(todoResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<TodoResponse>(todoResponse, HttpStatus.CREATED);
	}

	@GetMapping("/todo/{todoId}")
	public ResponseEntity<Todo> getTodo(@PathVariable Long todoId) {
		Optional<Todo> todo = todoService.findById(todoId);
		if (!todo.isPresent()) {
			new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Todo>(todo.get(), HttpStatus.OK);
	}

	@GetMapping("/todo")
	public ResponseEntity<List<Todo>> getAllTodo(@PathVariable Long todoId) {
		return new ResponseEntity<List<Todo>>(todoService.findAll(), HttpStatus.OK);
	}
}
