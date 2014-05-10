package com.liuxiangwin.Algorithm.ArrayQuestion.test;

import java.util.Arrays;

import com.liuxiangwin.Algorithm.Uitl.test.SortedUtil;

public class TestFindCommonElementNoOrderArray {
	public static void main(String[] args) {
		int[] array1 = { 5, 5, 1, 3, 4 };

		//int[] array2 = { 5, 7, 6, 2, 4, 5 };
		
		int[] array2 = { 2,4,5,5,7,6};


		GetCommonNumbers(array1, array2);

	}

	private static void GetCommonNumbers(int[] array1, int[] array2)

	{
        //SortedUtil.quickSortByAscending(array1, 0, array1.length-1);
        //SortedUtil.quickSortByAscending(array2, 0, array1.length-1);
        //System.out.println(Arrays.toString(array2));
        int i=0,  j=0;
        while(i<array1.length&&j<array2.length)
        
        {
        	 if(array1[i]>array2[j])
             {
             	j++;
             }
             else if(array1[i]==array2[j])
             {
             	System.out.println("The common element is "+array1[i]+"  "+array2[j]);
                i++;
                j++;
             }
             else
             {
             	i++;
             }
        	
        }
       
	}
}
