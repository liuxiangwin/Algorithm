package com.liuxiangwin.Algorithm.Sort.test;

import java.util.Arrays;

public class TestBubleSortAndComparisonSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 57, 68, 59, 52 };
		System.out.println("Before Comparison Sort " + Arrays.toString(array));
		ComparisonSort(array);
		System.out.println("After Comparison Sort" + Arrays.toString(array));
		
		int[] array2 = { 57, 68, 59, 52 };
		System.out.println("Before Bubble Sort " + Arrays.toString(array2));
		ComparisonSort(array2);
		System.out.println("After Bubble Sort" + Arrays.toString(array2));

	}

	public static int[] BubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length - 1 - i; j++) {
				if (array[i] > array[j]) {
					Swap(array, i, j);
				}
			}
		}
		return array;
	}

	public static int[] ComparisonSort(int[] array) {
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				if (array[i] > array[j]) {
					// Give the smaller to index to Exchange
					index = j;
				}
			}
			Swap(array, i, index);
		}
		return array;
	}

	private static void Swap(int[] numbers, int i, int j) {
		int number = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = number;
	}

	/**
	 * /* 初始关键字 [49 38 65 97 76 13 27 49]
	 * 
	 * 　　第一趟排序后 13 ［38 65 97 76 49 27 49]
	 * 
	 * 　　第二趟排序后 13 27 ［65 97 76 49 38 49]
	 * 
	 * 　　第三趟排序后 13 27 38 [97 76 49 65 49]
	 * 
	 * 　　第四趟排序后 13 27 38 49 [76 97 65 49 ]
	 * 
	 * 　　第五趟排序后 13 27 38 49 49 [97 65 76]
	 * 
	 * 　　第六趟排序后 13 27 38 49 49 65 [97 76]
	 * 
	 * 　　第七趟排序后 13 27 38 49 49 65 76 [97]
	 * 
	 * 　　最后排序结果 13 27 38 49 49 65 76 97
	 */

}
