package com.tirmizee.backend.authen;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tirmizee.backend.dao.UserDao;
import com.tirmizee.core.util.CustomMapper;
import com.tirmizee.repository.entities.User;

/**
 * @author tirmizee
 *
 */
@Controller
public class AuthenController {

	private static final Logger LOGGER =  Logger.getLogger(AuthenController.class);
	
	@Autowired
	UserDao userDao;
	
	@Autowired 
	CustomMapper mapper;
	
	@RequestMapping(value="/" , method=RequestMethod.GET)
	public ModelAndView index(ModelAndView modelAndView) {
		modelAndView.setViewName("index");
		User user = new User(1L, "admin", "admin", new Date(), null);
		User map = mapper.map(user, User.class);
		LOGGER.info(map.getUsername());
		return modelAndView;
	}
	
	@RequestMapping(value="/admin" , method=RequestMethod.GET)
	public ModelAndView admin(ModelAndView modelAndView) {
		modelAndView.setViewName("admin/admin");
		return modelAndView;
	}
}
