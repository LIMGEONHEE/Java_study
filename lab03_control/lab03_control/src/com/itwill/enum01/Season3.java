package com.itwill.enum01;

public enum Season3 {
	SPRING("봄"),
	SUMMER("여름"),
	FALL("가을"),
	WINTER("겨울");

	private String name;
	
	private Season3(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
}