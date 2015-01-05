package com.liuxiangwin.Algorithm.Array.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class TestFindGreatestSumInArray {

	/**
	 * Find the greatest sum of sub array,the sub array is sequence
	 */

	public static void main(String[] args) {

		//int[] array = new int[] { 1, -2, 3, 10, -4, 7, 2, -5 };
		
		int[] test_array1 = new int[] { 1, 2, 3, 10, -4, 7, 2, 5 };
		
		int array2[] = {-1, 3, -5, 4, 6, -1, 2, -7, 13, -3};
		
		
		int array3[] = {-9, -2,-3,-3};
		
		int array4[] ={1, -2, 3, 10, -4, 7, 2, -5};
		
		int array5[] = {-2,1,-3,4,-1,2,1,-5,4};
		
		//findMaxSubArray(array5);
		
		
		
		int array6[] = {2,3,-8,-1,2,4,-2,3};
		
		findMaxSubArray(array6);
		
		
		int A[] = {2,3,-8,-1,2,4,-2,3};
		MaximumSubarray slt = new MaximumSubarray();
		int result = slt.maxSubArray(A);
		System.out.println(result);

	}

	
	 public static void findMaxSubArray(int[] inputArray){

	        int maxStartIndex=0;
	        int maxEndIndex=0;
	        int maxSum = Integer.MIN_VALUE; 

	        int tmpSum= 0;
	        //int[] intArr = {-1, 3, -5, 4, 6, -1, 2, -7, 13, -3};
	    	//int[] intArr={-6,-2,-3,-4,-1,-5,-5};
	         //int[] intArr={-9, -2,-3,-3}
           
	        for (int i = 0; i < inputArray.length; i++) {

	            tmpSum+= inputArray[i];

	            if( inputArray[i] > tmpSum){
	                 
	            /**
	             *  Remove the previous temporary summation
	                Replace with current element,the set start
	                with current index
	                                                这种 情况只可能发生在，前面是负数，然后当前是正数
	             */	               
	            	maxStartIndex = i;
	            	tmpSum = inputArray[i];      
	            }
	            if(tmpSum > maxSum){
	                maxSum = tmpSum;
	                maxEndIndex = i;
	            }
	        }
            System.out.println("The input Array is "+ Arrays.toString(inputArray));
	        System.out.println("Max sum         : "+maxSum);
	        System.out.println("Max start index : "+maxStartIndex);
	        System.out.println("Max end index   : "+maxEndIndex);
	        System.out.println("The maxsum Array is   : "+Arrays.toString(Arrays.copyOfRange(inputArray,maxStartIndex,maxEndIndex+1)));
	        
	        int[] result = new int[maxEndIndex-maxStartIndex+1];
	        for(int j=0, i= maxStartIndex;i<= maxEndIndex;i++,j++)
	        {
	        	result[j]=inputArray[i];
	        }
	        System.out.println("The maxsum Array is   : "+Arrays.toString(result));
	    }	
}

//Author:   Li Long, 1988lilong@163.com
//Date:     Apr 18, 2014
//Source:   http://oj.leetcode.com/problems/maximum-subarray/
//Analysis: http://blog.csdn.net/lilong_dream/article/details/19846683

//Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
//For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
//the contiguous subarray [4,-1,2,1] has the largest sum = 6. 
//More practice:
//If you have figured out the O(n) solution, 
//try coding another solution using the divide and conquer approach, which is more subtle.

 class MaximumSubarray {
	public int maxSubArray(int[] A) {
		int thisSum = A[0] > 0 ? A[0] : 0;
		int maxSum = A[0];

		for (int i = 1; i < A.length; ++i) {
			thisSum += A[i];
			if (thisSum > maxSum) {
				maxSum = thisSum;
			}
			if (thisSum < 0) {
				thisSum = 0;
			}
		}

		return maxSum;
	}

	public static void main(String[] args) {
		//int[] A = new int[] { -2, 1 }; 
		
		int A[] = {2,3,-8,-1,2,4,-2,3};
		MaximumSubarray slt = new MaximumSubarray();
		int result = slt.maxSubArray(A);
		System.out.println(result);
	}
}