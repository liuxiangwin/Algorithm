package com.liuxiangwin.algor.leetcode.combination.permutation;


import java.util.ArrayList;

/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n. For example, If n = 4 and k = 2, a solution is:
 * 
 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * 
 */

public class Combinations {
	/**
	 * Range is the number from 0 to range array
	 * DigitNums is the digit numbers
	 * @param range
	 * @param digitNums
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> combine(int range, int digitNums) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] nums = new int[range];
		for (int j = 0; j < range; j++) {
			nums[j] = j + 1;//根据范围构造数组
		}
		subsets(digitNums, nums, 0, list, result);
		return result;
	}

	private void subsets(int digitNums, int[] nums, 
			int begin,ArrayList<Integer> list, 
			ArrayList<ArrayList<Integer>> result) {
		if (list.size() == digitNums) {
			ArrayList<Integer> rec = new ArrayList<Integer>(list);
			result.add(rec);
		} else {
			for (int i = begin; i < nums.length; i++) {
				list.add(nums[i]);
				subsets(digitNums, nums, i + 1, list, result);
				list.remove(list.size() - 1);
			}
		}
	}
	public static void main(String args[])
	{
		 System.out.println(new Combinations().combine(4, 3));
		
	}
}