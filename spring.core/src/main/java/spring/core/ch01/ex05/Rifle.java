package spring.core.ch01.ex05;

import org.springframework.stereotype.Component;

//@Component("rifleGun") //수동으로 ID를 부여하고싶을때
public class Rifle implements Gun {
	@Override
	public void fire() {
		System.out.println("소총 탕탕.");
	}
}
