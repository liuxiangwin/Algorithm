package com.Alogrithm.javaInteview.test;

public class TestFlipByNth {

	/**
	 * By flip, the interviewer meant change 0 to 1 and 1 to 0. For instance, if
	 * you were passed in 8 and 3. Convert 8 to binary and you have 1000, now we
	 * flip the 3rd bit and we have 1100, then we convert this back to
	 * decimal(which would be 12)and return the answer
	 */
	public static void main(String[] args) {
		System.out.println("8 flip by 3 is :" + FlipBit(8, 3));
	}

	private static int FlipBit(int m, int n) {
		return m ^ (1 << n - 1);
	}

}
