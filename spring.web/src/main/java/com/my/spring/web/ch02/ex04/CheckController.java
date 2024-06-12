package com.my.spring.web.ch02.ex04;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	/*
	@PostMapping("radio")
	public String radio(String agree, Model model) { // @requestParam 생략가능
		model.addAttribute("agree", agree);
		return "ch02/ex04/radioOut";
	}
	*/
	@PostMapping("radio")
	public String radio(@ModelAttribute("agree") String agree, Model model) { // @requestParam 생략가능
		return "ch02/ex04/radioOut";
	}
	
	@PostMapping("checkbox")
	public String checkbox(@RequestParam("fruit") List<String> fruits, Model model) { // @RequestParam("변수이름), fruits: list에 담을 변수이름
		model.addAttribute("fruits", fruits); // ArrayList도 가능하지만 그것보다 상위클래스(List)를 사용하는게 더 효율적
		return "ch02/ex04/checkboxOut";
	}
}
