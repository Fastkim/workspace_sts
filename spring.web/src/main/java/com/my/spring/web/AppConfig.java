package com.my.spring.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("ch01/main");	
		registry.addViewController("ch02/ex03/user").setViewName("ch02/ex03/userIn");
		// method는 기본값: get이다.
		// addViewController("/"): model이 없는 view만 찾아서 add
		// view의 이름:(WEB-INF/VIEW/)ch01/main(.jsp) // viewController: model이 없는 view만 보여주는 controller
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("hello/**").addResourceLocations("WEB-INF/res/hello/"); 
		// addResourceHandler("res/**") 여기서 res를 "WEB-INF/res/" 경로룰 넣는다고 생각하면된다.
	}

}
