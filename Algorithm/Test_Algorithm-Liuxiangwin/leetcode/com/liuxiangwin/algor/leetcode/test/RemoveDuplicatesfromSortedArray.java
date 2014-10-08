package com.liuxiangwin.algor.leetcode.test;

import java.util.Arrays;
// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/19757047

// Given a sorted array, 
// remove the duplicates in place such that each element appear only once and return the new length.
// Do not allocate extra space for another array, you must do this in place with constant memory.
// For example,
// Given input array A = [1,1,2], 
// Your function should return length = 2, and A is now [1,2]. 

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] A) {
    	if(A.length == 0) {
    		return 0;
    	}
    	if(A.length == 1) {
    		return 1;
    	}
    	
        int index = 0;
        for(int i = 1; i < A.length; i++) {
        	if(A[i] != A[index]) {
        		//ָ���Ƶ���һλ��������Ų��ظ���ֵ
        		index++;
        		//��Ų��ظ���ֵ,index��λ���൱���м����
        		A[index] = A[i];
        	}
        }
        //����ǳ���Ҫindex+1 ���ص���ȥ�غ�ĳ���
        return index + 1;
    }
    
    public static void main(String[] args) {
    	RemoveDuplicatesfromSortedArray slt = new RemoveDuplicatesfromSortedArray();
    	//int[] array = {1, 1, 2, 3, 4, 4, 5};
    	
    	int[] array = {2, 3,1,1, 5, 4, 4};
    	//int[] array = {1, 1, 2};    	
    	
    	int len = slt.removeDuplicates(array);
    	System.out.println(len);
    	for(int i = 0; i < len; i++) {
    		System.out.print(array[i] + " ");
    	}
    	System.out.println(Arrays.toString(array));
    }
}

