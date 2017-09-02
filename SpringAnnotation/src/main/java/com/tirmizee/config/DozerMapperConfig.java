package com.tirmizee.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tirmizee.core.util.CustomMapper;
import com.tirmizee.core.util.CustomMapperImpl;

/**
 * @author tirmizee
 *
 */
@Configuration
public class DozerMapperConfig {
	
	@Bean
	public CustomMapper getCustomMapper(){
		return new CustomMapperImpl(Arrays.asList("dozer-config.xml"));
	}
}
