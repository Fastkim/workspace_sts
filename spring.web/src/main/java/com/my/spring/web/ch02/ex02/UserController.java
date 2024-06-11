package com.my.spring.web.ch02.ex02;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("ch02.ex02")
public class UserController {
	@GetMapping("ch02/ex02/userIn") // CRUD중에 R(유저입장)
	public String userIn() { //userIn handler
		return "ch02/ex02/userIn"; // 사용자에게 값을 입력받으므로 view만 필요, 모델필요없음
	} // 이 handler를 call한놈은 container이다, 즉 return값은 container에게 간다. 
	/*
	@PostMapping("ch02/ex02/userOut") // CRUD중에 C(유저입장)에 해당
	public String userOut(@RequestParam String username,
			@RequestParam int age,
			@RequestParam @DateTimeFormat(pattern="yyyy-mm-dd") LocalDate regDate, 
			Model model) { // parameter로 text가 오지만 casting이 자동으로 되서 온다.
		model.addAttribute("user", new User(username, age, regDate));
		return "ch02/ex02/userOut";
	}
	*/
	@PostMapping("ch02/ex02/userOut") //@RequestParam은 생략할 수도 있다.
	public String userOut(String username,
			int age,
			@DateTimeFormat(pattern="yyyy-mm-dd") LocalDate regDate, 
			Model model) {
		model.addAttribute("user", new User(username, age, regDate));
		return "ch02/ex02/userOut";
	}
} 
// container는 return받은 viewName(url)에 prefix,suffix를 붙여서 물리적인 값을 보낸다. tomcat내부의 default servlet이 해당 url을 전해받는다.
// servlet은 tomcat container가 만듬.
// spring container도 servlet이다, container는 tomcat안의 servlet중에 하나이다,  
// spring container < -http- > tomcat < -http- > client(browser) 