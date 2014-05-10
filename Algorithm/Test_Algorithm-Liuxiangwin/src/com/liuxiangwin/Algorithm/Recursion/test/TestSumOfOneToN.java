package com.liuxiangwin.Algorithm.Recursion.test;

public class TestSumOfOneToN {

	/**
	 * @param args
	 */
	
	static {
		System.out.println("---Static invoke---");
	}
	{
		System.out.println("Dynamic invoke");
	}
	
	public TestSumOfOneToN()
	{
		System.out.println("Construtor invoke");
	}
	public static void main(String[] args) {
		//System.out.println(cacluteOneToN(3));
		new TestSumOfOneToN();
		new TestSumOfOneToN();

	}

	private static int cacluteOneToN(int n) {
		int i = 1;
		// (n>1)&&(i=cacluteOneToN(n-1)+n);
		i = cacluteOneToN((n - 1) + n);
		return i;

	}

	private double Power(double base, int exponent) {

		double result = 1.0;
		for (int i = 1; i <= exponent; ++i)

			result *= base;
		return result;

	}

}
