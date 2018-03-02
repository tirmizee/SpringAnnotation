package com.tirmizee.backend.page.admin;

import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tirmizee.core.commons.CustomMapper;
import com.tirmizee.core.commons.LabelManager;
import com.tirmizee.core.security.IAuthenticationUser;
import com.tirmizee.core.security.UserProfileDto;

@Controller
public class AdminPageController {
	
	private static Logger LOGGER = Logger.getLogger(AdminPageController.class);
	
	@Autowired 
	private CustomMapper mapper;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private IAuthenticationUser userProfile;
	
	@Autowired
	ServletContext servletContext;
	
	@PreAuthorize("hasAnyAuthority('AD000')")
	@RequestMapping(value="/admin" , method=RequestMethod.GET)
	public ModelAndView index(Locale locale,ModelAndView model){
		final String pathLabel = "i18n/label/admin/index/index_" + locale;
		Map<String, String> label = LabelManager.path(servletContext.getRealPath(pathLabel));
		model.addObject("user", mapper.map(userProfile.getActiveUser(), UserProfileDto.class));
		model.addObject("label",label);
		model.setViewName("pages/admin_index");
		return model;
	}
	
	@PreAuthorize("hasAnyAuthority('AD001')")
	@RequestMapping(value="/admin/test" , method=RequestMethod.GET)
	public ModelAndView permission(Locale locale,ModelAndView model){
		LOGGER.debug(messageSource.getMessage("welcome.message",new Object[]{locale},locale));
		model.setViewName("pages/test");
		model.addObject("user", mapper.map(userProfile.getActiveUser(), UserProfileDto.class));
		return model;
	}
	
	@PreAuthorize("hasAnyAuthority('AD002')")
	@RequestMapping(value="/admin/session" , method=RequestMethod.GET)
	public ModelAndView session(Locale locale,ModelAndView model){
		LOGGER.debug(messageSource.getMessage("welcome.message",new Object[]{locale},locale));
		model.setViewName("pages/admin_session");
		model.addObject("user", mapper.map(userProfile.getActiveUser(), UserProfileDto.class));
		return model;
	}
	
}
