package com.Stdmanagement.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	//method for handle no found exception  
		@ExceptionHandler(NotFoundException.class)
		public ResponseEntity<String> handleNoStudentExists(NotFoundException noStudentExists){
			return new ResponseEntity<String>(noStudentExists.getMessage(),HttpStatus.BAD_REQUEST);
		}

		//method for handle already exist 
		@ExceptionHandler(AlreadyExistsExceptionFound.class)
		public ResponseEntity<String> handleAlreadyExistStudent(AlreadyExistsExceptionFound alreadyExistStudent){
			return new ResponseEntity<String>(alreadyExistStudent.getMessage(),HttpStatus.BAD_REQUEST);
		}
}
