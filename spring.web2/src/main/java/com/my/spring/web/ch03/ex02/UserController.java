package com.my.spring.web.ch03.ex02;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


@Controller("ch03.ex03")
@RequestMapping("ch03/ex02/user")
public class UserController {
	@Value("${attachPath}") private String attachPath; // property injection
	
	@GetMapping
	public String userIn() {
		return "ch03/ex02/userIn";
	}
	
	@PostMapping
	public String userOut(UserDto userDto, User user) {
		String filename = userDto.getFace().getOriginalFilename();
		saveFile(attachPath + "/" + filename, userDto.getFace());
		
		user.setFaceFilename(filename);
		return "ch03/ex02/userOut";
	}
	
	private void saveFile(String filename, MultipartFile file) { //@Mapping 이 없으므로 handler가 아니다.
		try {
			file.transferTo(new File(filename));
		} catch(IOException e) {}
	}
}
