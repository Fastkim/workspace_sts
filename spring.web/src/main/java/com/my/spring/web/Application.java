package com.my.spring.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //@ComponentScan을 포함하고있음.
@MapperScan("com.my.spring.web.**.dao.map")
//@ComponentScan("spring.web.ch02.ex02") // bean Id(userController)가 겹친다, 이렇게 scane 경로를 지정해도 되고 클래스이름을 변경해도된다.
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

//react
//RESTful : json을 통해 서버가 클라이언트에 데이터만 전달하고 view(front-end)는 클라이언트가 자체적으로 javascript언어를 가지고 동적인 뷰를 생성한다.
