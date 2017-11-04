package com.app.ijoin;

import com.app.ijoin.service.SecurityService;
import com.app.ijoin.service.SecurityServiceImpl;
import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.app.ijoin.service.UserService;
import com.app.ijoin.service.UserServiceImpl;

@Configuration
@ComponentScan("com.demo.rest")
public class WebConfiguration extends WebMvcConfigurerAdapter {
	//private static final String[] RESOURCES_LOCATION = {"/WEB-INF/view/"};
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.err.println("ADDING RESOURCES");
		registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/static/");
	}	
	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}
	@Bean 
	public SecurityService securityService() {
		return new SecurityServiceImpl();
	}
}
