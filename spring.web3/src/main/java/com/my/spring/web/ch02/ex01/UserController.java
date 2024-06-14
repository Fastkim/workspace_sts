package com.my.spring.web.ch02.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("ch02/ex01")
public class UserController {
	@GetMapping("11")
	public ModelAndView handler11(ModelAndView mv) { // 이친구는 Model + view야
		mv.addObject("user", new User("최한석", 11));
		mv.setViewName("ch02/ex01/user");
		
		return mv;
	}
	
	@GetMapping("21")
	public String handler21(Model model) {
		model.addAttribute("user", new User("한아름", 21));
		return "ch02/ex01/user"; // 2개의 model이 1개의 view를 공유(재사용)할수 있다.
	}
	
	@GetMapping("22")
	public String handler22() {
		return "ch02/ex01/user"; // 해당 jsp에 el을 썻기때문에 /가 나옴.
	}
	
	@GetMapping("31")
	public void handler31(User user) { // User의 맨앞글자 소문자 user가 model의 이름이 된다, parameter model타입은 기본생성자로 user객체를 생성하므로 기본생성자가 있어야한다.
		user.setUsername("양승일");
		user.setAge(31); //return이 없으면 RequestMapping + GetMapping = ch02/ex01/31 경로의 view가 있어야한다.
	}
	
	@GetMapping("32")
	public void handler32(@ModelAttribute("man") User user) { // model이름을 위와는 다르게 수동으로 입력하고 싶을때
		 user.setUsername("서준환");
		 user.setAge(32);
	}
	
	@GetMapping("41")
	public User handler41(User user) {
		user.setUsername("김가람");
		user.setAge(4);
		
		return user; //model을 return 하는경우
	}
	
	@GetMapping("42")
	@ModelAttribute("man") //model이름을 설정
	public User handler42(User user) {
		user.setUsername("박건우");
		user.setAge(42);
		
		return user;
	}
}
