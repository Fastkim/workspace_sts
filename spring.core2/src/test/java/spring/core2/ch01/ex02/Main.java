package spring.core2.ch01.ex02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		// Main.class -> class 타입의 객체가 생성, 해당클래스에는 메타데이터가 들어있다.
		ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml", Main.class);
		
		
	}
}
