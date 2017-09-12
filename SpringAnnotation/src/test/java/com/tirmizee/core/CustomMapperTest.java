package com.tirmizee.core;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tirmizee.config.AppConfig;
import com.tirmizee.core.CustomMapper;
import com.tirmizee.repository.entities.User;
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
	
	@Test
	public void containsAllField_WhenMapperList(){
		
		//given
		List<User> sources = new ArrayList<User>();
		sources.add(new User(1l, "admin", "admin", new Date(), null));
		sources.add(new User(2l, "user", "user", new Date(), null));
		
		//when
		List<User> destination = mapper.map(sources, User.class);

		//then
		assertThat(destination).isNotEmpty();
		assertThat(destination).hasSize(sources.size());
		for (int i = 0; i < destination.size(); i++) {
			assertThat(destination.get(i)).isEqualToComparingFieldByField(sources.get(i));
		}
		
	}
	
	
	
	
}
