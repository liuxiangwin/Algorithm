package com.liuxiangwin.algor.leetcode.operator;

public class OperatorNumber {
	
	public static int swapOddEvenBits(int x) { 
		//0xaaaaaaaa也就是10101010....）取出偶数位,相当于奇数位清零了
		//用0x55555555（也就是01010101...）取出奇数位，相当于偶数位清零了
		return ( ((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1) ); 
	} 
	
	public static void main(String[] args) {
		int a = 103217;
		System.out.println(a + ": " + OperatorNumber.toFullBinaryString(a));
		int b = swapOddEvenBits(a);
		System.out.println(b + ": " + OperatorNumber.toFullBinaryString(b));
	}
	
	public static String toFullBinaryString(int a) {
		String s = "";
		for (int i = 0; i < 32; i++) {
			Integer lsb = new Integer(a & 1);
			s = lsb.toString() + s;
			a = a >> 1;
		}
		return s;
	}
	
	
}
