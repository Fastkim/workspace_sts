package com.my.spring.web.ch03.ex02;

import lombok.Data;

@Data
public class User {
	private String username;
	private int age;
	private String faceFilename;
}

// 클라이언트에 resource 파일명만 넘기면 미디어서버가 파일을 생성해줌.
// 
