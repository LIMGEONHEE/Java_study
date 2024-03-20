package com.itwill.loop13;

public class LoopMain13 {

	public static void main(String[] args) {
		// 연습문제 5
		System.out.println("교제 Ex 5.");

		for (int x = 1; x < 5; x++) {
			for (int y = 1; y <= x; y++) {
				if (x >= y) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

		System.out.println("----------------");

		// 연습문제 6
		System.out.println("교체 Ex 6-1");
		for (int x = 1; x <= 4; x++) {
			for (int y = 1; y <= 4; y++) {
				if (y <= 4 - x) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}

		System.out.println("----------------");

		System.out.println("교체 Ex 6-2");
		for (int x = 1; x < 5; x++) {
			for (int y = 4; y >= 1; y--) {
				if (x < y) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}

		System.out.println("----------------");

		System.out.println("교체 Ex 6-3");
		for (int x = 1; x <= 4; x++) {
			for (int y = 1; y <= 4 - x; y++) {
				System.out.print(" ");
			}
			for (int y = 1; y <= x; y++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
