package com.tirmizee.backend.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.tirmizee.config.AppConfig;
import com.tirmizee.repository.entities.Permission;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tirmizee
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@Transactional
public class PermissionDaoTest {
	
	@Autowired
	PermissionDao permissionDao;
	
	@Test
	public void ListOfPermissionWhenFindByUSername(){
		//given
		String username = "admin";
		
		//when
		List<Permission> list = permissionDao.findByUsername(username);
		
		//then
		assertThat(list).isNotEmpty();
		assertThat(list).hasSize(2);
		assertThat(list.get(0).getName()).isEqualTo("ADMIN");
		
	}
}
