package com.tirmizee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.tirmizee.core.SecuritySuccessHandler;

/**
 * @author tirmizee
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	SecuritySuccessHandler successHandler;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.inMemoryAuthentication()
         .withUser("user").password("user").roles("USER")
         .and()
         .withUser("admin").password("admin").roles("ADMIN");;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/user/**").access("hasRole('ROLE_USER')")
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		.and()
	    .formLogin().loginPage("/login").successHandler(successHandler);

	}
	
	

}
