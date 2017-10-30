package com.hack.yeah;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.hack.yeah.service.SecurityService;
import com.hack.yeah.service.SecurityServiceImpl;
import com.hack.yeah.service.UserService;
import com.hack.yeah.service.UserServiceImpl;

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
