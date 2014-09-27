package com.liuxiangwin.Algorithm.Number.test;

public class TestFindDecimalNumberContainsOneInArray {
	private static int resultOneCount = 0;

	public static void main(String[] args) {
		// int[] array = { 1,2,3,4,5,6,7,8,9,10, 11, 12 };
		System.out.println("1%10 "+1%10);
		int[] array = { 10, 11, 12 };
		findNumberWithOneInArray(array);
		System.out.println(resultOneCount);
	}

	private static void findNumberWithOneInArray(int[] array) {

		for (int i = 0; i < array.length; i++) {
			while (array[i] > 0) {
				array[i] = checkContains1(array[i]);
			}

		}

	}

	private static int checkContains1(int i) {		
		if (i % 10 == 1) {//Remainder equals 1
			resultOneCount++;
			System.out.println(i);
		}
		i = i / 10; //Keep dividend divide by 10
		return i;
	}

}
