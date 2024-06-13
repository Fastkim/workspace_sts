package com.my.spring.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //@ComponentScan을 포함하고있음.
@MapperScan("com.my.spring.web.ch04.dao.map")
//@ComponentScan("spring.web.ch02.ex02") // bean Id(userController)가 겹친다, 이렇게 scane 경로를 지정해도 되고 클래스이름을 변경해도된다.
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
