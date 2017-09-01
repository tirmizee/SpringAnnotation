package com.tirmizee.repository.entities;



import java.util.Date;

import org.springframework.data.domain.Persistable;

public class User implements Persistable<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6344433312348381649L;
	
	private Long id;
	private String username;
	private String password;
	private Date create_date;
	private Date update_date;
	
	

	public User() {}

	public User(Long id, String username, String password, Date create_date, Date update_date) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.create_date = create_date;
		this.update_date = update_date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public boolean isNew() {
		return id == null;
	}

}
