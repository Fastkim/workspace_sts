package spring.core.ch02.ex02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		Rabbit rabbit = ctx.getBean(Rabbit.class);
		
		System.out.println(rabbit.sleep());
	}
}
