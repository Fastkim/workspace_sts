package spring.core.ch02.ex04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLogger {
	@After("@annotation(spring.core.ch02.ex04.Log)") // 이 annotation위치를 joinPoint로 삼겠다는 의미
	public void log(JoinPoint jp) {
		System.out.println(jp.toShortString());
	}
	
	// AfterThrowing: JoinPoint가 실패한 후에 실행될 메서드
	@AfterThrowing(pointcut="@annotation(spring.core.ch02.ex04.Log)", throwing="e")
	public void logErr(JoinPoint jp, Throwable e) {
		System.out.println(jp.toShortString() + ": " + e.getMessage());
	}
}
