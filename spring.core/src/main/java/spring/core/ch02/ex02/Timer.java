package spring.core.ch02.ex02;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Timer {
	@Pointcut("execution(public * spring.core.ch02.ex02..*(..))")
	private void myPointcut() {} // 메서드이름이 pointCut의 ID가 된다.
	// 메서드 = execution으로 표현, ..은 ex02내의 모든 클래스를 의미, *(.. 모든 파라미터)
	// pointCut은 spring container가 관리한다.
	// pointCut : joinPoint가 될수있는지 판단하는 기준
	@Around("myPointcut()") // advice를 나타내기위해 @Around를 사용
	public Object clock(ProceedingJoinPoint jp) throws Throwable {
		// joinPoint : 결합지점(asepct관점에서 결합할 메서드를 joinpoint, 결합하지 않을 메서드는 point), advice : asepect이 가지고 있는 joinPoin를 포함한 메서드를 말한다.
		// advice는 aspect이 joinPoint에 붙으면 call된다.
		System.out.println(jp.getSignature());
		
		long start = System.currentTimeMillis();
		Result result = (Result)jp.proceed();
		long end = System.currentTimeMillis();
		
		System.out.println("경과시간: " + (end - start));
		
		result.setResult(result.getResult() + "(clock)");
		return result;
	}
	// 클라이언트는 clock메서드가 결합해서 return result값을 받은줄 몰름.
}
