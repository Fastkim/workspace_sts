package com.my.spring.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.my.spring.web.**.dao.map") //해당 경로에 interface가 발견되면 mapper객체로 만들어주라
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
