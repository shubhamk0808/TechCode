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
		registry.addViewController("/notice").setViewName("notice");
		registry.addViewController("/research").setViewName("research");
		registry.addViewController("/scholarship").setViewName("scholarship");
		registry.addViewController("/events").setViewName("events");
		registry.addViewController("/blog").setViewName("blog");
		registry.addViewController("/teacher").setViewName("teacher");
		registry.addViewController("/teacher-single").setViewName("teacher-single");
		registry.addViewController("/notice-single").setViewName("notice-single");
		registry.addViewController("/course-single").setViewName("course-single");
		registry.addViewController("/event-single").setViewName("event-single");
		registry.addViewController("/blog-single").setViewName("blog-single");
	}
}
