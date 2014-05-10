package com.liuxiangwin.Algorithm.Uitl.test;

public class NumberUtil {
	
	//Swap two number without extra space
	public static void main(String args[]) {
		int a = 10;
		int b = 20;
		a = a ^ b;
		b = b ^ a;
		a = a ^ b;

		System.out.println("a=a ^ b " + (a ^ b));
		System.out.println("b=b ^ a " + (a ^ b));
		System.out.println("a ^ b)^(b ^ a)" + ((a ^ b) ^ (b ^ a)));

	}

	private void swapNumberWithoutTempSpace() {
		int a = 10;
		int b = 20;
		a = a ^ b;
		b = b ^ a;
		a = a ^ b;

	}

	private void swapNumberWithoutTempSpace2() {
		int a = 10;
		int b = 20;
		a = a + b;
		b = a - b;
		a = a - b;

	}

}
