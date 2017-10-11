package com.tirmizee.backend.user.data;

import java.io.Serializable;

public class CriteriaUserTable implements Serializable {

	private static final long serialVersionUID = 4620062528732409238L;
	
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
}
