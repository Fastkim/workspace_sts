package com.my.spring.web.ch02.ex01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // handler에다 model객체를 집어넣을때 사용하는 기본생성자
@AllArgsConstructor
public class User {
	private String username;
	private int age;
}
