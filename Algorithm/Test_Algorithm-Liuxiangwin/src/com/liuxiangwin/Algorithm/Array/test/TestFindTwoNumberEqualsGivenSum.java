package com.liuxiangwin.Algorithm.Array.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestFindTwoNumberEqualsGivenSum {

	/**
	 * Find the two number equals the given sum in the array
	 * with help of supplementary  array
	 */
	
	private static HashMap<Integer, Integer> resultMap  = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sortedArray =   { 1,  2,  4,  7, 11, 15 };

		int[] compare = { 14, 13, 11, 8, 4, 0 };
		int number = 15;
		// System.out.println(Arrays.toString(findArray(array,number)));

		System.out.println(Arrays.toString(findTwoNumberArray(sortedArray, number)));
		
		int expectNumber=20;
		System.out.println("The sum expect with 15 "+isTwoNumberEqualsExpect(sortedArray, number));
		System.out.println(("The sum expect with 20 "+isTwoNumberEqualsExpect(sortedArray, expectNumber)));
		

	}

	private static int[] findTwoNumberArray(int[] array, int number) {
		int[] compareArray = new int[array.length];

		for (int k = 0; k < array.length; k++) {
			compareArray[k] = number - array[k];
			//result.put(k,array[k]);

		}		
		int i = 0;
		int j = array.length - 1;

		while (i != array.length - 1 && j != 0) // focus the conditon
		{
			if (array[i] > compareArray[j]) {
				j--;
			} else if (array[i] < compareArray[j]) {
				i++;
			} else {
				System.out.println("find " + array[i] + " " + compareArray[j]);
				
				resultMap.put(i, array[i]);
				i++;
				j--;

			}
		}

		return null;

	}
	
	
	private static boolean isTwoNumberEqualsExpect(int[] array, int expectSum) {
		int[] compareArray = new int[array.length];

		for (int k = 0; k < array.length; k++) {
			compareArray[k] = expectSum - array[k];

		}
		// Original array 	     [1,   2,  4, 7, 11,15];
		// Allocate compareArray [14, 13, 11, 8, 4, 0];
	    //Compare the two array from beign and end
		//Which element is smaller,then index ++;			     
		//Only the element equals in the two different array,then it is answer
		//while in the two array which is smaller and the move frist
		int i = 0;
		int j = array.length - 1;
		while (i != array.length - 1 && j != 0) 
		{
			if (array[i] > compareArray[j]) {
				j--;
			} else if (array[i] < compareArray[j]) {
				i++;
			} else {
				System.out.println("find " + array[i] + " " + compareArray[j]);
				HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				map.put(i, array[i]);				
				i++;
				j--;
				return true;

			}
		}

		return false;

	}
	
	
	

	/**
	 * The Complex is N*N
	 * 
	 * @param array
	 * @param check
	 * @return
	 */
	private static int[] findArray(int[] array, int check) {
		int[] tep = null;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				int temp = array[i] + array[i + 1 + j];
				if (temp == check) {
					System.out.println("find " + array[i] + " "
							+ array[i + 1 + j]);
					int[] result = { array[i], array[i + 1 + j] };
					tep = result;

				}
			}
		}
		return tep;
	}

}