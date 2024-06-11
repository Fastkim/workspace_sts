package spring.core.ch01.ex05;

import org.springframework.stereotype.Component;

//@Component
public class Pistol implements Gun { // bean의 아이디는 클래스의 앞글자를 소문자로 바꿔서 자동등록
	@Override
	public void fire() {
		System.out.println("권총 탕탕.");
	}
}
