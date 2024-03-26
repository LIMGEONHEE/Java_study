package com.itwill.class04;

public class ClassMain04 {

	public static void main(String[] args) {
		// 기본생성자를 사용해서 Rectangle 객체 생성, 메서드 호출
		Rectangle rec1 = new Rectangle();
		System.out.println("rect1 : " + rec1);
		rec1.width = 5.6;
		System.out.println("rect1 가로 = " + rec1.width);
		rec1.height = 2.0;
		System.out.println("rect1 세로 = " + rec1.height);
		rec1.area();
		System.out.println("rect1 넓이 = " + rec1.area());
		rec1.perimeter();
		System.out.println("rect1 둘레 = "+ rec1.perimeter());
		
		System.out.println("=======================");
		
		// 아규먼트를 갖는 생성자를 사용:
		Rectangle rec2 = new Rectangle(2.0, 4.0);
		System.out.println("rect2 : " + rec2);
		System.out.println("rect2 가로 = " + rec2.width);
		System.out.println("rect2 세로 = " + rec1.height);
		System.out.println("rect2 넓이 = " + rec2.area());
		System.out.println("rect2 둘레 = "+ rec2.perimeter());
		
		rec2 = new Rectangle(4,2);
		System.out.println("rect2 : " + rec2);

	}

}
