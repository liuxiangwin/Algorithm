package com.liuxiangwin.Algorithm.Sort.test;
import java.util.Arrays;


public class TestSortOddAndEven {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 99, 88, 77, 66, 33, 45, 12, 100, 67 };		
		new TestSortOddAndEven().partition(array, 0, array.length - 1);
		System.out.println("After Quick Sort" + Arrays.toString(array));
		
	}

	void sortByOddEven(int arr[], int left, int right) {
		try {
			int index = partition(arr, left, right);
			if (left < index - 1) {
				sortByOddEven(arr, left, index - 1);
			}
			if (index < right) {
				sortByOddEven(arr, index, right);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	
     //Only called once
	 int partition(int arr[], int leftIndex, int rightIndex) {
		int i = leftIndex, j = rightIndex;
		int tmp;
		while (i <=j) {
			while (isOdd(arr[i])) {
				i++;
			}
			while (isEven(arr[j])) {
				j--;
			}
			//if (i < j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			//}
		};	
		return i;
	}

	private  boolean isOdd(int i) {
		return i % 2 != 0;
	}

	private  boolean isEven(int i) {
		return i % 2 == 0;
	}
}
