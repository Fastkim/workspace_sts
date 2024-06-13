package com.my.spring.web.ch03.ex02;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserDto {
	private String username;
	private int age;
	private MultipartFile face;
}
// Dto에는 Setter가 있어야 commander역할을 수행가능
// binary 데이터는 body에 있다.


