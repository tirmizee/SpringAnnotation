package com.tirmizee.backend.service.user;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tirmizee.backend.dao.UserDao;
import com.tirmizee.backend.service.UserService;
import com.tirmizee.backend.service.user.data.CriteriaUser;
import com.tirmizee.backend.service.user.data.UserDto;
import com.tirmizee.backend.service.user.data.UserStatus;
import com.tirmizee.backend.service.user.data.UserTableDto;
import com.tirmizee.core.commons.CustomMapper;
import com.tirmizee.core.datatable.BuildPageRequest;
import com.tirmizee.core.datatable.RequestData;
import com.tirmizee.core.datatable.ResponseData;
import com.tirmizee.core.exception.BusinessException;

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
	UserService userService; 
	
	@Autowired
	CustomMapper mapper;
	
	@ResponseBody
	@RequestMapping(value = "/findAll", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseData<UserTableDto> findAll(@Valid @RequestBody RequestData<CriteriaUser> requestData) {
		PageRequest pageRequest = BuildPageRequest.build(requestData,UserTableDto.class);
		Page<UserTableDto> page = userDao.findByAllFields(pageRequest, requestData.getSerch());
		return new ResponseData<UserTableDto>(page);
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateStatus" , method = RequestMethod.POST, headers = "Accept=application/json")
	public boolean updateStatus(@Valid @RequestBody UserStatus userStatus) {
		LOG.debug(userStatus.getId() + " : " + userStatus.getStatus());
		return userDao.updateStatus(userStatus);
	}
	
	@ResponseBody
	@RequestMapping(value = "/update" , method = RequestMethod.POST, headers = "Accept=application/json")
	public boolean update(@Valid @RequestBody UserDto dto) {
		return userService.update(dto);
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete/{id}" , method = RequestMethod.GET, headers = "Accept=application/json")
	public boolean update(@PathVariable Long id)  throws Exception {
		if(id == 1){
			throw new BusinessException(HttpStatus.CONFLICT,"hello world");
		}
		if(id == 2){
			throw new BusinessException(HttpStatus.FOUND,"hello 555");
		}
		try { userDao.delete(id); } catch (Exception e) { return false; }
		return true;
		
	}

}
