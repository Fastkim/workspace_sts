package com.my.spring.web.ch02.home;

import lombok.Setter;

@Setter
public class Number {
	private double num;
	
	public double getNum() { // commander로 사용
		return num + (int)(Math.random() *  10) / 10.0;
	}
}
