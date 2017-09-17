package com.tirmizee.repository.entities;

import java.util.Date;

import org.springframework.data.domain.Persistable;

/**
 * @author tirmizee
 *
 */
public class Permission implements Persistable<Long> {

	private static final long serialVersionUID = -1527771804161271659L;

	private Long id;
	private String code;
	private String name;
	private String description;
	private Date create_date;
	private Date update_date;
	
	public Permission() {}
	

	public Permission(Long id, String code, String name, String description, Date create_date, Date update_date) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.create_date = create_date;
		this.update_date = update_date;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
