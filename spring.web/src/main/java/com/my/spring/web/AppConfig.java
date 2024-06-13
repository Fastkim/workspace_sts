package com.my.spring.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
	@Value("${attachPath}")
	private String attachPath; //application properties의 값을 불러옴
	
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
		registry.addResourceHandler("res/**").addResourceLocations("WEB-INF/res/");
		registry.addResourceHandler("attach/**").addResourceLocations("file:///" + attachPath + "/"); // file:/// -> file protocal
//		addResourceHandler("res/**"): handler가 처리하고있는 주소(즉 jsp파일의 c:url value값)
//		addResourceLocations("WEB-INF/res/"): 실제 resource가 위치하고 있는 주소
		// 절대주소 -> context-path가 포함된 주소
	}

}
