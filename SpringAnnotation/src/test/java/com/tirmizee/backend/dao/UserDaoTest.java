package com.tirmizee.backend.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.tirmizee.config.AppConfig;
import com.tirmizee.repository.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@Transactional
public class UserDaoTest {
	
	@Autowired
	UserDao userDao;
	
    @Test
    public void UserWhenFindByUsername() {
    	//given
    	String username = "admin";
    	
    	//when
    	User user = userDao.findByUsername(username);
    
    	//then
    	assertThat(user).isNotNull();
    }

}
