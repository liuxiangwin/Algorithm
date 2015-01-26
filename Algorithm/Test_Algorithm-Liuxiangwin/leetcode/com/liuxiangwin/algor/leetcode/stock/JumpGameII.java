package com.liuxiangwin.algor.leetcode.stock;
/**
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example:
 * 
 * Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2.
 *  (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
//�� jump-gameһ��, ����̰�ġ�
//ÿ��ѡ��ǰ�������ķ�Χ�ڣ���һ����������Զ��

public class JumpGameII {
	public int jump(int[] A) {
		int result = 0;
		int curr = 0;
		int last = 0;
		
		for (int i = 0; i < A.length; ++i) {
			if (i > last) {
				last = curr;
				++result;
			}
			curr = Math.max(curr, i + A[i]);
		}
		return result;
	}
	public static void main(String args[])
	{
		int[] nums  ={2,3,1,1,4};
		new JumpGameII().jump(nums);
	
	}
}
