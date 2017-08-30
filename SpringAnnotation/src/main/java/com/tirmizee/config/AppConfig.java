package com.tirmizee.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author tirmizee
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.tirmizee")
public class AppConfig {

}
