package spring.core.ch01.ex02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		// Main.class -> class 타입의 객체가 생성, 해당클래스에는 메타데이터가 들어있다.
		ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml", Main.class); // container 객체 생성, container이름은 applicationContext()
		
		Shooter shooter1 = ctx.getBean("shooter1", Shooter.class); // container내에서는 객체로 있으므로 꺼낼때는 클래스타입으로 꺼낸다.
		Shooter shooter2 = ctx.getBean("shooter2", Shooter.class);
		
		shooter1.fire();
		shooter2.fire();
	}
}
