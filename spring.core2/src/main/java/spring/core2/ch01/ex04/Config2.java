package spring.core2.ch01.ex04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.core2.ch01.ex01.Rifle;

@Configuration
public class Config2 {
	@Bean
	public Rifle rifle() {
		return new Rifle();
	}
}
