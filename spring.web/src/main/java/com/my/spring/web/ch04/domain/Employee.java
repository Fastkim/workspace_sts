package com.my.spring.web.ch04.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Employee { // 과거에는 domain spring에서 현재는 model
	private int employeeId;
	private String lastName;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate hireDate; 
}
