package com.tirmizee.backend.dao;

import java.util.List;

import com.tirmizee.repository.domain.PermissionRepository;
import com.tirmizee.repository.entities.Permission;

public interface PermissionDao extends PermissionRepository {
	
	List<Permission> findByUsername(String username);
	
}
