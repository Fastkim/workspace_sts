package spring.core.ch02.ex03;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("spring.core.ch02.ex03")
@EnableAspectJAutoProxy //aspect와 관련된 특수빈들이 container에 포함되어 @before를 알아들을수있도록
public class AppConfig {

}
