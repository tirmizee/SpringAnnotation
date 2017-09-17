package com.tirmizee.backend.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.tirmizee.core.config.AppConfig;
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
    
    @Test
    public void PageWhenFindAll() {
    	List<User> list = (List<User>) userDao.findAll();
    	Page<User> page = userDao.findAll(new PageRequest(0, 5, new Sort(Direction.ASC, "USERNAME")));
    	for (User user : page.getContent()) {
			System.out.println(user.getUsername());
		}
    	//then
    	assertThat(page).isNotNull();
    }

}
