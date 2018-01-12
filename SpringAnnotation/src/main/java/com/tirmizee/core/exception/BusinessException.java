package com.tirmizee.core.exception;

import org.springframework.http.HttpStatus;

public class BusinessException  extends RuntimeException   {

	private HttpStatus status;
	
	private static final long serialVersionUID = -4123180079950070796L;
	
	public BusinessException(HttpStatus status , String message){
		super(message);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}

}
