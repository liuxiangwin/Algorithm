package com.liuxiangwin.algor.leetcode.combination.permutation;

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples.
 * 
 * Inputs are in the left-hand column and its corresponding outputs are in the
 * right-hand column. 1,2,3 -> 1,3,2 3,2,1 -> 1,2,3 1,1,5 -> 1,5,1
 */

public class NextPermutation {
	// STL直接有next_permutation的函数可以调用，其思想也比较直接。因为按升序排序是最小的，按降序排序是最大的，对于一个排列，从后往前找到第一个数x，其小于后面相邻的数字，再从后往前找到第一个数字y，其大于x，交换x跟y，然后把原先x后面的数字逆置，即可得到下一个排列。

	// 比如原排列为1 3 5 4 2，找到第一个数3，
	// 其小于后面的数字5，然后找到第一个数字4，'
	// 其大于3，交换3和4，得到1 4 5 3 2，
	// 然后逆转原来3后面的数字，即5 3 2，得到1 4 2 3 5，即为下一个排列。

	public static void nextPermutation2(int[] num) {
		if (num.length == 1)
			return;

		int i = num.length - 2;
		while (i >= 0 && num[i] >= num[i + 1]) {
			i--; // 找第一组升序
		}
		if (i == -1) // 全部降序，已是最大排列
		{
			// reverse(num.begin(), num.end());
			reverse(0, num.length - 1, num);
			return;
		}

		int j = num.length - 1; // 找第一个大于num[i]的
		while (num[i] >= num[j]){
			j--;
		}			
		swap(i, j, num); // 交换
		reverse(i + 1, num.length - 1, num); // 逆转

	}

	public static void nextPermutation(int[] num) {
		int i1 = 0;
		int i2 = 0;
		int i = num.length - 1;
		int j = 0;
		while (i > 0 && num[i - 1] >= num[i]) {
			i--;
		}
		if (i == 0) {
			Arrays.sort(num);
			return;
		} else {
			i1 = i - 1;
		}
		j = i1 + 1;
		while (j < num.length && num[i1] < num[j]) {
			j++;
		}
		i2 = j - 1;
		int temp = num[i1];
		num[i1] = num[i2];
		num[i2] = temp;
		Arrays.sort(num, i1 + 1, num.length);
	}

	private static void reverse(int start, int end, int[] nums) {

		int temp = 0;
		while (start < end) {
			temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	public static void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String args[]) {
		int[] numbers = { 1, 3, 5, 4, 2 };

		NextPermutation.nextPermutation(numbers);
		System.out.println(Arrays.toString(numbers));
		
		System.out.println("============================");
		int[] numbers2 = { 1, 3, 5, 4, 2 };

		NextPermutation.nextPermutation2(numbers2);
		System.out.println(Arrays.toString(numbers2));

		System.out.println("============================");
		/*int[] numbers3 = { 5,4,3,2,1 };

		NextPermutation.nextPermutation2(numbers3);
		System.out.println(Arrays.toString(numbers3));*/

		

	}

}