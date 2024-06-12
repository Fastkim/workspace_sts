package spring.core2.ch01.ex03;

import org.springframework.context.annotation.Bean;

import spring.core2.ch01.ex01.Pistol;
import spring.core2.ch01.ex01.Rifle;
import spring.core2.ch01.ex02.Shooter;

public class AppConfig {
	@Bean
	public Pistol pistol() { // Bean의 타입, Bean의 id
		return new Pistol(); // Container가 call해야 DI된다.
	}
	
	@Bean
	public Rifle rifle() {
		return new Rifle(); //Ioc
	}
	
	@Bean
	public Shooter shooter1() {
		return new Shooter("최한석", pistol()); // DI
	}
	
	@Bean
	public Shooter shooter2() {
		Shooter shooter = new Shooter();
		shooter.setShooterName("한아름");
		shooter.setGun(rifle());
		
		return shooter;
	}
	// Bean : Spring IOC Container가 관리하는 자바 객체를 말한다.
}
