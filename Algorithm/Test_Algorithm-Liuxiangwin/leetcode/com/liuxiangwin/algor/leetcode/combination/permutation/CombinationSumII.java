package com.liuxiangwin.algor.leetcode.combination.permutation;
/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers.
 * 
 * Elements in a combination (a1, a2, �?, ak) must be in non-descending order. (ie, a1 �?a2 �?�?�?ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 */

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSumII {
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] nums,
			int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums);
		int start = 0;
		dfs(res, start, nums, list, target);
		return res;
	}

	private void dfs(ArrayList<ArrayList<Integer>> res, int start,
			int[] nums, ArrayList<Integer> list, int target) {
		if (target == 0) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		int pre = -1;
		for (int i = start; i < nums.length; i++) {
			if (pre == nums[i]){
				continue;
			}				
			if (nums[i] > target){
				return;
			}				
			pre = nums[i];
			list.add(nums[i]);
			dfs(res, i + 1, nums, list, target - nums[i]);
			list.remove(list.size() - 1);
		}
	}
}
