package com.liuxiangwin.Algorithm.String.test;

import java.util.Arrays;

public class TestShiftReserveString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] testArray1 = { 5, 7, 0, 9, 3, 2, 0 };
		rightShift(testArray1, 2);
		System.out.println("rightShift " + Arrays.toString(testArray1));

		int[] testArray2 = { 5, 7, 0, 9, 3, 2, 0 };
		rightShiftByWhile(testArray2, 2);
		System.out.println("rightShift by while " + Arrays.toString(testArray2));
		
		String testArray3 = "5709320";
		rightCharShiftByWhile(testArray3.toCharArray(), 2);
		System.out.println("rightCharShiftByWhile " + Arrays.toString(testArray2));
	}
	
	
	private static void rightShift(int[] array, int rotateNum) {
		if (rotateNum < 0) {
			return;
		}
		reserve(array, 0, array.length - 1);
		reserve(array, 0, rotateNum - 1);
		reserve(array, rotateNum, array.length - 1);
		
	}

	private static void rightShiftByWhile(int[] array, int rotateNum) {

		if (rotateNum < 0) {
			return;
		}
		reverseByWhile(array, 0, array.length - 1);
		reverseByWhile(array, 0, rotateNum - 1);
		reverseByWhile(array, rotateNum, array.length - 1);
		
	}

	private static void reserve(int[] array, int startIndex, int endIndex) {
		for (int i = 0; i < (endIndex - startIndex + 1) / 2; i++) {
			// for (int i = 0; i < array.length -1/ 2; i++) {
			int tmp = array[startIndex + i];
			array[startIndex + i] = array[endIndex - i];
			array[endIndex - i] = tmp;
		}
	}

	private static void reverseByWhile(int[] string, int start, int end) {

		while (start < end) {
			int temp = string[start];
			string[start] = string[end];
			string[end] = temp;
			start++;
			end--;
		}

	}
	
	private static void rightCharShiftByWhile(char[] array, int rotateNum) {

		if (rotateNum < 0) {
			return;
		}
		reverseCharByWhile(array, 0, array.length - 1);
		reverseCharByWhile(array, 0, rotateNum - 1);
		reverseCharByWhile(array, rotateNum, array.length - 1);
		
	}
	
	
	private static void reverseCharByWhile(char[] charArray, int start, int end) {

		while (start < end) {
			char temp = charArray[start];
			charArray[start] = charArray[end];
			charArray[end] = temp;
			start++;
			end--;
		}

	}
}
