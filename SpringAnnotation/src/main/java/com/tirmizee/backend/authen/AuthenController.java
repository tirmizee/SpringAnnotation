package com.tirmizee.backend.authen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tirmizee.backend.dao.UserDao;

@Controller
public class AuthenController {

	@Autowired
	UserDao userDao;
	
	@RequestMapping(value="/" , method=RequestMethod.GET)
	public ModelAndView index(ModelAndView modelAndView) {
		modelAndView.setViewName("index");
		return modelAndView;
	}
}
