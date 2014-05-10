package com.liuxiangwin.Algorithm.Sort.test;

import java.util.Arrays;

public class TestQucikSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 99, 88, 77, 66, 33, 45, 12, 100, 67 };
		System.out.println("Before Quick Sort" + Arrays.toString(array));
		new TestQucikSort().quickSort(array, 0, array.length - 1);
		System.out.println("After Quick Sort" + Arrays.toString(array));

	}

	int partition(int arr[], int leftIndex, int rightIndex) {
		int i = leftIndex, j = rightIndex;
		int tmp;
		int pivot = arr[(leftIndex + rightIndex) / 2];
		while (i <= j) {
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}		
		return i;

	}

	void quickSort(int arr[], int left, int right) {
		int index = partition(arr, left, right);
		if (left < index - 1)
			quickSort(arr, left, index - 1);
		if (index < right)
			quickSort(arr, index, right);
	}

}
