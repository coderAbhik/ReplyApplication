package com.beta.exception;

/**
 * @author Abhishek_Kumar
 * Class Description: Record not found exception.
 * */

public class RecordNotFoundException extends RuntimeException {

	public RecordNotFoundException(String msg) {
		super(msg);

	}

}
