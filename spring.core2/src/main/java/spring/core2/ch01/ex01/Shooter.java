package spring.core2.ch01.ex01;

public class Shooter {
	private Gun gun; // Ioc(Inverse Of Control): 총잡이가 총을 만들지 않는다, 총은 다른곳에서 만들어진다.
	
	public Shooter(Gun gun) { //DI를 생성자를 이용해서 한다.
		this.gun = gun;
	}
	
	public void setGun(Gun gun) { //DI를 Setter를 이용해서 한다.
		this.gun = gun;
	}
	
	public void fire() {
		gun.fire();
	}
}
