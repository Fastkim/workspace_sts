package com.my.spring.web.ch02.ex05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ch02/ex05")
public class NavController {
	@GetMapping("forward")
	public String forward() {
		return "forward:target"; // 그동안은 view를 return했지만, 이젠 url을 사용
	}
	
	@GetMapping("target")
	public String target() {
		return "ch02/ex05/target";
	}
	
	@GetMapping("redirect")
	public String redirect() {
		return "redirect:target";
	}
	
	//과제: naver로 이동하라.
	@GetMapping("naver")
	public String naver() {	// A와 B가 다른서버에 있어도 이동가능한게 redirect
		return "redirect:https://www.naver.com";
	}
}
/*
dto (Data Transfer Object) domain ORmapping transfer
dto: domain을 transfer용으로 사용할때
model: domain을 ORmapping용으로 사용할때
*/
 
