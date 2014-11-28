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
	
	
	//���ǵݹ����һ�㶼��̫���ˣ���Ϊ��Fibonacci����һ����
	//�ظ������˺ܶ��֧��
	//����ʹ�ö�̬�滮��������Ч�ʣ�����Ҳ�ܼ򵥣�����
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