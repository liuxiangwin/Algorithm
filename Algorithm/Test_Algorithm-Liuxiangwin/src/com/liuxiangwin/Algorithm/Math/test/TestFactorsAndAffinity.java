package com.liuxiangwin.Algorithm.Math.test;

public class TestFactorsAndAffinity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		checkFactors(20);
		checkAffinity(500);

	}

	private static int checkFactors(int inputNumber) {
		int sumResult = 0;
		for (int i = 1; i < inputNumber; i++) {
			if (inputNumber % i == 0) {
				// result += i;
				System.out.println(i);
				sumResult += i;
			}

			if (!(inputNumber % i == 0)) {
				// result += i;
				// System.out.println("This number is not factors "+i);
			}
		}
		return sumResult;
	}

	private static int checkAffinity(int range) {
		int sum = 0;
		int a = 0;
		int b = 0;
		for (int i = 220; i < range; i++) {
			a = i;
			b = checkFactors(a);
			// Number b is in the array,
			//b is greater than a,and sum of b factors equals a
			if (b < range && b > a && a == checkFactors(b)) {
				// sum += a;
				// sum += b;
				System.out.println("The Affinity number is " + a + " " + b);

			}
		}
		return sum;
	}

}
