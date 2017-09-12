package com.tirmizee.backend.authen.data;

import java.io.Serializable;

public class Certiria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3275536761423050040L;
	private String draw;
	private String start;
	private String length;
	
	public String getDraw() {
		return draw;
	}
	public void setDraw(String draw) {
		this.draw = draw;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	
	

}
