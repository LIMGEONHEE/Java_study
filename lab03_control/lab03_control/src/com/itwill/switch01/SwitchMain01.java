package com.itwill.switch01;

public class SwitchMain01 {

	public static void main(String[] args) {
		// switch-case 구문: 
		// 해당 case 위치로 이동해서 break; 문장을 만날 때까지 실행.
		// 해당하는 case가 없으면 default 블록을 실행.
		// default 블록은 switch 구문에서 항상 가장 마지막에 작성.
		// default 블록은 없어도 됨. case는 하나 이상은 있어야 한다.
		// switch (변수 또는 식)에서 사용할 수 있는 타입:
		// (1) 정수: byte, short, int, long, char('a', 'A')
		// (2) 문자열: String("a", "A")
		// (3) enum 타입
		// (주의) switch-case 구문에서는 실수(float, double), boolean 타입은 사용 불가!!
		
		String season = "봄";
		switch (season) {
		case "봄": // ":" 은 소스코드에 표시하는 포스트잇 같은 것, 실행 문장이 아니다.
			System.out.println("Spring");
			break;
		case "여름": 
			System.out.println("Summer");
			break;
		case "가을": 
			System.out.println("Fall");
			break;
		case "겨울": 
			System.out.println("Winter");
			break;
		default: // 해당하는 케이스가 없는 경우, break;가 필요 없다.
			System.out.println("몰라요~");
		}
		
		int number = 123;
		switch (number % 2) {
		case 0:
			System.out.println("짝수");
			break;
		case 1:
			System.out.println("홀수");
			break;
		}

	}

}