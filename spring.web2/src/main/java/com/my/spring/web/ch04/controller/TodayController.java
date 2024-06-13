package com.my.spring.web.ch04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.my.spring.web.ch04.service.TodayService;

@Controller // handler마다 request url을 지정하고싶으면 @requestMapping을 굳이 안써줘도 된다.
@RequestMapping("")
public class TodayController {
	@Autowired private TodayService todayService;
	
	@GetMapping("ch04/today")
}
