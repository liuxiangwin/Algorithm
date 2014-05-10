package com.liuxiangwin.Algorithm.Sort.test;

import java.util.Arrays;

public class TestSortMinusPositive {

	/**
	 * 1.Sort the array,put the minus number in the left and the positive number
	 * in the left
	 * 
	 * 
	 * 2.With the help of the total minus number,and this number's index
	 * is the sorted minus number position and the positive number start
	 * at this result++
	 */

	int negativeNumber = 0;

	public static void main(String[] args) {
		int[] array = { 1, 7, -5, 9, -12, 15 };
		System.out.println("Before Minus and Positive Sort"
				+ Arrays.toString(array));
		// new TestSortMinusPositive().partition(array, 0, array.length - 1);
		new TestSortMinusPositive().sortByMinusAndPositive(array);
		System.out.println("After Minus and Positive Sort"
				+ Arrays.toString(array));
		int[] result = { -5, -12, 1, 7, 9, 15 };
	}

	void sortByMinusAndPositive(int[] array) {
		int[] copyArray = new int[array.length];
		System.arraycopy(array, 0, copyArray, 0, array.length);
		for (int i = 0; i < array.length; i++) {
			if (array[i] < 0)
				negativeNumber++;
		}
		int negBegin = 0;
		// Get the negative number,
		//and the positive number should put from
		// this number'Index++
		int posiBegin = negativeNumber;

		for (int i = 0; i < copyArray.length; i++) {
			if (copyArray[i] < 0)
				//Put the positive number from the result index start
				array[negBegin++] = copyArray[i];
			else
				array[posiBegin++] = copyArray[i];
		}
	}
}
