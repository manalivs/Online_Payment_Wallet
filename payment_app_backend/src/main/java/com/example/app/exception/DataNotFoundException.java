package com.example.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DataNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public DataNotFoundException() {
		super();
	}

	public DataNotFoundException(String message){
    	super(message);
	}
	
	
}