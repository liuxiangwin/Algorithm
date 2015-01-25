package com.liuxiangwin.algor.leetcode.combination.permutation;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers.
 * 
 * Elements in a combination (a1, a2, ... , ak) must be in non-descending order.
 * (ie, a1 <= a2 <= ... <= ak).
 * 
 * The solution set must not contain duplicate combinations. For example, given
 * candidate set 2,3,6,7 and target 7, A solution set is: [7] [2, 2, 3]
 */

public class CombinationSum {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		Arrays.sort(candidates);
		int start =0; int sum =0;
		combinationSum(candidates, start, sum, target, ret, list);
		return ret;
	}

	private void combinationSum(int[] nums, int start, int sum,//sum ³õÊ¼ÊÇ0
			int target, ArrayList<ArrayList<Integer>> ret,
			ArrayList<Integer> list) {
		if (sum == target) {
			ret.add(new ArrayList<Integer>(list));
			return;
		}
		if (sum > target)
			return;
		for (int i = start; i < nums.length; i++) {
			list.add(nums[i]);
			combinationSum(nums, i, sum + nums[i], target, ret, list);
			list.remove(list.size() - 1);
		}
	}
	
	
	public static void main(String args[])
	{
		int[] nums ={10,1,2,7,6,1,5 };
		int target = 8;
		System.out.println(new CombinationSum().combinationSum(nums, target));
		
	}
}