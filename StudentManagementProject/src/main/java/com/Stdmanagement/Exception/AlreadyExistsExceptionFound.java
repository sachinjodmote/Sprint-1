package com.Stdmanagement.Exception;


//this is exception handling for if data already exists
public class AlreadyExistsExceptionFound extends RuntimeException {
	
	public AlreadyExistsExceptionFound(String message) {
		super(message);
	}

}
