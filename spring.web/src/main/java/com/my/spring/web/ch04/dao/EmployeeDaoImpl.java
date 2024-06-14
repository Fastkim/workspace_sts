package com.my.spring.web.ch04.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.spring.web.ch04.dao.map.EmployeeMap;
import com.my.spring.web.ch04.domain.Employee;

@Repository // @component + persistency layer라는 상징성 = @Repository, EmployeeDaoImpl 객체를 container에 DI하기 위해 쓰는 어노테이션
public class EmployeeDaoImpl implements EmployeeDao {
	//application.class의 @MapperScan("com.my.spring.web.ch04.dao.map")을 읽으면서 container에 mapper객체가 생성.
	@Autowired private EmployeeMap employeeMap;
	
	@Override
	public Employee selectEmployee(int employeeId) {
		return employeeMap.selectEmployee(employeeId);
	}
}
