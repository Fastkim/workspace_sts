package com.my.hr.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Laborer {
	private int laborerId;
	private String laborerName;
	private LocalDate hireDate;
}