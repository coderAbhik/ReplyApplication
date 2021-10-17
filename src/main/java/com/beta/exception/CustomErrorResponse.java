package com.beta.exception;

import java.io.Serializable;

/**
 * @author Abhishek_Kumar
 * Class Description: POJO for respone entity in REST
 * */

public class CustomErrorResponse implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5838540944024728920L;
	
	private int status;
	private String error;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
