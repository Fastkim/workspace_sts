package spring.core.ch01.ex02;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.core.ch01.ex01.Gun;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shooter {
	private String shooterName; //DI, 혹은 문자 숫자 날짜는 일반필드라고 한다.
	private Gun gun; //DI
	
	public void fire() {
		System.out.print(shooterName + ": ");
		gun.fire();
	}
}
