package spring.core.ch02.ex02;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("spring.core.ch02.ex02")
@EnableAspectJAutoProxy //Spring container가 Aspect을 인식할수 있도록 함. -> container가 aspect의 기능을 bean을 ioc해서 담아둔다.
public class AppConfig {
	
}
