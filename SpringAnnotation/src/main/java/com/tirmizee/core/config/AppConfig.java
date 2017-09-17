package com.tirmizee.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author tirmizee
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.tirmizee.config",
								"com.tirmizee.backend",
								"com.tirmizee.core"})
public class AppConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder(11);
		return encoder;
	}

}