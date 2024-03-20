package com.itwill.loop12;

import java.util.Random;

public class LoopMain12 {

	public static void main(String[] args) {
		// 주사위 2개를 던졌을 때 결과를 (x,y) 형식으로 출력.
		// 주사위 2개의 눈의 합이 5가 되면 실행을 멈춤.
		// (1, 2), (6, 2), ..., (2, 3)

		// 방법 1)
		Random rand = new Random();
		// for ( ; ; ) {...}
		while (true) { // 무한 루프
			int x = rand.nextInt(1, 7); // 1 <= x < 7 범위의 난수
			int y = rand.nextInt(1, 7);
			System.out.printf("(%d, %d)\n", x, y);
			if (x + y == 5) {
				break;
			}
		}
		System.out.println("----------");

		// 방법 2)
		int x;
		int y;
		do {
			x = rand.nextInt(1, 7);
			y = rand.nextInt(1, 7);
			System.out.printf("(%d, %d)\n", x, y);
		} while ((x + y) != 5);
		System.out.println("----------");

		// 4x + 5y = 60 방정식을 만족하는 x와 y를 찾기.
		// 단, x와 y는 10 이하의 자연수
		for (x = 1; x <= 10; x++) {
			for (y = 1; y <= 10; y++) {
				if ((4 * x) + (5 * y) == 60) {
					System.out.printf("(%d, %d)\n", x, y);
				}
			}
		}

	}
}