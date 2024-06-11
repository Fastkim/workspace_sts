package ch05.domain;

import java.time.LocalDate;

public class Employee {
	private int employeeId;
	private String lastName;
	private LocalDate hireDate;
	
	@Override
	public String toString() {
		return employeeId + ", " + lastName + ", " + hireDate;
	}
}

// 과제:
// 100번 사원을 조회하라.
