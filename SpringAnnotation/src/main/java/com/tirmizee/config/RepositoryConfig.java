package com.tirmizee.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author tirmizee
 *
 */

@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:db.properties" })
public class RepositoryConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource dataSource(){
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		config.setJdbcUrl(env.getProperty("jdbc.url"));
		config.setUsername(env.getProperty("jdbc.username"));
		config.setPassword(env.getProperty("jdbc.password"));
		return new HikariDataSource(config);
	}
	
	 @Bean
     public PlatformTransactionManager txManager() {
         return new DataSourceTransactionManager(dataSource());
     }
	
}
