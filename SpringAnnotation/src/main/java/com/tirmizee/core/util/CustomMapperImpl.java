package com.tirmizee.core.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;

/**
 * @author tirmizee
 *
 */
public class CustomMapperImpl extends DozerBeanMapper implements CustomMapper {

//	private static final Logger LOGGER = Logger  
	public CustomMapperImpl(List<String> mappingFiles) {
		super(mappingFiles);
	}

	@Override
	public <T> List<T> map(List<?> source, Class<T> destinationClass) {
		return internalMap(source, destinationClass, new ArrayList<>());
	}
	
	private <T> List<T> internalMap(List<?> source , Class<T> destinationClass,List<T> target){
		for (Object t : source) {
			target.add(map(t, destinationClass));
		}
		return target;
	}
	
}
