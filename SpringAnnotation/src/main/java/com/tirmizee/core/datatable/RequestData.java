package com.tirmizee.core.datatable;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author tirmizee
 *
 * wrapper for datatables.js
 * @param <T> search criteria
 */
public class RequestData<T> {

	
	protected long draw;
	@NotNull
	protected long start;
	@NotNull
	protected long length;
	@JsonProperty("search")
	protected T search;
	protected List<OrderData> orders;
	protected List<ColumnData> columns;
	
	
	public long getDraw() {
		return draw;
	}
	
	public void setDraw(long draw) {
		this.draw = draw;
	}
	
	public long getStart() {
		return start;
	}
	
	public void setStart(long start) {
		this.start = start;
	}
	
	public long getLength() {
		return length;
	}
	
	public void setLength(long length) {
		this.length = length;
	}
	
	public T getSerch() {
		return search;
	}
	
	public void setSerch(T search) {
		this.search = search;
	}


	public void setOrder(List<OrderData> order) {
		this.orders = order;
	}

	public List<OrderData> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderData> orders) {
		this.orders = orders;
	}

	public List<ColumnData> getColumns() {
		return columns;
	}

	public void setColumns(List<ColumnData> columns) {
		this.columns = columns;
	}
	
}
