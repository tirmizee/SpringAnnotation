package com.tirmizee.repository.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tirmizee.repository.entities.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	
	public static final String T_USER = "user";
	public static final String C_ID = "ID";
	public static final String C_USERNAME = "USERNAME";
	public static final String C_PASSWORD = "PASSWORD";
	public static final String C_FIRSTNAME = "FIRSTNAME";
	public static final String C_LASTNAME = "LASTNAME";
	public static final String C_ROLE_ID_FK = "ROLE_ID_FK";
	public static final String C_STATUS = "STATUS";
	public static final String C_CREATE_DATE = "CREATE_DATE";
	public static final String C_UPDATE_DATE = "UPDATE_DATE";

}
