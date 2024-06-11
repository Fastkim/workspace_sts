package spring.core.ch02.ex03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		Calculator calculator = ctx.getBean(Calculator.class); //id를 쓰지않아도 container에 Calculator가 하나뿐이므로 찾아갈수있다.
		calculator.calc(1);
	}
}
