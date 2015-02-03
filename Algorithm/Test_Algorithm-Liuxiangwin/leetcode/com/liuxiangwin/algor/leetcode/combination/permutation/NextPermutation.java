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
	// STLֱ����next_permutation�ĺ������Ե��ã���˼��Ҳ�Ƚ�ֱ�ӡ���Ϊ��������������С�ģ����������������ģ�����һ�����У��Ӻ���ǰ�ҵ���һ����x����С�ں������ڵ����֣��ٴӺ���ǰ�ҵ���һ������y�������x������x��y��Ȼ���ԭ��x������������ã����ɵõ���һ�����С�

	// ����ԭ����Ϊ1 3 5 4 2���ҵ���һ����3��
	// ��С�ں��������5��Ȼ���ҵ���һ������4��'
	// �����3������3��4���õ�1 4 5 3 2��
	// Ȼ����תԭ��3��������֣���5 3 2���õ�1 4 2 3 5����Ϊ��һ�����С�

	public static void nextPermutation2(int[] num) {
		if (num.length == 1)
			return;

		int i = num.length - 2;
		while (i >= 0 && num[i] >= num[i + 1]) {
			i--; // �ҵ�һ������
		}
		if (i == -1) // ȫ�����������������
		{
			// reverse(num.begin(), num.end());
			reverse(0, num.length - 1, num);
			return;
		}

		int j = num.length - 1; // �ҵ�һ������num[i]��
		while (num[i] >= num[j]){
			j--;
		}			
		swap(i, j, num); // ����
		reverse(i + 1, num.length - 1, num); // ��ת

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