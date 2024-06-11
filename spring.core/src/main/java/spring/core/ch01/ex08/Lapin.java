package spring.core.ch01.ex08;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // 객체를 그때마다 만들어서 씀 n개의 객체
public class Lapin {
	
}
