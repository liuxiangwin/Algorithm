package com.liuxiangwin.Algorithm.Common.test;

public class TestBalanceArray {

	/**
	 * To be deep understand the logic ????
	 */
	public static void main(String[] args) {
		int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 90, 0, 0, 100 };

		int[] array2 = { -1, -2, -100, -3, 99, -222, -2, -3, -5, -88, 11, 12,
				13 };

		new Helper().BalanceArray(array1, array2);

		for (int i : array1) {
			System.out.println(i);
		}
		for (int i : array2) {
			System.out.println(i);
		}
	}

	// Build a balance Tree
	public static void balance(int[] data, int frist, int last) {
		if (frist < last) {
			int middle = frist + last;
			insert(middle);
			balance(data, frist, middle - 1);
			balance(data, middle + 1, last);
		}
	}

	public static void insert(int data) {
	}
}

class Helper {
	public void BalanceArray(int[] array1, int[] array2) {
		if (array1.length != array2.length)
			return;
		if (Sum(array1) < Sum(array2)) {
			int[] array = array1;
			array1 = array2;
			array2 = array;
		}
		boolean ifCycle = true;
		int length = array1.length;
		while (ifCycle) {
			ifCycle = false;
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length; j++) {
					int itemValue = array1[i] - array2[j];
					int sumValue = Sum(array1) - Sum(array2);
					if (itemValue < sumValue && itemValue > 0) {
						ifCycle = true;
						int item = array1[i];
						array1[i] = array2[j];
						array2[j] = item;
					}
				}
			}
		}

	}

	private int Sum(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}
	/**
	 * 当前数组a和数组b的和之差为 A = sum(a) - sum(b)
	 * 
	 * a的第i个元素和b的第j个元素交换后，a和b的和之差为 A' = sum(a) - a[i] + b[j] - （sum(b) - b[j] +
	 * a[i]) = sum(a) - sum(b) - 2 (a[i] - b[j]) = A - 2 (a[i] - b[j]) 设x = a[i]
	 * - b[j] |A| - |A'| = |A| - |A-2x| |A'|= |A-2x|
	 * 
	 * 在a和b中寻找使得x在(0,A)之间并且最接近A/2的i和j，
	 * 交换相应的i和j元素，重新计算A后，重复前面的步骤直至找不到(0,A)之间的x为止。
	 */
}
