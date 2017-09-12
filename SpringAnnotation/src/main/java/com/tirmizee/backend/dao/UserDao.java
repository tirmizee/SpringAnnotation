package com.tirmizee.backend.dao;

import org.springframework.data.domain.Page;

import com.tirmizee.repository.domain.UserRepository;
import com.tirmizee.repository.entities.User;

public interface UserDao extends UserRepository {
	
	User findByUsername(String username);

	
}
