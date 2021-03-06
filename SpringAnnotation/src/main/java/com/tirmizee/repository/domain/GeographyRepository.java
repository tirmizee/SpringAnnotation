package com.tirmizee.repository.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tirmizee.repository.entities.Geography;

public interface GeographyRepository extends PagingAndSortingRepository<Geography, Long> {

}
