package com.tirmizee.test.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.tirmizee.backend.dao.UserDao;
import com.tirmizee.config.AppConfig;
import com.tirmizee.repository.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})

@Transactional
public class UserTest {
	
	@Autowired
	UserDao userDao;
	
    @Test
    public void test_ml_always_return_true() {
    	User user = userDao.save(new User(null,"admin","admin",new Date(),null));
    	assertThat(user.getUsername()).isEqualTo("admin");
    	
    }
    
    @Test
    @Ignore
    public void t() {
    	User user = userDao.save(new User(null,"admin","admin",new Date(),null));
    	assertThat(user.getUsername()).isEqualTo("admin");
    }

}
