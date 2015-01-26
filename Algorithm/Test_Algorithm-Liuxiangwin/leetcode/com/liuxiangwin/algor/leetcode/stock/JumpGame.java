package com.liuxiangwin.algor.leetcode.stock;


/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump 
 * length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example: A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 */
//过每个index查看能到的最远的index，
//若当前最远的比遍历index还小或者相等时就走不下去了。
public class JumpGame {
	public boolean canJump(int[] A) {
		if (A.length <= 1)
			return true;
		int curMax = 0;
		int max = 0;
		for (int i = 0; i < A.length - 1; i++) {
			if (i > max)
				break;
			curMax = A[i] + i;
			if (curMax > max) {
				max = curMax;
			}
			if (max >= A.length - 1)
				return true;
		}
		return false;
	}
	public static void main(String args[])
	{
		int[] nums  ={2,3,1,1,4};
		new JumpGame().canJump(nums);
		
		int[] nums2  ={3,2,1,0,4};
		new JumpGame().canJump(nums2);
	}
}