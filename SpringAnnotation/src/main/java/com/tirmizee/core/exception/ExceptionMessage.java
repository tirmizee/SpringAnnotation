package com.tirmizee.core.exception;

import java.io.Serializable;

public class ExceptionMessage implements Serializable {
	
	private static final long serialVersionUID = 1032289610717305246L;
	
	private int status;
	private String message;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
