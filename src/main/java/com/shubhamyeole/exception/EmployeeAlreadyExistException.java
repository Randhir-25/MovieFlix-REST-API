package com.shubhamyeole.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyExistException extends RuntimeException{

	private static final long serialVersionUID = 6877806641253096966L;

	public EmployeeAlreadyExistException(String message){
		super(message);
	}
	
	public EmployeeAlreadyExistException(String message, Throwable cause){
		super(message, cause);
	}
}
