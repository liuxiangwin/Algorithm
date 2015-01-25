package com.liuxiangwin.algor.leetcode.number;

import java.util.Arrays;

/** 
 * Given a number represented as an array of digits, plus one to the number. 
 */

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int length = digits.length;
		int add = 1;
		for (int i = length - 1; i >= 0; i--) {// 从最后一位开始计算
			int sum = digits[i] + add;
			digits[i] = sum % 10;//余数取模是留下来的值
			add = sum / 10;      // /是进位值
			if (add == 0){ //等于0只会发生在没有大于10的情况
				return digits;
			}				
		}
		int[] ret = new int[length + 1];
		ret[0] = add;
		for (int i = 0; i < length; i++) {
			ret[i + 1] = digits[i];
		}
		return ret;
	}
	public static void main(String args[])
	{
		int[] digits ={9,9,9};
		System.out.println(Arrays.toString(new PlusOne().plusOne(digits)));
		
		
		int[] digits2 ={2,9};
		System.out.println(Arrays.toString(new PlusOne().plusOne(digits2)));
	}
}