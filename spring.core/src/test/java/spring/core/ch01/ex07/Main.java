package spring.core.ch01.ex07;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class); //container 선언
		
		Lion lion = ctx.getBean(Lion.class);
		lion.shout();
		
		ctx.close();
	}
	
	//bean의 life cycle을 컨테이너가 한다.
}
