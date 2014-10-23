package com.liuxiangwin.algor.leetcode.number;

// Analysis: http://blog.csdn.net/lilong_dream/article/details/22677537

// Given two sorted integer arrays A and B, 
//merge B into A as one sorted array.
// Note:
// You may assume that A has enough space 
//(size that is greater or equal to m + n) 

// to hold additional elements from B. 
// The number of elements initialized 
//in A and B are m and n respectively.

//Find the k-th Smallest Element in the Union of Two Sorted Arrays

//Find the k-th Largest Element in the Union of Two Sorted Arrays

public class MergeTwoSortedArray {
	private static int kth=0;
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
	
	
	public void findKthElement(int arrayA[], int arrayAlength, int arrayB[], 
			int arrayBlength ,int kMaxorMin) {
		int idx = arrayAlength + arrayBlength - 1;
		int i = arrayAlength - 1;
		int j = arrayBlength - 1;
        int count =1;
		while (i >= 0 && j >= 0) {
			if (arrayA[i] >= arrayB[j]) {
				//那个数字大就把它放入到新的数组中,
				//并且都是放到空间大的那个数组中
				if(count== kMaxorMin)	{
					kth= arrayA[i--];
				}
				arrayA[idx--] = arrayA[i--];
				count++;
				
			} else {
				if(count== kMaxorMin)	{
					kth= arrayA[i--];
				}
				arrayA[idx--] = arrayB[j--];
				count++;
			}
		}
        //如果先把arrayA中遍历完，就把arrayB 赋值给它
		if (i == -1) {
			while (j >= 0) {
				if(count== kMaxorMin)
				{ 
					kth= arrayB[j];
				}
				arrayA[j] = arrayB[j];
				j--;
				count++;
			}
		}
	}
	
	
	public static void main(String[] args) {
		MergeTwoSortedArray slt = new MergeTwoSortedArray();
		int A[] = new int[5];
		A[0] = 1;
		A[1] = 3;
		A[2] = 5;
		
		int B[] = { 2, 4 };
		//we want to find Kthe largest
		
		slt.merge(A, 3, B, 2);
		for (int i = 0; i < 5; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println("-----------");
		int A2[] = new int[5];
		A2[0] = 1;
		A2[1] = 3;
		A2[2] = 5;
		
		int B2[] = { 2, 4 };
		int KthLarger= 3;
		slt.findKthElement(A2, 3, B2, 2,KthLarger);
		System.out.print("The Kth largest element is "+kth);
		
	}
}