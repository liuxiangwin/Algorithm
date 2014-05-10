package com.liuxiangwin.util;

import java.util.Arrays;
import java.util.Collections;

public class CharSortedUtil {
	private static int partitionAscending(char arr[], int leftIndex,
			int rightIndex) {
		int i = leftIndex, j = rightIndex;
		char tmp;
		char pivot = arr[(leftIndex + rightIndex) / 2];
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
		;
		return i;

	}

	private static int partitionDescend(char arr[], int leftIndex, int rightIndex) {
		int i = leftIndex, j = rightIndex;
		char tmp;
		char pivot = arr[(leftIndex + rightIndex) / 2];
		while (i <= j) {
			while (arr[i] > pivot)
				i++;
			while (arr[j] < pivot)
				j--;
			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		;
		return i;

	}

	public static void quickSortByAscending(char arr[], int left, int right) {
		int index = partitionAscending(arr, left, right);
		if (left < index - 1)
			quickSortByAscending(arr, left, index - 1);
		if (index < right)
			quickSortByAscending(arr, index, right);
	}

	public static void quickSortByDescending(char arr[], int left, int right) {
		int index = partitionDescend(arr, left, right);
		if (left < index - 1)
			quickSortByDescending(arr, left, index - 1);
		if (index < right)
			quickSortByDescending(arr, index, right);
	}

	public static void jdkSort(Integer[] integerArray) {
		Arrays.sort(integerArray, Collections.reverseOrder());

	}
}
