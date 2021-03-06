package com.tirmizee.core.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author pratyay
 */
public class UserProfile extends UserDetailsImpl {

	private String firstName;
	private String lastName;
	private String status;
	
	private static final long serialVersionUID = -7754272160516251910L;

	public UserProfile(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
