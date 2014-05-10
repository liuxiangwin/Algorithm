package com.liuxiangwin.Algorithm.Array.test;

import java.util.Arrays;

public class TestFindjGreaterIWithMaxjMinusI {
	/**
	 * Given an array A[], find (i, j) 
	 * such that A[i] < A[j] and (j - i) is
	 * maximum.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//int arr[] = { 9, 2, 3, 4, 5, 6, 7, 8, 18, 0 };
		
		int arr[] = {14 ,25,11,8,13,6};
		
		
		int tmp[] = new int[arr.length];
		System.out.println(maxIndexDiff(arr, arr.length));

		System.out.println(Arrays.toString(maxIndexDiff2(arr, arr.length)));
	}

	private static int[] maxIndexDiff2(int array[], int arrayLength) {

		int i = 0, j = 0;
		int[] LMin = new int[arrayLength];
		int[] RMax = new int[arrayLength];
		LMin[0] = array[0];

		for (i = 1; i < arrayLength; i++) {
			LMin[i] = min(array[i], LMin[i - 1]);
		}

		System.out.println("The array is " + Arrays.toString(array));
		System.out.println("The LMin is " + Arrays.toString(LMin));

		RMax[arrayLength - 1] = array[arrayLength - 1];

		for (j = arrayLength - 2; j >= 0; j--) {
			RMax[j] = max(array[j], RMax[j + 1]);
		}

		System.out.println("The RMax is " + Arrays.toString(RMax));

		return getResult(arrayLength, LMin, RMax);
	}

	private static int[] getResult(int n, int[] LMin, int[] RMax) {
		int i = 0;
		int j = 0;
		int maxDiff = -1;
		int []result = new int[5];
		while (j < n && i < n) {
			if (LMin[i] < RMax[j]) {
				maxDiff = max(maxDiff, j - i);
				
				result[0] = LMin[i];
				result[1] = RMax[j];
				result[2] = j;
				result[3] = i;
			    result[4] = j-i;
				j++;
			} else {
				i++;
			}
		}
		//return maxDiff;
		return result;
	}

	private static int max(int x, int y) {
		return x > y ? x : y;
	}

	private static int min(int x, int y) {
		return x < y ? x : y;
	}
    //N*N Complexity  
	private static int maxIndexDiff(int arr[], int length) {
		int maxDiff = -1;
		int i = 0, j = 0;
		for (i = 0; i < length; i++) {
			for (j = length - 1; j > i; j--) {
				if (arr[j] > arr[i] && (j - i) > maxDiff) {
					maxDiff = j - i;
					System.out.println("arr[i] is " + arr[i]);
					System.out.println("arr[j] is " + arr[j]);

				}

			}
		}
		System.out.println("i is " + i);
		System.out.println("j is " + j);
		System.out.println("---------------------------");
		return maxDiff;
	}

}