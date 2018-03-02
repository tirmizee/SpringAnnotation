package com.tirmizee.backend.page.user;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tirmizee.backend.page.admin.AdminPageController;
import com.tirmizee.core.commons.CustomMapper;
import com.tirmizee.core.security.UserProfile;
import com.tirmizee.core.security.UserProfileDto;

@Controller
public class UserPageController {

	private static Logger LOGGER = Logger.getLogger(AdminPageController.class);
	private UserProfile userProfile;
	
	@Autowired 
	CustomMapper mapper;
	
	@PreAuthorize("hasAnyAuthority('US000')")
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public ModelAndView index(Authentication authentication){
		userProfile = (UserProfile) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView model = new ModelAndView();
		model.addObject("user", mapper.map(userProfile, UserProfileDto.class));
		model.setViewName("user/user");
		return model;
	}
	
}
