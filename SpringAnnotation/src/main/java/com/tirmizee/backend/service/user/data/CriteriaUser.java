package com.tirmizee.backend.service.user.data;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

public class CriteriaUser implements Serializable {

	private static final long serialVersionUID = 4620062528732409238L;
	
	private String userName;
	private String firstName;
	private String lastName;
	private String status;
	
	public String getUserName() {
		return StringUtils.trimToNull(userName);
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return StringUtils.trimToNull(firstName);
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return StringUtils.trimToNull(lastName);
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStatus() {
		return StringUtils.trimToNull(status);
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
