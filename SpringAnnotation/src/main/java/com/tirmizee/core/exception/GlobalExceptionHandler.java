package com.tirmizee.core.exception;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static Logger LOG = Logger.getLogger(GlobalExceptionHandler.class);
	public static final String DEFAULT_ERROR_VIEW = "error";
	
	@ResponseBody
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ExceptionMessage> handleExceptionNotfound(BusinessException ex){
		LOG.debug(ex.getMessage());
		ExceptionMessage exceptionMsg = new ExceptionMessage();
		exceptionMsg.setMessage(ex.getMessage());
		exceptionMsg.setStatus(ex.getStatus().value());
		return new ResponseEntity<>(exceptionMsg,ex.getStatus());
	}
	
}
