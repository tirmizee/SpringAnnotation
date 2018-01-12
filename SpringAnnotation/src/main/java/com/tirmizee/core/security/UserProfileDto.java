package com.tirmizee.core.security;

import java.io.Serializable;

/**
 * @author pratyay
 *
 */
public class UserProfileDto implements Serializable {

	private static final long serialVersionUID = -9042083437700637955L;
	private String username;
	private String firstName;
	private String LastName;
	private String status;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 
}
