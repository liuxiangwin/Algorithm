package com.liuxiangwin.Algorithm.Math.test;

import java.util.Scanner;
import java.util.Vector;

public class TestFindUglyNumber {

	/**
	 * To fix the logic The primer number(Factors) is 2,3,5
	 */
	public static void main(String[] args) {
		System.out.println(GetUglyNumber_Solution1(100));
		// System.out.println(IsUgly(12));

	}

	private static int GetUglyNumber_Solution1(int checkRange) {

		if (checkRange <= 0)
			return 0;

		int checkNumber = 0;
		int uglyNumber = 0;
		while (checkNumber < checkRange) {
			++checkNumber;
			if (IsUgly(checkNumber)) {
				System.out.println("The Ugly number is " + checkNumber);
				++uglyNumber;
			}
		}

		return uglyNumber;
	}

	private static boolean IsUgly(int number) {

		while (number % 2 == 0) {
			number /= 2;
		}
		while (number % 3 == 0) {
			number /= 3;
		}
		while (number % 5 == 0) {
			number /= 5;
		}
		return (number == 1) ? true : false;

	}

}
