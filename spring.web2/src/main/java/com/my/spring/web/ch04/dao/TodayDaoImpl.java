package com.my.spring.web.ch04.dao;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.spring.web.ch04.dao.map.TodayMap;

@Repository
public class TodayDaoImpl implements TodayDao {
	@Autowired private TodayMap todayMap; // Application @MapperScan으로 넣는다. DI
	
	@Override
	public LocalDate selectToday() {
		return todayMap.selectToday();
	}
}
