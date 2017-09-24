package com.tirmizee.backend.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tirmizee.backend.user.data.CriteriaUserTable;
import com.tirmizee.repository.domain.UserRepository;
import com.tirmizee.repository.entities.User;

public interface UserDao extends UserRepository {
	
	User findByUsername(String username);
	
	Page<User> findByAllFields(Pageable pageable,CriteriaUserTable criteria);
	
}
