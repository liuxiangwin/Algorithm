package com.liuxiangwin.algor.leetcode.number;

public class RemoveDuplicatesfromSortedArrayII {
	//For example, given sorted array A = [1,1,1,2,2,3], 
	 //your function should return length = 5, 
	//and A is now [1,1,2,2,3].
	
	public int removeDuplicates(int[] A) {
		if (A.length <= 2)
			return A.length;
 
		int index = 1; // point to previous
		int curr = 2; // point to current
 
		while (curr < A.length) {
			if (A[curr] == A[index] && A[curr] == A[index - 1]) {
				curr++;
			} else {
				index++;
				A[index] = A[curr];
				curr++;
			}
		}
 
		return index + 1;
	}
}
