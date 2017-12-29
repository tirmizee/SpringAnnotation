package com.tirmizee.backend.page.root;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tirmizee.backend.dao.PermissionDao;
import com.tirmizee.backend.dao.UserDao;
import com.tirmizee.core.commons.CustomMapper;

/**
 * @author tirmizee
 *
 */
@Controller
public class RootPageController {

	private static final Logger LOGGER =  Logger.getLogger(RootPageController.class);
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	PermissionDao permissionDao;
	
	@Autowired 
 	CustomMapper mapper;
	
	@Autowired
	ApplicationContext app;
	
	@RequestMapping(value="/" , method=RequestMethod.GET)
	public ModelAndView index(ModelAndView modelAndView,@RequestParam(value = "error", required = false) String error) {
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
		ModelAndView model = new ModelAndView("index");
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
		return model;
	}
	
}
