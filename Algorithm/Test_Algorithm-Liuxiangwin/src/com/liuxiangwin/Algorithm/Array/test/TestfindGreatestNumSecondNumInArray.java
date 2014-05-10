package com.liuxiangwin.Algorithm.Array.test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestfindGreatestNumSecondNumInArray {
	private static ArrayList<Integer> list;
    
	/**
	 * 
	 * The second value only when the frist time would alloacte
	 * otherwise it would be changed at the correct time
	 * @param array
	 * @return
	 */
	private static int[] findGreatestNumInArray(int[] array) {
		int maxValue = Integer.MIN_VALUE;
        
		int secondValue = Integer.MIN_VALUE;
		
		int thirdValue = Integer.MIN_VALUE;
		
	    int[] result = new int[2];
	    
	    int[] result2 = new int[3];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > maxValue) {
				thirdValue = secondValue;
				secondValue = maxValue;
				maxValue = array[i];
				
			}
			else if(array[i]>secondValue)
			{
				secondValue = array[i];
			}
			
			else if(array[i]>thirdValue)
			{
				thirdValue = array[i];
			}
		}
		allowResult( result,maxValue,secondValue);
		
		allowResult( result2,maxValue,secondValue,thirdValue);
		//return maxValue;
		return result2;
	}
	
	private static void allowResult(int[] result,int maxValue,int secondValue)
	{
		result[0]= maxValue;
		
		result[1]= secondValue;
				
		
	}
	
	

	private static void allowResult(int[] result,int maxValue,int secondValue, int thirdValue)
	{
		result[0]= maxValue;
		
		result[1]= secondValue;
				
		result[2]= thirdValue;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] testData = { 4,5,6,7,9 };
		
		System.out.println(Arrays.toString(findGreatestNumInArray(testData)));
	}

}
