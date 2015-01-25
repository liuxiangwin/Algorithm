package com.liuxiangwin.algor.leetcode.number;

import java.util.Arrays;

/** 
 * Given a number represented as an array of digits, plus one to the number. 
 */

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int length = digits.length;
		int add = 1;
		for (int i = length - 1; i >= 0; i--) {// �����һλ��ʼ����
			int sum = digits[i] + add;
			digits[i] = sum % 10;//����ȡģ����������ֵ
			add = sum / 10;      // /�ǽ�λֵ
			if (add == 0){ //����0ֻ�ᷢ����û�д���10�����
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