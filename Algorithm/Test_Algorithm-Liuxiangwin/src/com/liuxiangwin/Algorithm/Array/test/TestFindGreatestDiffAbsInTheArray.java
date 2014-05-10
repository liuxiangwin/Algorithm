package com.liuxiangwin.Algorithm.Array.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TestFindGreatestDiffAbsInTheArray {

	/**
	 * 1.Find the Max different in the array 
	 * 2.The number is sequence
	 * 3.This could be equals find the latest distance in the picture you should
	 * sort the array first
	 */
	private static ArrayList<Integer> list;	

	public static void main(String[] args) {        
		
		int seed[] = {1, 100, 2, 105, -10, 30, 80};
		
		System.out.println(findMaxDiff(seed));
	}

	
	private static int findMaxDiff(int[] array){
		
        int largestNumber = Integer.MIN_VALUE;
        int smallestNumber = Integer.MAX_VALUE; 

        for(int i = 0; i < array.length; i++)
        {
            if(array[i] > largestNumber)
                largestNumber = array[i];

            if(array[i] < smallestNumber)
                smallestNumber = array[i];
             
        }

        int biggestDifference = largestNumber - smallestNumber ;
        
        
        return biggestDifference;
		
	}
	private static int[] outputArray(int[] result, int a, int b, int min) {
		result[0] = a;
		result[1] = b;
		result[2] = min;
		return result;
	}
	
	private static int max(int x, int y)
	{
		return  x >y ? x: y;
	}
}
