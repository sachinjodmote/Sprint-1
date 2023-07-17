package com.Stdmanagement.Exception;

//this is exception handling for if data already exists
public class NotFoundException extends RuntimeException {

	private String message;

	
	
	public NotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	
}
