package spring.core.ch02.ex03;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Timer {
	// 접근제한자는 모두 가능 spring 프로젝트에서 파라미터는 int타입 하나만가능 
	@Before("execution(* spring..*(int))") 
	public void clockStart(JoinPoint jp) {
		// 부모타입 Joinpoint, 자식타입 ProceedingJoinPoint
		System.out.println(jp.toShortString());
		System.out.println("시작 시각: " + LocalDateTime.now());
	}
	
	@After("within(spring..Calculator)") // 관점이 메서드가 아닌 빈이다.
	public void clockEnd(JoinPoint jp) { //jp안에는 joinPoint의 정보가 들어있는것이다.
		System.out.println(jp.toLongString());
		System.out.println("종료 시각: " + LocalDateTime.now());
	}
	
	@AfterReturning(pointcut="bean(calc*)", returning="result")  //joinPoint 성공 후
	public void printResult(JoinPoint jp, int result) { // returning="파라미터 변수"
		System.out.println(jp.toShortString() + ": " + result);
	}
}
