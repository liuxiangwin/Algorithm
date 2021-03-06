package com.liuxiangwin.algor.leetcode.operator;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 */

public class AddBinary {


	public String addBinary2(String a, String b) {
		int carry = 0;
		String res = "";	
		int maxLen = Math.max(a.length(), b.length());

		for (int i = 0; i < maxLen; i++) {
			// start from last char of a and b
			// notice that left side is int and right side is char
			// so we need to minus the decimal value of '0'
			int p = 0, q = 0;
			//从低位开始计算，如果索引已经超过字符长度了，该位上为'0'
			p = i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : '0';
            //两个数对其从低位相加，为2相进位一次，如果这位上没有就是0
			q = i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : '0';

			int tmp = p + q + carry;			
			res += tmp % 2;  //当前位 和之前当前位相加
			carry = tmp / 2; //进位
		}
        //最长字符串循环完成后，看看有没有进位，有进位就是"1"+结果
		 //否则就是结果本身
		return (carry == 0) ? res : "1" + res;
	}

	public static void main(String args[]) {
		AddBinary addBinary = new AddBinary();
		System.out.println(addBinary.addBinary2("11", "1"));

	}

}