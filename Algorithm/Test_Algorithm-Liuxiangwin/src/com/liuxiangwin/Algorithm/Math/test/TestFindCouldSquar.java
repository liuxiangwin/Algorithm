package com.liuxiangwin.Algorithm.Math.test;

public class TestFindCouldSquar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// (24);
		// System.out.println(isSqurNumber(9));
		// System.out.println(isSqurNumber(24));
		System.out.println(isSquare(4));
		int[] array = { 5, 9, 3, 1 };
		//couldSqurNumberByRange(array);
		
	}

	private static boolean  isSquare(int inputNum)
	/* 判断num是否完全平方数 是--返回1 否--返回0 */
	{
		int i, sum;
		for (i = 1, sum = 0; sum < inputNum; ++i) {
			sum += (2 * i - 1);
			if (sum == inputNum)
				return true;
		}
		return false;
	}



}
