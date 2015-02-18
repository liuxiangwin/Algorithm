package com.liuxiangwin.algor.leetcode.combination.permutation;

import java.util.ArrayList;
import java.util.Arrays;

import com.liuxiangwin.algor.leetcode.combination.permutation.Combinations;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note: Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets. For example, If S = [1,2,3], a solution
 * is:
 * 
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 */

public class SubsetsAndSubsetsII {

	public static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (nums.length == 0 || nums == null) {
			return result;
		}
		Arrays.sort(nums);

		dfs(nums, 0, list, result);
		// res.add(new ArrayList<Integer>());

		return result;
	}

	public static void dfs(int[] nums, int begin, ArrayList<Integer> list,
			ArrayList<ArrayList<Integer>> result) {
		for (int i = begin; i < nums.length; i++) {
			list.add(nums[i]);
			result.add(new ArrayList<Integer>(list));
			dfs(nums, i + 1, list, result);
			list.remove(list.size() - 1);
		}

	}
	
	
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums);
		result.add(list);
		dfs_dup(nums,0,result,list);
		return result;
	}

	public static void dfs_dup(int[] nums, int begin,
			ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list) {
		
		for (int i = begin; i <= nums.length - 1; i++) {
			list.add(nums[i]);
			result.add(new ArrayList<Integer>(list));
			dfs_dup(nums, i + 1, result, list);
			list.remove(list.size() - 1);
			while (i < nums.length - 1 && nums[i] == nums[i + 1])
				i++; // 唯一的区别就在这一行
		}
	}
	
	
	public static void main(String args[]) {
		int[] nums = { 1, 2, 3 };
		System.out.println(SubsetsAndSubsetsII.subsets(nums));
		
		int[] nums2 = { 1, 2, 2 };
		// [2],  [1],  [1,2,2],	  [2,2],  [1,2],  []				  
		System.out.println(SubsetsAndSubsetsII.subsetsWithDup(nums2));

	}
}