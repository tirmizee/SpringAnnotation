package com.tirmizee.backend.service.user.data;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Pattern;

public class UserDto implements Serializable {
	
	private static final long serialVersionUID = 6109623018284746157L;
	
	private Long id;
	private String username;
	private String firstname;
	private String lastname;
	@Pattern(regexp="^[AI]$", message="Status Invalid")
	private String status;
	private Date create_date;
	private Date update_date;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	
	
}
