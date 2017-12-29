package com.tirmizee.repository.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tirmizee.repository.entities.User;

/**
 * @author tirmizee
 *
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	
	public static final String USER = "user";
	public static final String ID = "ID";
	public static final String USERNAME = "USERNAME";
	public static final String PASSWORD = "PASSWORD";
	public static final String FIRSTNAME = "FIRSTNAME";
	public static final String LASTNAME = "LASTNAME";
	public static final String STATUS = "STATUS";
	public static final String CREATE_DATE = "CREATE_DATE";
	public static final String UPDATE_DATE = "UPDATE_DATE";

}
