package com.liuxiangwin.Algorithm.Number.test;

public class TestFactorialAndWithOne {

	/**
	 * ½×³Ë
	 */
	public static void main(String[] args) {
		System.out.println("The 4 factorial is " + factorial(4));
		for (int i = 0; i < 100; i++) {
			//System.out.println("The " + i + " factorial is " + factorial(i));
		}
		System.out.println(" constains 0 number is" + checkFactorialContains0(10));

	}

	private static double factorial(int number) {
		if (number == 0 || number == 1)
			return number;
		else {
			return number * factorial(number - 1);
		}

	}

	private static int checkFactorialContains0(int number) {
		int result = 0;
		for (int index = 1; index <= number; index++) {
			while (index % 5 == 0) {
				System.out.println("The number index % 5 "+ index);
				result++;
				index /= 5;
			}
		}
		return result;
	}

}
