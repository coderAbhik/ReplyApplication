package com.beta.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
/**
 * @author Abhishek_Kumar
 * Class Description: Handler for error/exception.
 * */

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	  @ExceptionHandler(RecordNotFoundException.class)
	    public ResponseEntity<CustomErrorResponse> customHandleNotFound(Exception ex, WebRequest request) {

	        CustomErrorResponse errors = new CustomErrorResponse();
	        errors.setError(ex.getMessage());
	        errors.setStatus(HttpStatus.NOT_FOUND.value());

	        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);

	    }

}
