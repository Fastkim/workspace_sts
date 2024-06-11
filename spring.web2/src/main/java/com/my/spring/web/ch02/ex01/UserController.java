package com.my.spring.web.ch02.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //@Component를 포함하므로 IoC이다.
@RequestMapping("ch02/ex01") // request를 받기위한 url
public class UserController {
	@GetMapping("11") // 어떤메서드가 request를 받을지 설정하는 url
	public ModelAndView handler11(ModelAndView mv) { // handler(request를 handling하는 메서드)
		mv.addObject("user", new User("최한석", 11)); // modelName: user, modelValue: new User
		mv.setViewName("ch02/ex01/user");
		
		return mv; // mv 객체는 container가 받는다.
	}
	
	@GetMapping("21") // handler가 되려면 @GetMapping을 붙이면된다.
	public String handler21(Model model) { // view는 1개인데 모델이 2개, 그릇
		model.addAttribute("user", new User("한아름", 21));
		return "ch02/ex01/user";
	}
	
	@GetMapping("22")
	public String handler22() { // view의 이름(url)만 return
		return "ch02/ex01/user";
	}
	
	@GetMapping("31") // model: User user
	public void handler31(User user) { // model 자체를 준비, 주의사항: container가 model 객체를 만들때 기본생성자를 call하기 때문이다.
		user.setUsername("양승일"); // attributeName이 user로 자동지정되었다.
		user.setAge(31);
	}
	
	@GetMapping("32")
	public void handler32(@ModelAttribute("man") User user) { // attributeName을 man으로 지정
		user.setUsername("서준한");
		user.setAge(32);
	}
	
	@GetMapping("41")
	public User handler41(User user) {
		user.setUsername("김가람");
		user.setAge(4);
		return user;
	}
	
	@GetMapping("42")
	@ModelAttribute("man")
	public User handler42(User user) {
		user.setUsername("최건우");
		user.setAge(42);
		return user;
	}
}
