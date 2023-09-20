package com.shubham.springmvc.techcode.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CommonViewController implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/courses").setViewName("courses");
		registry.addViewController("/about").setViewName("about");
	}
}
