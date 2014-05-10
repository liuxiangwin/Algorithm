package com.liuxiangwin.Algorithm.ArrayQuestion.test;

import java.util.HashMap;
import java.util.Iterator;

public class TestFindCommonElementThreeArray {

	/**
	 * Find the common element in the three sorted Array
	 */
	public static void main(String[] args) {
		int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };

		int[] array2 = { 1, 3, 5, 7, 9 };

		int[] array3 = { 1, 3, 6, 9 };

		GetCommonNumbers(array1, array2, array3);

	}

	static void GetCommonNumbers(int[] sortedArr1, int[] sortedArr2,
			int[] sortedArr3)

	{

		int i = 0;

		int j = 0;

		int k = 0;

		while (i < sortedArr1.length && j < sortedArr2.length
				&& k < sortedArr3.length) {
			if (sortedArr1[i] < sortedArr2[j])
				i++;
			else if (sortedArr2[j] < sortedArr1[i])
				j++;
			else {
				if (sortedArr3[k] < sortedArr1[i])
					k++;
				else if (sortedArr3[k] > sortedArr1[i]) {
					i++;
					j++;
				} else {
					System.out.println(sortedArr1[i]);
					i++;
					j++;
					k++;
				}
			}
		}
	}

}
