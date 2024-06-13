package com.my.spring.web.ch04.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.my.spring.web.ch04.dao.TodayDao;

public class TodayServiceImpl implements TodayService {
	@Autowired private TodayDao todayDao; // spring에서는 의존성주입(DI)를 @Autowired로 명시해준다.
	
	@Override
	public LocalDate getToday() {
		return todayDao.selectToday();
	}
}
