package com.liuxiangwin.algor.leetcode.binarysearch;

import java.util.Arrays;

import com.liuxiangwin.Algorithm.Sort.test.TestQucikSort;

public class SortComparison {

	public static void  sortComparsion() {
		 int[] A = new int[1000000];
         int[] B = new int[1000000];


         for (int i = 0; i < A.length; i++)
         {             
             A[i]=(int)(Math.random()*100);
            	
         }
         B = Arrays.copyOf(A, A.length);
         SortComparison sw = new SortComparison();
         long a = System.currentTimeMillis();
         TestQucikSort quickSort = new TestQucikSort();
         quickSort.quickSort(B, 0, B.length-1);
         long b = System.currentTimeMillis();
         System.out.println("The quick sort time is "+(b-a));

        
         long c = System.currentTimeMillis();
         new SortColors().countSort(A,100);
         long d = System.currentTimeMillis();
         System.out.println("The count sort time is "+(d-c));
         
         //可见计数排序要比快速排序快将近6倍左右。
	}

/**
 * 当数据量越来越大时，

归并排序：比较次数少，速度慢。稳定性：所以排序时稳定的。

快速排序：比较次数多，速度快。 稳定性 即不保序的。

快速排序的优势越来越明显。



原因分析：个人认为是当数据量越来越大时，尽管归并排序的比较次数较少，
但是归并排序后期的合并操作所花费的时间便越来越大，
合并操作对整体的效率影响越来越明显，
包括后面大量数据的赋值操作等。
所以当数据量变大时，不需要专门合并的快速排序的优势就变得越发明显。
 */

}
