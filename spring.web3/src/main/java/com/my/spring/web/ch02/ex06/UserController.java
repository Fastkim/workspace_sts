package com.my.spring.web.ch02.ex06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller("ch02.ex05")
@RequestMapping("ch02/ex06")
public class UserController {
	@GetMapping("login")
	public String loginIn(@CookieValue(required=false) String username,
			@ModelAttribute("user") UserDto user) { // required: 쿠기가 있으면 받고, 없으면 받지말고
		user.setUsername(username);
		return "ch02/ex06/login";
	}
	
	@PostMapping("login")
	public String login(@ModelAttribute("user") UserDto user, String rememberMe,
			HttpSession session, HttpServletResponse response) {
		session.setAttribute("username", user.getUsername());
		
		if(rememberMe != null && rememberMe.equals("on")) {
			Cookie cookie = new Cookie("username", user.getUsername());
			cookie.setMaxAge(5);
			response.addCookie(cookie);
		}
		
		return "ch02/ex06/login";
	}
	
	// http request, response 는 매번 서버를 끊고 연결한다
	// session 객체가 살아있으면 클라이언트 서버간의 연결이 유지되어있다고 판단
	// http protocal 특성상 물리적으로 연결은 이미 끊겼다.
	// 하지만 논리적으로 끊는작업이 필요함
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login"; //A와 B가 다른작업일때 redirect, 같은작업일때 forward
	}
}
