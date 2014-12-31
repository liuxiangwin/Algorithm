package com.liuxiangwin.algor.leetcode.binarysearch;

import java.util.Arrays;

public class SortColors {

	public void sortColors(int[] A) {
		if (A == null || A.length == 0)
			return;
		int[] res = new int[A.length];
		int[] helper = new int[3];
		for (int i = 0; i < A.length; i++) {
			helper[A[i]]++;
		}
		for (int i = 1; i < 3; i++) {
			helper[i] = helper[i] + helper[i - 1];
		}
		for (int i = A.length - 1; i >= 0; i--) {
			res[helper[A[i]] - 1] = A[i];
			helper[A[i]]--;
		}
		for (int i = 0; i < A.length; i++) {
			A[i] = res[i];
		}
	}
	
	
	public void sortColors2(int[] arr) {
		if (arr == null || arr.length == 0)
			return;
		int idx0 = 0;
		int idx1 = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr[i] = 2;
				arr[idx1++] = 1;
				arr[idx0++] = 0;
			} else if (arr[i] == 1) {
				arr[i] = 2;
				arr[idx1++] = 1;
			}
		}
	}
	
	
	public void sortColors3(int[] arr) {
		int length = arr.length;
		int left = -1;
		int high = length;
		int low = 0;
		while (low < high) {
			if (arr[low] == 0) {
				swap(arr, ++left, low++);
			} else if (arr[low] == 2) {
				swap(arr, low, --high);
			} else {
				low++;
			}
		}
	}

	private void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	
/**
 * oogle
https://1024.bz/


http://blog.csdn.net/joe_007/article/details/12952821

http://compsci.ca/v3/viewtopic.php?t=18782

http://blog.itpub.net/7899089/viewspace-736668/



sort color
http://blog.csdn.net/linhuanmars/article/details/24286349

http://heai.info/2014-11/markdown-leetcode-find-minimum-in-rotated-sorted-array-ii/
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortColors sortColors = new SortColors();
		int a[] ={1,1,1,2,2,0,1,1};
	    sortColors.sortColors(a);
	    System.out.println(Arrays.toString(a));
	    System.out.println("------------------------");
	    
	    int b[] ={1,1,1,2,2,0,1,1};
	    System.out.println(Arrays.toString(b));	    
	    sortColors.sortColors2(b);
	    System.out.println(Arrays.toString(b));
	    
	    
	    System.out.println("------------------------");
	    int c[] ={0,1,2,2,0,1};
	    System.out.println(Arrays.toString(c));	    
	    sortColors.sortColors3(c);
	    System.out.println(Arrays.toString(c));
	}

}
