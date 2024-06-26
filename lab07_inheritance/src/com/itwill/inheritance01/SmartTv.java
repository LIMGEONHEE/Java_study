package com.itwill.inheritance01;

// 스마트TV은 기본TV를 확장(상속)한다.
// 상위(super), 부모(parent), 기본(base) 클래스 - BasicTv
// 하위(sub), 자식(child), 유도(derived) 클래스 - SmartTv
// 모든 클래스의 최상위 클래스는 java.lang.Object 클래스.
// 상위클래스가 java.lang.Object인 경우 extends Object는 생략 가능.
public class SmartTv extends BasicTv{
	
	private String ip;
	
	public void webBrowsung() {
		System.out.println("인터넷 연결");
	}

	public void checkChannel() {
		System.out.println(getChannel());
	} // 상위 클래스 private 객체는 하위 클래스라도 접근하지 못한다. 다만 getter를 사용하면 가능.
	
}
