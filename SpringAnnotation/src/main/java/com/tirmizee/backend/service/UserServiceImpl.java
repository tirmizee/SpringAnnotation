package com.tirmizee.backend.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tirmizee.backend.dao.UserDao;
import com.tirmizee.backend.service.user.data.UserDto;
import com.tirmizee.core.commons.CustomMapper;
import com.tirmizee.repository.entities.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	CustomMapper mapper;
	
	@Override
	@Transactional
	public boolean update(UserDto userDto) {
		
		User user = userDao.findOne(userDto.getId());
		if (user != null) {
			
		}
		mapper.map(userDto, user);
		user.setUpdate_date(new Date());
		return userDao.save(user) != null;
	}

}
