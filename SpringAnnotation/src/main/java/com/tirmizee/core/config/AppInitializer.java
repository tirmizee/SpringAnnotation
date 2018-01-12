package com.tirmizee.core.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author tirmizee
 *
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		servletContext.addListener(SessionListenerConfig.class);
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{
			AppConfig.class,
			RepositoryConfig.class,
			DozerMapperConfig.class
		};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{ WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{ "/" };
	}
	
	

}
