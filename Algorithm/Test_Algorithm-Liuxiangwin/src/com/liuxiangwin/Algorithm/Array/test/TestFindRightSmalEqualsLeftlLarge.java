package com.liuxiangwin.Algorithm.Array.test;

import java.util.Arrays;

public class TestFindRightSmalEqualsLeftlLarge {

	/**
	 * Find the number is greater than left and is less than right *
	 * 
	 * With the help of supplementary array to record at the each of the index
	 * position,the Min number after
	 * 
	 * int rightMinTmp[] = { 2, 2, 2, 6, 19, 22, 32 }; 
	 * int arrayTmp[] = { 7, 10, 2, 6, 19, 22, 32 };
	 * 
	 * the sample result should be 32
	 */
	public static void main(String[] args) throws Exception {
		int array[] = { 7, 10, 2, 6, 19, 22, 32 };
		smallLarge(array);
		System.out.println(Arrays.toString(array));
	}

	public static void smallLarge(int[] array) throws Exception {
		if (array == null || array.length < 1) {
			throw new Exception(
					"the array is null or the array has no element!");
		}

		int[] rightMin = new int[array.length];

		rightMin[array.length - 1] = array[array.length - 1];
		printNumber(array, rightMin);
		// get the minimum value of the array[] from i to array.length - 1

		// Allocate the rightMin array
		for (int index = array.length - 2; index >= 0; index--) {
			//System.out.println("The index is :: " + index);
			rightMin[index]=min(rightMin[index+1],array[index]);			
		}
		System.out.println("The Array rightMin is "+Arrays.toString(rightMin));
		
		int[] LeftMax = new int[array.length];
		LeftMax[0] = array[0];
		
		for (int i = 1; i < array.length; i++) {
			LeftMax[i] = max(array[i], LeftMax[i - 1]);
		}
		
		System.out.println("The Array leftMax is "+Arrays.toString(LeftMax));

		System.out.println("The Org array is  " + Arrays.toString(array));
		
		findResult(array, rightMin);
		
		
		findResult_two(LeftMax,rightMin);
	}

	private static void findResult(int[] array, int[] rightMin) {
		int leftMax = Integer.MIN_VALUE;

		for (int i = 0; i < array.length; i++) {
			if (array[i] >= leftMax) {
				leftMax = array[i];
				if (leftMax == rightMin[i]) {
					System.out.println("the result is "+leftMax);
				}
			}
		}
	}
   
	
	private static void findResult_two(int[]leftMax, int[] rightMin) {
		int i=0;
		int j=0;
		while(i<leftMax.length)
		{
			if(leftMax[i]== rightMin[i])
			{
				System.out.println("the result by two array is "+leftMax[i]);
			}
			i++;
			j++;
		}
	}
	
	
	
	private static int min(int x, int y) {
		return x < y ? x : y;
	}
	
	private static int max(int x, int y) {
		return x >y ? x : y;
	}

	private static void printNumber(int[] array, int[] rightMin) {
		System.out.println("The rightMin:: " + rightMin[array.length - 1]);
		System.out.println("The array length -1:: " + array[array.length - 1]);
	}

}
