package spring.core2.ch01.ex01;

public class Rifle implements Gun {
	@Override
	public void fire() {
		System.out.println("소총 탕탕.");
	}
}
