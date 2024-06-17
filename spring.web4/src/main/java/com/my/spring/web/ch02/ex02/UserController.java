package com.my.spring.web.ch02.ex02;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//현재 ex01, ex02에 UserController 클래스이름이 동일하므로 container에서 오류 발생
//따라서 이름을 따로 지정
@Controller("ch02.ex02") // requestMapping이 없으면 Controller 이름따라감
public class UserController {
	@GetMapping("ch02/ex02/userIn")
	public String userIn() {
	    return "ch02/ex02/userIn";
	}
	
	@PostMapping("ch02/ex02/userOut")
	public String userOut(@RequestParam String username, //@RequestParam은 생략이 가능하다.
			@RequestParam int age,
			@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd")LocalDate regDate,
			Model model) { //@RequestParam은 생략이 가능함.)	
		model.addAttribute("user", new User(username, age, regDate));
		return "ch02/ex02/userOut";
	}
}
