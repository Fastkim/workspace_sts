package spring.core.ch01.ex05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class Shooter {
	@Autowired @Nullable private Gun pistol; // 현시간부로 DI는 Autowired로 하라. nullable : null이어도 괜찮아.
	@Autowired @Nullable private Gun rifleGun; // Container가 Ioc,DI 작업을 수행한다.
	
	public void fire() {
		pistol.fire();
		rifleGun.fire();
	}
	
}
