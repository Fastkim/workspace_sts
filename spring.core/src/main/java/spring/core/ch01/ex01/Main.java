package spring.core.ch01.ex01;

public class Main {
	public static void main(String[] args) {
		Pistol pistol = new Pistol();
		Rifle rifle = new Rifle();
		
		Shooter shooter = new Shooter(pistol); // 생성자를 이용하여 IOC에 DI를 한다.
		shooter.fire();
		
		shooter.setGun(rifle); // setter를 이용하여 DI를 한다.
		shooter.fire();
	}
}
// Main이 Container 역할을 한다.
