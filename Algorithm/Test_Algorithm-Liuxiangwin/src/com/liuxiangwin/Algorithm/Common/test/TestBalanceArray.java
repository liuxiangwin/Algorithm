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
	 * ��ǰ����a������b�ĺ�֮��Ϊ A = sum(a) - sum(b)
	 * 
	 * a�ĵ�i��Ԫ�غ�b�ĵ�j��Ԫ�ؽ�����a��b�ĺ�֮��Ϊ A' = sum(a) - a[i] + b[j] - ��sum(b) - b[j] +
	 * a[i]) = sum(a) - sum(b) - 2 (a[i] - b[j]) = A - 2 (a[i] - b[j]) ��x = a[i]
	 * - b[j] |A| - |A'| = |A| - |A-2x| |A'|= |A-2x|
	 * 
	 * ��a��b��Ѱ��ʹ��x��(0,A)֮�䲢����ӽ�A/2��i��j��
	 * ������Ӧ��i��jԪ�أ����¼���A���ظ�ǰ��Ĳ���ֱ���Ҳ���(0,A)֮���xΪֹ��
	 */
}
