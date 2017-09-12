package com.tirmizee.repository.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tirmizee.repository.entities.Permission;

public interface PermissionRepository extends PagingAndSortingRepository<Permission, Long> {

}
