package spring.core.ch01.ex03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.core.ch01.ex01.Pistol;
import spring.core.ch01.ex01.Rifle;
import spring.core.ch01.ex02.Shooter;

@Configuration // 이 클래스를 Ioc하도록 하는 Annotation
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
		return new Shooter("최한석", pistol()); //DI
	}
	
	@Bean
	public Shooter shooter2() {
		Shooter shooter = new Shooter();
		shooter.setShooterName("한아름");
		shooter.setGun(rifle());
		
		return shooter;
	}
}
