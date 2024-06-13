package com.my.spring.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //@ComponentScan을 포함하고있음.
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
