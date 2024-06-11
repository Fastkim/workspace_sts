package ch03.ex05;

public record User(String username, int age) {
	@Override
	public String toString() {
		return username + ", " + age;
	}
}
