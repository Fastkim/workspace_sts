package com.my.spring.web;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class AppConfig implements WebMvcConfigurer {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("ch01/main");
		// addViewController("/"): model이 없는 view만 찾아서 add
		// view의 이름:(WEB-INF/VIEW/)ch01/main(.jsp) // viewController: model이 없는 view만 보여주는 controller
	}
}
