package com.my.spring.web.ch04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.my.spring.web.ch04.domain.Employee;
import com.my.spring.web.ch04.service.EmployeeService;

@Controller // controller는 http request를 받지만, dao, service는 받지않는다.
public class EmployeeController {
	@Autowired private EmployeeService employeeService;
	
	@GetMapping("ch04/employee/{employeeId}") // path-Variable: url path에 variable을 포함시킬때 쓰는 문법이다.
	public String getEmployee(@PathVariable int employeeId, Model model) { // parameter로 받는것 3개지: @requestParam, @CookieValue, @PathVariable
		Employee employee = employeeService.getEmployee(employeeId);
		model.addAttribute("employee", employee);
		return "ch04/employee";
	}
}
