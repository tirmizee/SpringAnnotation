package com.tirmizee.repository.entitiesxml;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.domain.Persistable;

/**
 * @author tirmizee
 *
 */
@XmlRootElement(name="UserXml")
public class UserXml implements Persistable<Long> {

	private static final long serialVersionUID = -8330492765998054623L;
	
	private Long id;
	private String username;
	private String password;
	private Date create_date;
	private Date update_date;
	
	@XmlElement
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@XmlElement
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@XmlElement
	public Date getCreate_date() {
		return create_date;
	}
	
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
	@XmlElement
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@XmlElement
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public boolean isNew() {
		return id == null;
	}
}
