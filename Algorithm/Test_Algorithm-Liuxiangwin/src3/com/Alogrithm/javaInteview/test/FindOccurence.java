package com.Alogrithm.javaInteview.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.liuxiangwin.Algorithm.Uitl.test.SortedUtil;

public class FindOccurence {

	public static void main(String[] args) {
		int[] intArray={5,7,7,5,7,9};
		sortArray(intArray);
		System.out.println("After Sort array "+Arrays.toString(intArray));
		modArray(intArray);
		System.out.println("After Mod array "+Arrays.toString(intArray));
		
	}
	
	
	private static void modArray(int[] array)
	{
		for(int i=0;i<array.length;i++)
		{
			array[i]=array[i]%3;
		}
	}
	
	private static void sortArray(int[] array)
	{
		SortedUtil.quickSortByAscending(array, 0, array.length-1);
	}
}
