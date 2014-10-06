package com.liuxiangwin.algor.leetcode.test.operator;

/**
 * Problem: Get maximum binary Gap.
For example, 9's binary form is 1001, the gap is 2.

Thoughts
The key to solve this problem is the 
fact that an integer x & 1 will get 
the last digit of the integer.
 *
 */
public class MaxBinaryGap {
	public static int solution(int N) {
		int max = 0;
		int count = -1;
		int r = 0;
        
		while (N > 0) {
			// 通过右移操作来&每个bit位
			r = N & 1;
			N = N >> 1; 
			//如果是0
			if (0 == r && count >= 0) {
				count++;
			} 
			//表示到头了
			if (1 == r) {
				max = count > max ? count : max;
				count = 0;
			}
		} 
		return max;
	}
 
	public static void main(String[] args) {
		//10 binary number 1001
		System.out.println(solution(10));
	}
}
