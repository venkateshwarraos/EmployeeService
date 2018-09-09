package com.emp.main.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {
	
	
	private static final long serialVersionUID = 3710519437632418162L;

	public EmployeeNotFoundException(String exception) {
		super(exception);
	}
	

}
