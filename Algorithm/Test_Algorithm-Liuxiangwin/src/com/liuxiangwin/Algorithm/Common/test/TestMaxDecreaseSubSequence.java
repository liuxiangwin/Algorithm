package com.liuxiangwin.Algorithm.Common.test;

import com.liuxiangwin.Algorithm.Uitl.test.SortedUtil;

public class TestMaxDecreaseSubSequence {
	/**
	 * To be deep fix the logic ????
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[] { 9, 8, 6, 5, 3, 5, 4, 2, 1 };
		System.out.println("The original sequence is:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "  ");
		}
		;
		// maxSubstrDecrease(array);
		int[] arrayFind = { 3, 2, 4, 3, 6 };

		System.out.println(FindM(arrayFind, arrayFind.length));
	}

	public static int FindM(int arr[], int length) {
		if (null == arr || length <= 0) {
			return -1;
		}
		SortedUtil.quickSortByDescending(arr, 0, arr.length - 1);
		int sum = 0;
		// 数组的和
		for (int i = 0; i < length; i++) {
			sum += arr[i];
		}
		int end = length - 1;
		int subSum = arr[0];
		while (sum / subSum >= 2) {
			if (sum % subSum == 0) {
				return sum / subSum;
			}
			subSum += arr[end--];
		}
		return -1;
	}

	public static void maxSubstrDecrease(int[] array) {
		int[] tmpArray = new int[array.length];
		// 数组中array的前i个元素中，最长递减子序列的长度是LIS[i]
		int max = 0;
		for (int i = 0; i < array.length; i++) {
			tmpArray[i] = 1;
			for (int j = 0; j < i; j++) {
				// LIS[i+1]=max{1,LIS[k]+1}, array[k]<array[i+1],for any k<=i;
				if (array[i] < array[j] && tmpArray[j] + 1 > tmpArray[i])
					tmpArray[i] = tmpArray[j] + 1;
			}
		}
		max = maxsub(tmpArray);
		System.out.println("The max length of decrease sequence is :" + max);
	}

	public static int maxsub(int[] tmpArray) {
		int m = 0;
		for (int i = 0; i < tmpArray.length; i++) {
			if (tmpArray[i] > m)
				m = tmpArray[i];
		}
		return m;
	}

	int LIS(int[] array) {
		int[] tmpArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			tmpArray[i] = 1; // 初始化默认的长度
			for (int j = 0; j < i; j++) // 找出前面最长的序列
			{
				if (array[i] > array[j] && tmpArray[j] + 1 > tmpArray[i]) 
				{
					tmpArray[i] = tmpArray[j] + 1;
				}
			}
		}
		//return Max(tmpArray); // 取LIS的最大值
		return 0;
	}

}
