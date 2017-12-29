package com.tirmizee.core.datatable;

import java.util.Collection;

import org.springframework.data.domain.Page;

/**
 * @author tirmizee
 * 
 * wrapper from datatables.js
 * https://datatables.net/manual/server-side
 * @param <T>
 */
public class ResponseData<T> {
	
	protected Long draw;
	protected Long recordsTotal;
	protected Long recordsFiltered;
	protected Iterable<T> data;
	
	public ResponseData(Collection<T> datas) {
		data = datas;
		recordsTotal =  (long) datas.size();
		recordsFiltered = recordsTotal;
	}
	
	public ResponseData(long draw,Collection<T> datas) {
		this(datas);
		this.draw = draw;
	}
	
	public ResponseData(Page<T> page) {
		this.recordsTotal = page.getTotalElements();
		this.recordsFiltered = recordsTotal;
		this.data = page.getContent();
	}
	
	public ResponseData(long draw,Page<T> page) {
		this(page);
		this.draw = draw;
	}

	public Long getDraw() {
		return draw;
	}

	public void setDraw(Long draw) {
		this.draw = draw;
	}

	public Long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(Long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public Long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(Long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public Iterable<T> getData() {
		return data;
	}

	public void setData(Iterable<T> data) {
		this.data = data;
	}
	
}
