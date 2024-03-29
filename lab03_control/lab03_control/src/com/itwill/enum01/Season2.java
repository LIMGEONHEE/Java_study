package com.itwill.enum01;

public class Season2 {
	
	public static final Season2 SPRING = new Season2("봄");
	public static final Season2 SUMMER = new Season2("여름");
	public static final Season2 FALL = new Season2("가을");
	public static final Season2 WINTER = new Season2("겨울");
	
	private String name;
	
	
	// enum의 생성자의 접근 수식어는 private만 사용 가능. private은 생략 가능.
	private Season2(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

}
