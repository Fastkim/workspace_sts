package com.my.spring.web.ch05.ex01;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.my.spring.web.ch05.domain.User;

@RestController("ch05.ex01")
@RequestMapping("ch05/ex01")
public class UserController {
	@GetMapping("main")
	public ModelAndView main(ModelAndView mv) {
		mv.setViewName("ch05/ex01/main");
		return mv;
	}
	
	@GetMapping("get") // Request header에 포함.
	public User get(User user) { //@RequestParam 생략, User commander
		return user;
	}
	
	@PostMapping("post") 
	public User post(@RequestBody User user) { //parameter가 json인경우 @RequestBody, 일반 text인경우: @RequestParam
		return user;
	}
	
	@PutMapping("put") // putMapping 이후로는 @RequestBody만 있음
	public User put(@RequestBody User user) {
		return user;
	}
	
	@PatchMapping("patch")
	public User patch(@RequestBody User user) {
		return user;
	}
	
	@DeleteMapping("delete")
	public User delete(@RequestBody User user) {
		return user;
	}
}

// single page app(SPA): html로 만들어진 page는 하나다, 즉 server가 클라이언트로 보내는 page는 하나이다.