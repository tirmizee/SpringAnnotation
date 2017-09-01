package com.tirmizee.repository.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tirmizee.repository.entities.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
