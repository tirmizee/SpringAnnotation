package com.tirmizee.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.dozer.DozerBeanMapper;

/**
 * @author tirmizee
 */
public class CustomMapper extends DozerBeanMapper  {
	
	public CustomMapper(List<String> mappingFiles) {
		super(mappingFiles);
	}

	public <T> List<T> map(List<?> source, Class<T> destinationClass) {
		return  (List<T>) internalMap(source, destinationClass, new ArrayList<>());
	}
	
	public <T> Set<T> map(Set<?> source, Class<T> destinationClass) {
		return (Set<T>) internalMap(source, destinationClass, new HashSet<>());
	}
	
	private <T> Collection<T> internalMap(Collection<?> source , Class<T> destinationClass,Collection<T> target){
		for (Object t : source) {
			target.add(map(t, destinationClass));
		}
		return target;
	}
	
}
