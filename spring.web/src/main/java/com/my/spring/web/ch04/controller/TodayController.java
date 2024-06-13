package com.my.spring.web.ch04.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.my.spring.web.ch04.service.TodayService;

@Controller
public class TodayController {
	@Autowired private TodayService todayService;
	
	@GetMapping("ch04/today")
	@ModelAttribute("today") // model이름 : today
	public LocalDate today() {
		return todayService.getToday();
	}
	
	//과제: 100번 사원 출력 하드코딩(sql 말구 controller에서)
	
}
