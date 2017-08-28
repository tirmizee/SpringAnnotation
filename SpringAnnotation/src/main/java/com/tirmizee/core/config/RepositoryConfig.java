package com.tirmizee.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author tirmizee
 *
 */

@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:db.properties" })
public class RepositoryConfig {
	
//	@Bean
//	public DataSource dataSource(){
//		HikariConfig config = new HikariConfig();
//		config.setDriverClassName("");
//		config.setJdbcUrl("jdbc:mysql://localhost:3306/jsp");
//		config.setUsername("root");
//		config.setPassword("root");
//		return new HikariDataSource(config);
//	}
//	
//	 @Bean
//     public PlatformTransactionManager txManager() {
//         return new DataSourceTransactionManager(dataSource());
//     }
	
}
