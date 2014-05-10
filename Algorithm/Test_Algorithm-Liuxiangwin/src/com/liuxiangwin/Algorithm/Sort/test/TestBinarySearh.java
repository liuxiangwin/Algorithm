package com.liuxiangwin.Algorithm.Sort.test;

public class TestBinarySearh {

	/**
	 * Theb binary search must need sorted array 
	 */
	public static void main(String[] args) {
		int[] sortedArray = { 3, 6, 9, 10, 12, 16, 17 };
		System.out.println("The number in array is "+
				binarySearch(sortedArray, 12, 0, sortedArray.length - 1));
	}

	private static int binarySearch(int[] sortedArray, int inputNumber, int start,
			int end) {		
		while (start <= end) {
			int middle = (start + end) / 2;
			if (inputNumber < sortedArray[middle]) {
				end = middle;
			} else if (inputNumber > sortedArray[middle]) {
				start = middle + 1;
			} else {
				return middle;
			}

		}	
		return -1;
	}

}
