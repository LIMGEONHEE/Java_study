package com.itwill.method05;

import java.lang.reflect.Array;

public class MethodMain05 {

	public static void main(String[] args) {
		// TODO 메서드 호출, 그 결과를 출력:
		// sum 메서드 호출, 그 결과를 출력.
		int[] array = {1 ,2 ,3 ,4 ,5};
		
		// sum 메서드 호출, 결과 출력.
		int total  = sum(array);
		System.out.println("sum = " + total);
		
		// mean 메서드 호출, 결과 출력.
		double average = mean(array);
		System.out.println("average = " + average);
		
		// max 매서드 호출, 결과 출력.
		System.out.println("max = " + max(array));
		
		// min 메서드 호출, 결과 출력.
		System.out.println("min = " + min(array));
		
		
	}
	
	/**
	 * sum.
	 * 아규먼트로 전달받은 정수들의 1차원 배열의 모든 원소들의 합을 리턴.
	 * @param array 정수들의 1차원 배열(int[]).
	 * @return array의 모든 원소들의 합.
	 */
	public static int sum(int[] array) {
		int sum = 0;
		for (int x : array) {
			sum += x;
		}
		return sum;
	}

	/**
	 * mean.
	 *  아규먼트로 전달받은 정수들의 1차원 배열 원소들의 평균을 리턴.(소수점까지)
	 *  @param array 정수들의 1차원 배열.
	 *  @return array 원소들의 평균을 double 타입으로 리턴.
	 */
	public static double mean(int[] array) {
			double result = (double) sum(array) / array.length;
        return result;
	}
	
	/**
	 * max.
	 * 아규먼트로 전달받은 정수들의 1차원 배열 원소들 중 최댓값을 리턴.
	 * @param array 정수들의 1차원 배열.
	 * @return array 원소들 중 최댓값.
	 */
	public static int max(int[] array) {
		int result = array[0];
		for (int x : array) {
			if (x > result) {
				result = x;
			}
		}
		return result;
	}
	
	/**
	 * min.
	 * 아규먼트로 전달받은 정수들의 1차원 배열 원소들 중 최솟값을 리턴
	 * @param array 정수들의 1차원 배열.
	 * @return array 원소들 중 최솟값.
	 */
	public static int min(int[] array) {
		int result = array[0];
		for (int x : array) {
			
			if (x < result) {
				result = x;
			}
		}
		return result;
	}
	
}
