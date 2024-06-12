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

@Controller("ch02.ex06")
@RequestMapping("ch02/ex06")
public class UserController {
	@GetMapping("login")
	public String loginIn(@CookieValue(required=false) String username,
			@ModelAttribute("user") UserDto user) {
		user.setUsername(username);
		return "ch02/ex06/login";
	}
	
	@PostMapping("login")
	public String login(@ModelAttribute("user") UserDto user, String rememberMe,
			HttpSession session, HttpServletResponse response) { // @ModelAttribute("user") 안쓰면 userDto가 requestParameter name이 된다.
		session.setAttribute("username", user.getUsername());
		
		if(rememberMe != null && rememberMe.equals("on")) {
			Cookie cookie = new Cookie("username", user.getUsername());
			cookie.setMaxAge(5);
			response.addCookie(cookie);
		}
		
		return "ch02/ex06/logout"; //view에 response가 담겨 전달된다.
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		//logout handler를 구현하라.
		session.invalidate(); // 논리적으로 session이 없으면 tomcat은 client와 연결이 끊겼다고 판단
		return "redirect:login"; // A와 B가 하나의 작업이면 forward, A와 B가 구분된 별도의 작업이면 redirect
	}
}
