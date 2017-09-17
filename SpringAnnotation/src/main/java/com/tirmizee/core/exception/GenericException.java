package com.tirmizee.core.exception;

public class GenericException extends RuntimeException {

	private static final long serialVersionUID = 4522074989930965149L;
	
	private String errCode;
	private String errMsg;
	
	public GenericException(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

}
