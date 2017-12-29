package com.tirmizee.commons;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tirmizee.backend.service.user.data.UserTableDto;
import com.tirmizee.core.commons.CustomMapper;
import com.tirmizee.core.config.AppConfig;
import com.tirmizee.repository.entities.User;
import static org.assertj.core.api.Assertions.assertThat;

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
	public void trueWhenMapperClass(){
		
		// given
		User user = new User(1l, "admin", "123456","","","A" ,new Date(), new Date());
		
		//when
		UserTableDto userDto = mapper.map(user, UserTableDto.class);
		
		//then
		assertThat(user.getCreate_date()).isEqualTo(userDto.getCreate_date());
		assertThat(user.getUpdate_date()).isEqualTo(userDto.getUpdate_date());
		assertThat(user.getId()).isEqualTo(userDto.getId());
		assertThat(user.getUsername()).isEqualTo(userDto.getUsername());
	}
 	
	@Test
	public void trueWhenMapperList(){
		
		// given
		List<User> listOfUser = new ArrayList<>();
		for (long i = 0; i < 5; i++) {
			listOfUser.add(new User(i, "admin" + i, "123456"+ i,"","","A", new Date(), new Date()));
		}
		Iterator<User> users = listOfUser.iterator();
		
		//when
		List<UserTableDto> listOfUSerDto = mapper.map(listOfUser, UserTableDto.class);
		Iterator<UserTableDto> userDtos = listOfUSerDto.listIterator();

		//then
		assertThat(listOfUser).hasSize(listOfUSerDto.size());
		
		while (users.hasNext()) {
			User user = users.next();
			if (userDtos.hasNext()) {
				UserTableDto userDto = userDtos.next();
				assertThat(user.getCreate_date()).isEqualTo(userDto.getCreate_date());
				assertThat(user.getUpdate_date()).isEqualTo(userDto.getUpdate_date());
				assertThat(user.getId()).isEqualTo(userDto.getId());
				assertThat(user.getUsername()).isEqualTo(userDto.getUsername());
				users.remove();
				userDtos.remove();
				break;
			}
		}
	}
}
