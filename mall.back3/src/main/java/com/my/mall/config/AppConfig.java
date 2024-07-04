package com.my.mall.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.my.mall.controller.DateFormatter;

@Configuration
public class AppConfig implements WebMvcConfigurer {
	@Bean
	public ModelMapper getMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
			.setFieldMatchingEnabled(true)
			.setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE) //우리 필드는 private 필드이므로 private까지 접근가능하게.
			.setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper;
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) { //날짜 포맷 등록
		registry.addFormatter(new DateFormatter());
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) { // 이설정으로 프론트엔드와 원활하게 대화가능
		registry.addMapping("/**")
			.allowedOrigins("*") // origin은 다 허용
			.allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS") // METHOD는 허용할것만 기재
			.maxAge(300) //300초이라는 시간동안만 허용, 그 이후로는 연결 끊음
			.allowedHeaders("Authorization", "Cache-Control", "Content-type");
	}
}
