package com.tirmizee.backend.authen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.tirmizee.backend.authen.data.Certiria;
import com.tirmizee.backend.dao.PermissionDao;
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
	@Qualifier("UserDao")
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
		ModelAndView model = new ModelAndView();
		if (error != null) {
			System.out.println("Invalid username and password!");
			model.addObject("error", "Invalid username and password!");
		}
		model.setViewName("index");
		return model;
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView admin() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/admin");
		return model;
	}
	
	@PreAuthorize("hasAnyAuthority('USER')")
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
	
	
	@ResponseBody
	@RequestMapping(value = "/test2", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public Map<String,Object> test2(@RequestBody Certiria s) {
		LOGGER.debug("/test2");
		LOGGER.debug(s.getDraw());
		LOGGER.debug(s.getStart());
		LOGGER.debug(s.getLength());
		Map<String, Object> map = new HashMap<>();
		map.put("data", new ArrayList<User>((Collection<? extends User>) userDao.findAll()));
		map.put("draw", s.getDraw());
		map.put("recordsTotal", 2);
		map.put("recordsFiltered", 2);
		return map;
	}

	
	@RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json")
	public String save(@RequestBody Certiria certiria) {
//		LOGGER.debug(certiria.getDraw());
		return "index";
	}
	
}
