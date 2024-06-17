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
	public ModelAndView handler11(ModelAndView mv) { // 이 친구는 Model + view야
		mv.addObject("user", new User("최한석", 11));
		mv.setViewName("ch02/ex01/user");
		
		return mv;
	}
	
	@GetMapping("21")
	public String handler21(Model model) {
		model.addAttribute("user", new User("한아름", 21));
		return "ch02/ex01/user"; // 2개의 model이 1개의 view를 공유(재사용)할 수 있다.
	}
	
	@GetMapping("22")
	public String handler22() {
		return "ch02/ex01/user"; // 해당 jsp에 el을 썻기때문에 /만 출력됨.
	}
	
	@GetMapping("31")
	public void handler31(User user) {
		user.setUsername("양승일");
		user.setAge(31);
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
	public User handler42(User user) {
		user.setUsername("박건우");
		user.setAge(42);
		
		return user;
	}
}
