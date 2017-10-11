package com.tirmizee.repository.entities;

import org.springframework.data.domain.Persistable;

public class Geography implements Persistable<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1860168341329280275L;

	private Long geoId;
	private String geoName;
	
	public Geography(Long geoId, String geoName) {
		super();
		this.geoId = geoId;
		this.geoName = geoName;
	}

	@Override
	public Long getId() {
		return geoId;
	}
	
	@Override
	public boolean isNew() {
		return false;
	}
	
	public void setId(Long geoId) {
		this.geoId = geoId;
	}
	public String getGeoName() {
		return geoName;
	}
	public void setGeoName(String geoName) {
		this.geoName = geoName;
	}
}
