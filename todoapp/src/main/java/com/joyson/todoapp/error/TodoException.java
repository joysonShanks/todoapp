package com.joyson.todoapp.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TodoException extends RuntimeException {

	private static final long serialVersionUID = -4323331491571969325L;

	public TodoException(String message) {
		super(message);
	}
}
