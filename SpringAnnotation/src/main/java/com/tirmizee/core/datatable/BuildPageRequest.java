package com.tirmizee.core.datatable;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.NullHandling;

/**
 * @author tirmizee
 *
 */
public class BuildPageRequest {
	
	public static PageRequest build(RequestData<?> requestData){
		int page = (int) (requestData.getStart()/requestData.getLength()),
			size = (int) requestData.getLength();
		return new PageRequest(page, size, buildSort(requestData));
	}

	private static Sort buildSort(RequestData<?> requestData) {
		List<Sort.Order> results = new ArrayList<Sort.Order>();
		for (OrderData orderData : requestData.getOrders()) {
			Sort.Direction direction = Sort.Direction.fromStringOrNull(orderData.getDir());
			String field = requestData.getColumns().get(orderData.getColumn().intValue()).getData();
			results.add(new Sort.Order(direction, field, NullHandling.NATIVE));
		}
		return new Sort(results);
	}
	
}
