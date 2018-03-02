package com.tirmizee.core.config;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author tirmizee
 *
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	
	private static final Logger LOGGER = Logger.getLogger(WebConfig.class);
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        
    }
	
	@Bean
	public LocaleResolver localeResolver()  {
	    CookieLocaleResolver resolver = new CookieLocaleResolver();
	    resolver.setDefaultLocale(Locale.ENGLISH);
	    resolver.setCookieName("Language");
	    resolver.setCookieMaxAge(30*60);
	    return resolver;
    }

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor(){

			@Override
			protected Locale parseLocaleValue(String locale) {
				locale = locale.replaceAll("[^a-zA-Z]", "").toLowerCase();
				if(locale.length() < 2){ return Locale.ENGLISH; }
				return super.parseLocaleValue(locale.substring(0, 2)) ;
			}
			
		};
        localeInterceptor.setParamName("lang");
        registry.addInterceptor(localeInterceptor);
	}
	
//    @Override
//    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(mappingJackson2HttpMessageConverter());
//    }
     
//    @Bean
//    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        converter.setObjectMapper(new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false));
//        return converter;
//    }
	
	

}
