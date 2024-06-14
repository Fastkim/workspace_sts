package com.my.spring.web.ch04.dao.map;

import com.my.spring.web.ch04.domain.Employee;

public interface EmployeeMap { // mapper,dao - persistence layer
	Employee selectEmployee(int employeeId);
}
