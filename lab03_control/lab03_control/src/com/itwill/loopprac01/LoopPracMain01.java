package com.itwill.loopprac01;

public class LoopPracMain01 {

	public static void main(String[] args) {
		// 4-2 (2)
		
		// (4)
		for ( int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				if ((4 * x) + (5 * y) == 60) {
					System.out.println("(" + x + "," + y + ")");
				}
			}
		}
		System.out.println("---------------");
		
		// (5)
		for (int x = 1 ; x < 5; x++) {
			for (int y = 1; y <5; y++) {
				if (x >= y) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			} System.out.println();
		} 
		
		System.out.println("---------------");
		// (6)
		for (int x =1 ; x < 5; x++) {
			for (int y = 4; y > 0; y--) {
				if (x >= y) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			} System.out.println();
		}
		
	}

}
