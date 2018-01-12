package com.tirmizee.backend.service.user.data;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

public class UserStatus implements Serializable {

	private static final long serialVersionUID = -407430375756915283L;
	
	private Long id;
	
	@Pattern(regexp="^[AI]$", message="Status Invalid")
	private String status;

	public UserStatus() {
	}
	public UserStatus(Long id, String status) {
		this.id = id;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
