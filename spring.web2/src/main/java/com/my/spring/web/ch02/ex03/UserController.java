package com.my.spring.web.ch02.ex03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("ch02.ex03")
@RequestMapping("ch02/ex03/user")
public class UserController {
	@GetMapping
	public String userIn() {
		return "ch02/ex03/userIn";
	}
	
	@PostMapping
	public String userOut(User user) { // command 객체(user): model의 경우 기본생성자가 필요하지만, 굳이 필요하지않다. AllArgsConstructor로 가능
		return "ch02/ex03/userOut"; // 얘도 모델이 존재한다.
	}
	// handler가 user객체를 바라보는 관점: command, model
	// request url이 ch02/ex03/user로 동일하면 GetMapping/postMapping으로 구분한다.
}
