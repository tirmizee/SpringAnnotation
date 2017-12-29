package com.tirmizee.backend.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tirmizee.backend.service.user.data.CriteriaUser;
import com.tirmizee.backend.service.user.data.UserStatus;
import com.tirmizee.backend.service.user.data.UserTableDto;
import com.tirmizee.repository.domain.UserRepository;
import com.tirmizee.repository.entities.User;

public interface UserDao extends UserRepository {
	
	User findByUsername(String username);
	
	Page<UserTableDto> findByAllFields(Pageable pageable,CriteriaUser criteria);
	
	boolean updateStatus(UserStatus userStatus);
	
}
