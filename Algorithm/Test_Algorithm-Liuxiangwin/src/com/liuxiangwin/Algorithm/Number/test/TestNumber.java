package com.liuxiangwin.Algorithm.Number.test;

import java.util.HashMap;
import java.util.Iterator;

public class TestNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		HashMap<Integer, Integer> map = findTwoNumberArray(array);
		Iterator iter = map.values().iterator();
		while (iter.hasNext()) {
			//System.out.println(iter.next());
		}
		decimalToBinary(10);

	}

	private static void decimal(int decimalNumber) {
		String binaryNumber;
		if (decimalNumber <= 0)

			System.out.println("ERROR: entered integer is nonpositive.");

		else {

			binaryNumber = "";

			// algorithm step by step

			// initial: binaryNumber = "", decimalNumber = 123

			// step 1 : binaryNumber = "1 ", decimalNumber = 61

			// step 2 : binaryNumber = "11 ", decimalNumber = 30

			// step 3 : binaryNumber = "011 ", decimalNumber = 15

			// step 4 : binaryNumber = "1011 ", decimalNumber = 7

			// step 5 : binaryNumber = "1 1011 ", decimalNumber = 3

			// step 6 : binaryNumber = "11 1011 ", decimalNumber = 1

			// step 6 : binaryNumber = "111 1011 ", decimalNumber = 0

			// stop : (decimalNumber != 0)

			while (decimalNumber != 0) {

				// add spaces to separate 4-digit groups

				if (binaryNumber.length() % 5 == 0)

					binaryNumber = " " + binaryNumber;

				// extract last digit in binary representation

				// and add it to binaryNumber

				binaryNumber = (decimalNumber % 2) + binaryNumber;

				// cut last digit in binary representation

				decimalNumber /= 2;

			}

			System.out.println("Binary: " + binaryNumber);

		}

	}

	private static void decimalToBinary(int number) {
		int base = 2;
		int result = 0;
		int multiplier = 1;

		while (number > 0) {
			int residue = number % 2;
			number = number / 2;
			result = result + residue * multiplier;
			multiplier = multiplier * 10;
		}
		System.out.println("binary....." + result);
	}

	private static HashMap<Integer, Integer> findTwoNumberArray(int[] array) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i] == array[j] && map.containsKey(i)) {
					int count = map.get(i);
					map.put(i, count + 1);
				} else {
					map.put(i, 1);
				}

			}
		}
		return map;
	}

}
