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
			p = i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : '0';
            //����������ӵ�λ��ӣ�Ϊ2���λһ�Σ������λ��û�о���0
			q = i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : '0';

			int tmp = p + q + carry;
			carry = tmp / 2; //��λ
			res += tmp % 2;  //��ǰλ ��֮ǰ��ǰλ���
		}

		return (carry == 0) ? res : "1" + res;
	}

	public static void main(String args[]) {
		AddBinary addBinary = new AddBinary();
		System.out.println(addBinary.addBinary2("11", "1"));

	}

}