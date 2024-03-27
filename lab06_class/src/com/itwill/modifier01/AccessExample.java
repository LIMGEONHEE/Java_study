package com.itwill.modifier01;

public class AccessExample {
	// field
	private int a; // 개인적인. 다른 클래스에선 보이지 않음.
	int b;
	protected int c;
	public int d; // 현재 프로젝트 범위 안.
	
	public AccessExample(int a, int b, int c, int d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	// method
	public void info() {
		System.out.printf("a=%d, b=%d, c=%d, d=%d\n", a, b, c, d);
	}
	
}
