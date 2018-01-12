package com.tirmizee.backend.dao;

import java.util.List;

import com.tirmizee.repository.domain.PermissionRepository;
import com.tirmizee.repository.entities.Permission;
import com.tirmizee.repository.entities.User;

public interface PermissionDao extends PermissionRepository {
	
	List<Permission> findByUsername(String username);
	
}
