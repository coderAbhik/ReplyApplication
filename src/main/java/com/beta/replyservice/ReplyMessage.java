package com.beta.replyservice;

import java.io.Serializable;

public class ReplyMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String message;

	public ReplyMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}