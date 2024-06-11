package spring.core.ch02.ex04;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
	@Log
	public void add() { //@Log를 명시적으로 붙이면 add()는 joinPoint가 된다.
		System.out.println(1 + 2);
	}
	
	public void minus() { // @Log가 없으므로 joinPoint가 아니다
		System.out.println(2 - 1);
	}
	
	@Log
	public void divide() {
		int result = 1 / 0;
		System.out.println(result);
	}
}
