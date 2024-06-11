package spring.core.ch01.ex08;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton") // 1개의 객체만을 생성해서 주구장창사용함.
public class Leopard {
	
}
