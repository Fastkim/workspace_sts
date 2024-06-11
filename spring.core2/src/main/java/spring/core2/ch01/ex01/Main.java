package spring.core2.ch01.ex01;

public class Main {
	public static void main(String[] args) {
		Pistol pistol = new Pistol();
		Rifle rifle = new Rifle();
		
		Shooter shooter = new Shooter(pistol); // 관계를 맺어주는 작업(생성자로 DI)
		shooter.fire();
		
		shooter.setGun(rifle);
		shooter.fire();
	}
}

// Ioc에 참여하는 객체들을 Main이 만들어서 가지고 있다 
// -> 즉 Main이 Container역할을 하는것이다.
// spring을 사용한다? -> IoC, DI를 사용하는것이다.
