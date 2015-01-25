package com.liuxiangwin.algor.leetcode.operator;

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
	public static int solution(int number) {
		int max = 0;
		int count = -1;
		int result = 0;
        
		while (number > 0) {
			// ͨ�����Ʋ�����&ÿ��bitλ
			result = number & 1;  //(������������Ǽ�����λ����1����0) 
			number = number >> 1; //(�������������ÿ������һλ)
			//�����0
			if (result ==0 && count >= 0) {
				count++;
			} 
			//��ʾ��ͷ��
			if (result == 1) {
				max = count > max ? count : max;
				count = 0;
			}
		} 
		return max;
	}
 
	public static void main(String[] args) {
		//10 binary number 1001
		System.out.println(solution(9));
	}
}
