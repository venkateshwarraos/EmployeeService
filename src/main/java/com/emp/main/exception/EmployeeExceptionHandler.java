package com.emp.main.exception;

import java.sql.SQLException;

import javax.persistence.UniqueConstraint;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static String genericMessage= " exception occured while processing request";
	private static String sqlgenericMessage= " exception occured while getting employee  details";
	private static String recordNotFoundMessage= " The requested employee record not found";
	
	
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleGenericException(Exception exception, WebRequest request)  {
		ExceptionResponse exceptinResponse = new ExceptionResponse(EmployeeExceptionHandler.genericMessage, request.getDescription(false));
		return new ResponseEntity<>(exceptinResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(SQLException.class)
	public final ResponseEntity<ExceptionResponse> handleSQLException(SQLException exception, WebRequest request)  {
		ExceptionResponse exceptinResponse = new ExceptionResponse(EmployeeExceptionHandler.sqlgenericMessage, request.getDescription(false));
		return new ResponseEntity<>(exceptinResponse, HttpStatus.NOT_MODIFIED);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleEmployeeNotFoundException(EmployeeNotFoundException exception, WebRequest request)  {
		ExceptionResponse exceptinResponse = new ExceptionResponse(EmployeeExceptionHandler.recordNotFoundMessage, request.getDescription(false));
		return new ResponseEntity<>(exceptinResponse, HttpStatus.NOT_FOUND);
	}
	
	

}
