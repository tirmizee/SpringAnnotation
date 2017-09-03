package com.tirmizee.backend.dao;

import org.springframework.stereotype.Repository;

import com.tirmizee.repository.domain.UserRepository;
import com.tirmizee.repository.domain.UserRepositoryImpl;

/**
 * @author tirmizee
 *
 */
@Repository("UserDao")
public class UserDaoImpl extends UserRepositoryImpl implements UserDao {
	
}
