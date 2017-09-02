package com.tirmizee.core.util;

import java.util.List;

import org.dozer.Mapper;

public interface CustomMapper extends Mapper {
	
	<T> List<T> map(List<?> source,Class<T> destinationClass);

}
