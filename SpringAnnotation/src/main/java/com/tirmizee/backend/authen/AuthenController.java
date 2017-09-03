package com.tirmizee.backend.authen;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tirmizee.backend.dao.UserDao;
import com.tirmizee.core.CustomMapper;
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
	public ModelAndView index(ModelAndView modelAndView,@RequestParam(value = "error", required = false) String error) {
		modelAndView.setViewName("index");
		List<User> list = Arrays.asList(
				new User(null,"a",null,null,null),
				new User(null,"b",null,null,null)
			);
 		List<User> map = mapper.map(list, User.class);
 		LOGGER.info(map.get(0).getUsername());
		return modelAndView;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			System.out.println("Invalid username and password!");
			model.addObject("error", "Invalid username and password!");
		}
		model.setViewName("index");

		return model;

	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView admin() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/admin");
		return model;

	}
	
}
