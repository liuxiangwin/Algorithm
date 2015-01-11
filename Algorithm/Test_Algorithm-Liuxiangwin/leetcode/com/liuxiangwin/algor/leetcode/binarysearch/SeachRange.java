package com.liuxiangwin.algor.leetcode.binarysearch;

public class SeachRange {
	/**
	 * If the target is not found in the array, return [-1, -1].

		For example,
		Given [5, 7, 7, 8, 8, 10] and target value 8,
		return [3, 4].
	 * @param A
	 * @param target
	 * @return
	 * Analysis

		In fact, in this problem, we are going to 
		use binary search to find the border of certain target,
		 because there may be duplicate numbers. 
		 We can easily find the left border of certain target.
		  And we can try to find the left border of target + 1. 
		  And check if it exists to determine the right border.
	 */
	
	public int[] searchRange(int[] A, int target) {
		int[] ret = { -1, -1 };
		int start = 0;
		int end = A.length - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			if (A[mid] < target)
				start = mid + 1;
			else
				end = mid;
		}
		int low;
		if (A[start] != target) {
			return ret;
		}// 没有找到数字}
		else {
			low = start;
			start = 0;
			end = A.length - 1;
		}
		
		while (start < end) {
			int mid = (start + end) / 2;
			if (A[mid] < target + 1)//坐标移到下一位，比mid下一个，找第二个数
				start = mid + 1;
			else
				end = mid;
		}
		int high = A[start] == target ? start : start - 1;
		ret[0] = low;
		ret[1] = high;
		return ret;
	}

}
