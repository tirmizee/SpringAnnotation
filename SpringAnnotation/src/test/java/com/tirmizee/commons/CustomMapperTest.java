package com.tirmizee.commons;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tirmizee.core.commons.CustomMapper;
import com.tirmizee.core.config.AppConfig;

/**
 * @author tirmizee
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={AppConfig.class})
public class CustomMapperTest {
	
	@Autowired
	CustomMapper mapper;
	
 	
	
}
