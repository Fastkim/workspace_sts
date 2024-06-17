package com.my.spring.web.ch03.ex02;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller("ch03.ex02")
@RequestMapping("ch03/ex02/user2")
public class UserController {
	@Value("${attachPath}") private String attachPath;
	
	@GetMapping
	public String userIn() {
		return "ch03/ex02/userIn";
	}
	
	@PostMapping
	public String userOut(UserDto userDto, User user) {
		String filename = userDto.getFace().getOriginalFilename();
		saveFile(attachPath + "/" + filename, userDto.getFace()); // 파일을 받아서 서버에 업로드 하기
		user.setFaceFilename(filename); //String 타입의 데이터만 DB에 저장
		return "ch03/ex02/userOut";
	}
	
	private void saveFile(String filename, MultipartFile file) {
		try {
			file.transferTo(new File(filename));
		} catch(IOException e) {}
	}
}
