package com.tirmizee.backend.service.session;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("service/session")
public class SessionController {

	@RequestMapping(value="/updateSession/{minute}" ,method=RequestMethod.GET,headers="Accept=application/json")
	public String updateSession(int minute,HttpSession sksk){
		return "";
	}
	
}
