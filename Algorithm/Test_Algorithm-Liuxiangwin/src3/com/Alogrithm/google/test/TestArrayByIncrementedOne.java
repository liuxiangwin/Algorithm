package com.Alogrithm.google.test;

public class TestArrayByIncrementedOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = { 2, 7, 1, 1 };

		int arrLength = arr.length;

		incrementArr(arr, arrLength);

		print(arr, arrLength);
	}

    //如果数组最后一位是9的话则加1，然后index--, 如果不是的话，则array[index]这个数加1
	private static void incrementArr(int arr[], int length) {
		if (arr[length - 1] == 9) {//last position
			arr[length - 1] = 0;
			length--;
			incrementArr(arr, length);
		} else {
			arr[length - 1]++;//if not  euqals 9 then plus 1;
		}
	}
	
	private static void print(int[] arr, int arrLength) {
		for (int i = 0; i < arrLength; i++) {
			System.out.println(arr[i]);
		}
	}


}
