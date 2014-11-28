package com.liuxiangwin.algor.leetcode.dynamic;


/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 */

public class ClimbingStairs {
	
	
	private int climbStairsRecur(int n) {
		if (n == 1) return 1;
		if (n == 2) return 2;
		return climbStairsRecur(n-1) + climbStairsRecur(n-2);
	}
	
	
	//但是递归程序一般都是太慢了，因为像Fibonacci问题一样，
	//重复计算了很多分支，
	//我们使用动态规划法填表，提高效率，程序也很简单，如下
	public int climbStairs(int n) {
		int[] arr = new int[n + 1];
		arr[0] = 1;
		arr[1] = 1;
		for (int i = 2; i <= n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr[n];
	}
}