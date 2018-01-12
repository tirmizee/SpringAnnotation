package com.tirmizee.backend.page.admin;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tirmizee.core.commons.CustomMapper;
import com.tirmizee.core.security.UserProfile;
import com.tirmizee.core.security.UserProfileDto;

@Controller
public class AdminPageController {
	
	private static Logger LOG = Logger.getLogger(AdminPageController.class);
	
	private UserProfile userProfile;
	
	@Autowired 
	CustomMapper mapper;
	
	@PreAuthorize("hasAnyAuthority('AD000')")
	@RequestMapping(value="/admin" , method=RequestMethod.GET)
	public ModelAndView index(Authentication authentication){
		userProfile = (UserProfile)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView model = new ModelAndView();
		model.addObject("user", mapper.map(userProfile, UserProfileDto.class));
		model.setViewName("pages/admin_index");
		return model;
	}
	
	@PreAuthorize("hasAnyAuthority('AD001')")
	@RequestMapping(value="/admin/permission" , method=RequestMethod.GET)
	public ModelAndView permission(Authentication authentication){
		userProfile = (UserProfile)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView model = new ModelAndView("pages/admin_permission");
		model.addObject("user", mapper.map(userProfile, UserProfileDto.class));
		return model;
	}
	
	@PreAuthorize("hasAnyAuthority('AD002')")
	@RequestMapping(value="/admin/session" , method=RequestMethod.GET)
	public ModelAndView session(Authentication authentication){
		userProfile = (UserProfile)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView model = new ModelAndView("pages/admin_session");
		model.addObject("user", mapper.map(userProfile, UserProfileDto.class));
		return model;
	}
	
}
