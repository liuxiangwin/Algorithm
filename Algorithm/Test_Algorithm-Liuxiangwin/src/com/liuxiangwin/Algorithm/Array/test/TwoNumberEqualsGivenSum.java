package com.liuxiangwin.Algorithm.Array.test;

import java.util.Arrays;
import java.util.HashMap;

import com.liuxiangwin.algor.leetcode.sort.Three3Sum;



public class TwoNumberEqualsGivenSum {

	/**http://www.lifeincode.net/programming/leetcode-two-sum-3-sum-3-sum-closest-and-4-sum-java/
	 * 
	 * The complexity of this method is better than brute force method. 
	 * Sorting the array costs O(nlogn).
	 *  So, for Two Sum, it costs O(nlogn).
	 *  
	 *  For 3 Sum, it costs O(nlogn) +  O(n2) =  O(n2). 
	 *  
	 *  For 4 sum, it costs  O(n3).
	 * 
	 * 
	 * HashMap

		We can use HashMap to improve this algorithm.
		 For example, it can improve Two Sum from O(nlogn) to O(n).
		  That is, saving every number in the HashMap as well as its position. 
		  And then we can go through the array and 
		  check for the existence number target ¨C i in O(1). 
		  So we only need O(n). Similarly, with HashMap we can solve 3 Sum in O(n2) and 4
		   Sum in O(n2).
	 * 
	 * Find the two number equals the given sum in the array
	 * with help of supplementary  array
	 */
	//K sum problem
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
		
		int[] threeSum = {1, 0, -1 ,0 ,-2, 2};
		new Three3Sum().threeSum(threeSum);
		
		int[] threeClosed = {-1, 2 ,1, -4};
		new Three3Sum().threeSumClosest(threeClosed, 2);
		
		

	}

	private static int[] findTwoNumberArray(int[] array, int number) {
		int[] compareArray = new int[array.length];

		for (int k = 0; k < array.length; k++) {
			compareArray[k] = number - array[k];
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
}

	//Two Sum II - Input array is sorted 
	//http://www.cnblogs.com/higerzhang/p/4189418.html

	//Two Sum III - Data structure design 
	//http://www.cnblogs.com/x1957/p/4186171.html
	
	//http://tech-wonderland.net/blog/summary-of-ksum-problems.html
	//http://www.2cto.com/kf/201310/248433.html
	//http://blog.csdn.net/nanjunxiao/article/details/12524405
	

	
		