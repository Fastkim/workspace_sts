package com.my.spring.web.ch02.ex04;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ch02/ex04")
public class CheckController {
	@GetMapping
	public String main() {
		return "ch02/ex04/main";
	}
	
	@GetMapping("choice")
	public String choice(int kind) {
		String view = "ch02/ex04/";
		
		view += switch(kind) {
		case 1 -> "radioIn";
		default -> "checkboxIn";
		};
		
		return view;
	}
	
	@PostMapping("radio")
	public String agree(String agree, Model model) {
		model.addAttribute("agree", agree);
		
		return "ch02/ex04/radioOut";
	}
}
