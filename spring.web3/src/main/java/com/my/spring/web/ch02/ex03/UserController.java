package com.my.spring.web.ch02.ex03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("ch02.ex03")
@RequestMapping("ch02/ex03/user") //공통된 request url을 받았을때 requestMethod로 구분(Get/Post)
public class UserController {
	@GetMapping
	public String userIn() {
		return "ch02/ex03/userIn";
	}
	
	@PostMapping
	public String userOut(User user) {
		// command = model과 domain의 이름이 동일할때 개념이생김,
		// Setter가 없으므로 생성자 이용해서 커맨드에 DI를 진행함.
		return "ch02/ex03/userOut";
	}
}
