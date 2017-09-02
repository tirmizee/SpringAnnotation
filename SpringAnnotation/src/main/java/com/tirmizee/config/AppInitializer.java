package com.tirmizee.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author tirmizee
 *
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

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
