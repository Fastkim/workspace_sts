package spring.core2.ch01.ex02;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.core2.ch01.ex01.Gun;

@Setter
@AllArgsConstructor // 모든 필드를 가지는 생성자
@NoArgsConstructor // arguments = parameter 동의어
public class Shooter {
	private String shooterName;
	private Gun gun; // 문자,숫자,날짜를 포함해서 DI라고 하기도 하고, 제외하고 DI라고 하기도 한다.
}

// 즉 Shooter.java 파일이 compile 되어서 Shooter.class가 되면 그안에는 생성자와 Setter, Getter가 모두 들어있는것이다.
// 객체는 Shooter.class에서 만들어진다.
