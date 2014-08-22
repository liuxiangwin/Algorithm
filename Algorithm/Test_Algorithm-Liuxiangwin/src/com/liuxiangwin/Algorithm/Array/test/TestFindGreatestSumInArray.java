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
		
		findMaxSubArray(array4);
		
		
		

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
	        System.out.println("The maxsum Array is   : "+Arrays.toString(Arrays.copyOfRange(inputArray,maxStartIndex,maxEndIndex)));
	        
	        
	    }	
}
