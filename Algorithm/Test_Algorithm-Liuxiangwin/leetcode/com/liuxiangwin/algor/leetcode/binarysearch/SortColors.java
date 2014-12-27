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
	
	
	public void sortColors2(int[] A) {
		if (A == null || A.length == 0)
			return;
		int idx0 = 0;
		int idx1 = 0;
		
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				A[i] = 2;
				A[idx1++] = 1;
				A[idx0++] = 0;
			} else if (A[i] == 1) {
				A[i] = 2;
				A[idx1++] = 1;
			}
		}
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
	}

}
