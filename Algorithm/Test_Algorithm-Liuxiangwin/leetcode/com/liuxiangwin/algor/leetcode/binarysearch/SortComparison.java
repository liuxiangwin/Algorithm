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
         
         //�ɼ���������Ҫ�ȿ�������콫��6�����ҡ�
	}

/**
 * ��������Խ��Խ��ʱ��

�鲢���򣺱Ƚϴ����٣��ٶ������ȶ��ԣ���������ʱ�ȶ��ġ�

�������򣺱Ƚϴ����࣬�ٶȿ졣 �ȶ��� ��������ġ�

�������������Խ��Խ���ԡ�



ԭ�������������Ϊ�ǵ�������Խ��Խ��ʱ�����ܹ鲢����ıȽϴ������٣�
���ǹ鲢������ڵĺϲ����������ѵ�ʱ���Խ��Խ��
�ϲ������������Ч��Ӱ��Խ��Խ���ԣ�
��������������ݵĸ�ֵ�����ȡ�
���Ե����������ʱ������Ҫר�źϲ��Ŀ�����������ƾͱ��Խ�����ԡ�
 */

}
