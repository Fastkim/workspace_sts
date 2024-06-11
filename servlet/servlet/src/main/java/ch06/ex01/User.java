package ch06.ex01;

import java.time.LocalDate;

public record User(int userId, String userName, LocalDate birthDay) {
	public String getUsername() {
		return this.userName;
	}
}
