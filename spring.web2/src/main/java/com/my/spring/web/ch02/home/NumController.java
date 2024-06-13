package com.my.spring.web.ch02.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ch02/home")
public class NumController {
	@GetMapping("numIn")
	public String numinIn() {
		return "ch02/home/numIn";
	}
	
	@PostMapping("numIn")
	public String numOut(Number num) { // commander를 쓰기 때문에 model에 setter가 있어야한다.
		return "ch02/home/numOut";
	}
	/*
	@PostMapping("numIn")
	public String numIn(String randomNumber, Model model) {
		if(randomNumber != null) {
			double x = Math.floor((Math.random() + Integer.parseInt(randomNumber)) * 10) / 10;
			model.addAttribute("randomNumber", x);
		}
		return "ch02/home/numOut";
	}
	*/
}
