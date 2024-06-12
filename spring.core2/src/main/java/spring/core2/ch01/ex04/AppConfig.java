package spring.core2.ch01.ex04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spring.core2.ch01.ex01.Gun;
import spring.core2.ch01.ex02.Shooter;

@Configuration
@Import({Config.class, Config.class})
public class AppConfig {
	@Autowired private Gun pistol; // 자동으로 연결한다: Autowired
	@Autowired private Gun rifle; // container중에 Gun타입인 객체를 찾아서 조회한다. 문제) Gun타입의 bean이 2개이상이다.
	// 1차는 타입으로 검색, 2차는 bean의 ID와 필드네임을 비교 검색
	
	@Bean
	public Shooter shooter1() {
		return new Shooter("최한석", pistol);
	}
	
	@Bean
	public Shooter shooter2() {
		Shooter shooter = new Shooter();
		shooter.setShooterName("한아름");
		shooter.setGun(rifle);
		
		return shooter;
	}
}
