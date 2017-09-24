package com.tirmizee.backend.authen;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tirmizee.backend.dao.PermissionDao;
import com.tirmizee.backend.dao.UserDao;
import com.tirmizee.core.commons.CustomMapper;

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
	
	@PreAuthorize("hasAnyAuthority('AD000')")
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView admin() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/admin");
		return model;
	}
	
	@PreAuthorize("hasAnyAuthority('US000')")
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView user(Authentication authentication) {
		ModelAndView model = new ModelAndView();
		String user = authentication.getName();
		model.addObject("name", user);
		model.setViewName("user/user");
		LOGGER.debug(app.getApplicationName());
		LOGGER.debug(app.getId());
		return model;
	}
	
//	@RequestMapping(value = "/service/test", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public String test(@RequestBody List<De> list) {
//		LOGGER.debug(list.size());
//		return "";
//	}
	
}
