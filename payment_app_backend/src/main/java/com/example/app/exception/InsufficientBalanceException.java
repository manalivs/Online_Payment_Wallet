package com.example.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InsufficientBalanceException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public InsufficientBalanceException() {
		super();
	}

	public InsufficientBalanceException(String message){
    	super(message);
	}
	
	public String getMessage() {
		return super.getMessage();
	}

}
