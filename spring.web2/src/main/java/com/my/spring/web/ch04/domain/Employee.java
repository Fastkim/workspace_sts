package com.my.spring.web.ch04.domain;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Employee {
	private int employeeId;
	private String lastName;
	private LocalDate hireDate;
}
