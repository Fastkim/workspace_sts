package com.my.spring.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // Spring에서 Bean을 수동으로 등록하기 위해서 사용
public class AppConfig implements WebMvcConfigurer { //WebMvcConfigurer: MVC 구성정보 제어
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("ch01/main");
	}
}
