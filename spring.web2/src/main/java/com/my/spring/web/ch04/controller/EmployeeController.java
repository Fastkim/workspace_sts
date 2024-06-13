package com.my.spring.web.ch04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.my.spring.web.ch04.domain.Employee;
import com.my.spring.web.ch04.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired private EmployeeService employeeService;
	
	@GetMapping("ch04/employee")
	@ModelAttribute("employee")
	public Employee employee() {
		return employeeService.getEmployee(100);
	}
}
