package com.tirmizee.core.config;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

public class SessionListenerConfig implements HttpSessionListener {

	private static final Logger LOG = Logger.getLogger(SessionListenerConfig.class); 
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		 System.out.println("==== Session is created ====");	
		 event.getSession().setMaxInactiveInterval(1*60);
		 LOG.debug("CreationTime" + event.getSession().getCreationTime());
		 LOG.debug("Id" + event.getSession().getId());
		 LOG.debug("CreationTLastAccessedTimeime" + event.getSession().getLastAccessedTime());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		 System.out.println("==== Session is destroyed ====");
		 LOG.debug("CreationTime" + event.getSession().getCreationTime());
		 LOG.debug("Id" + event.getSession().getId());
		 LOG.debug("CreationTLastAccessedTimeime" + event.getSession().getLastAccessedTime());
	}

}
