package com.liuxiangwin.Algorithm.Number.test;

public class TestFindDecimalNumberContainsOneByString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// System.out.println(9/10);

		System.out.println(9 % 10);

		System.out.println(findNumberContainsOne__ByString(12));

	}

	private static int findNumberContainsOne__ByString(int range) {
		int count = 0;
		for (int i = 0; i <= range; i++) {
			String number = String.valueOf(i);
			for (int j = 0; j < number.length(); j++) {
				if (Integer.valueOf(number.charAt(j)+"") == 1) {
					System.out.println("The contains 1 number is" + number);
					count++;
					//break;
				}

			}

		}
       return count;
	}
   /**
    * To to best solution
    * @param number
    */
	private void checkOne(int number) {
		int count = 0;

		if (number % 10 > 0) {
			count++;
			number = number % 10;

		}

	}
}
