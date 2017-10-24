package com.tirmizee.backend.user;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tirmizee.backend.dao.UserDao;
import com.tirmizee.backend.user.data.CriteriaUserTable;
import com.tirmizee.backend.user.data.UserTableDto;
import com.tirmizee.core.commons.CustomMapper;
import com.tirmizee.core.datatable.BuildPageRequest;
import com.tirmizee.core.datatable.RequestData;
import com.tirmizee.core.datatable.ResponseData;
import com.tirmizee.repository.entities.User;

/**
 * @author tirmizee
 *
 */
@Controller
@RequestMapping("service/user")
public class UserController {
	
	private static final Logger LOG = Logger.getLogger(UserController.class);
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	CustomMapper mapper;
	
	@ResponseBody
	@RequestMapping(value = "/findAll", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseData<UserTableDto> findAll(@Valid @RequestBody RequestData<CriteriaUserTable> requestData) {
		LOG.info(requestData.getSerch().getUsername());
		PageRequest pageRequest = BuildPageRequest.build(requestData,UserTableDto.class);
		Page<User> page = userDao.findByAllFields(pageRequest, requestData.getSerch());
		return new ResponseData<UserTableDto>(mapper.map(page, UserTableDto.class));
	}
	

	
}
