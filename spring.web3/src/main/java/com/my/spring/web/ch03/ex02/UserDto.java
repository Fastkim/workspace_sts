package com.my.spring.web.ch03.ex02;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserDto { // 사진은 binary
	private String username;
	private int age;
	private MultipartFile face;
}
