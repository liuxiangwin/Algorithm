package com.liuxiangwin.algor.leetcode.test;

// Analysis: http://blog.csdn.net/lilong_dream/article/details/22677537

// Given two sorted integer arrays A and B, 
//merge B into A as one sorted array.
// Note:
// You may assume that A has enough space 
//(size that is greater or equal to m + n) 

// to hold additional elements from B. 
// The number of elements initialized 
//in A and B are m and n respectively.

public class MergeSortedArray {
	public void merge(int arrayA[], int arrayAlength, int arrayB[], 
			int arrayBlength) {
		int idx = arrayAlength + arrayBlength - 1;
		int i = arrayAlength - 1;
		int j = arrayBlength - 1;

		while (i >= 0 && j >= 0) {
			if (arrayA[i] >= arrayB[j]) {
				//那个数字大就把它放入到新的数组中,
				//并且都是放到空间大的那个数组中
				arrayA[idx--] = arrayA[i--];
			} else {
				arrayA[idx--] = arrayB[j--];
			}
		}
        //如果先把arrayA中遍历完，就把arrayB 赋值给它
		if (i == -1) {
			while (j >= 0) {
				arrayA[j] = arrayB[j];
				j--;
			}
		}
	}

	public static void main(String[] args) {
		MergeSortedArray slt = new MergeSortedArray();
		int A[] = new int[5];
		A[0] = 1;
		A[1] = 3;
		A[2] = 5;
		
		int B[] = { 2, 4 };
		slt.merge(A, 3, B, 2);

		for (int i = 0; i < 5; i++) {
			System.out.print(A[i] + " ");
		}
	}
}