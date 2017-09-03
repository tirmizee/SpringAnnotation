package com.tirmizee.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author tirmizee
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.inMemoryAuthentication()
         .withUser("user").password("user").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_USER')")
		.and()
	    .formLogin().loginPage("/login").defaultSuccessUrl("/admin");

	}
	
	

}
