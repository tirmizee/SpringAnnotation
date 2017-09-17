package com.tirmizee.backend.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tirmizee.backend.dao.UserDao;
import com.tirmizee.backend.user.data.UserDto;
import com.tirmizee.core.commons.CustomMapper;
import com.tirmizee.core.datatable.BuildPageRequest;
import com.tirmizee.core.datatable.RequestData;
import com.tirmizee.core.datatable.ResponseData;
import com.tirmizee.core.datatable.Saa;
import com.tirmizee.repository.entities.User;

@Controller
@RequestMapping("service/user")
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	CustomMapper mapper;
	
	@ResponseBody
	@RequestMapping(value = "/findAll", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseData<UserDto> test(@Valid @RequestBody RequestData<Saa> requestData) {
		PageRequest pageRequest = BuildPageRequest.build(requestData);
		Page<User> page = userDao.findAll(pageRequest);
		Page<UserDto> pages = mapper.map(page, UserDto.class);
		return new ResponseData<UserDto>(pages);
	}
	
}
