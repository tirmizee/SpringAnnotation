package com.tirmizee.backend.dao;

import com.tirmizee.repository.domain.UserRepository;
import com.tirmizee.repository.entities.User;

public interface UserDao extends UserRepository {
	
	User findByUsername(String username);
	
}
