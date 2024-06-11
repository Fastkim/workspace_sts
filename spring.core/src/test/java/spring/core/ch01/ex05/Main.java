package spring.core.ch01.ex05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Shooter shooter = ctx.getBean("shooter", Shooter.class);
		
		try {
			shooter.fire();
		} catch(NullPointerException e) {
			System.out.println("에러입니다.");
		}
	}
}
