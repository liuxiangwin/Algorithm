package com.liuxiangwin.algor.leetcode.binarysearch;

public class SearchInsertPosition {
	private static int binarySearch(int[] sortedArray, int target) {
		if (sortedArray.length == 0)
			return 0;
		int start=0; int end= sortedArray.length-1;
		while (start < end) {
			int middle = (start + end) / 2;
			if (target < sortedArray[middle]) {
				end = middle;
			} else if (target > sortedArray[middle]) {
				start = middle + 1;
			} else {
				return middle;
			}
		}		
		return sortedArray[start] < target ? start + 1 : start;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SearchInsertPosition position = new SearchInsertPosition();
		
		int[] array = {1,3,5,6};// 5 ¡ú 2
		System.out.println(position.binarySearch(array,5));
		

		int[] array2 = {1,3,5,6};// 2 ¡ú 1
		System.out.println(position.binarySearch(array2,2));
		
		int[] array3 = {1,3,5,6};// 7 ¡ú 0
		System.out.println(position.binarySearch(array3,7));
		
		int[] array4 = {1,3,5,6};// 0 ¡ú 0
		System.out.println(position.binarySearch(array4,0));
		
	}

}
