package com.tirmizee.backend.user.data;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tirmizee.core.annotaion.SortColumns;

/**
 * @author tirmizee
 *
 */
public class UserTableDto implements Serializable {
	
	private static final long serialVersionUID = 5798756052521574168L;

	@SortColumns("ID")
	private Long id;
	
	@SortColumns({"USERNAME","PASSWORD"})
	private String username;
	
	@SortColumns("PASSWORD")
	private String password;
	
	@SortColumns("CREATE_DATE")
	@JsonFormat(pattern="dd-MM-yyyy")
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

}