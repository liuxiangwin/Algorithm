package com.liuxiangwin.algor.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? 
 * 
 * Find all unique quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a <= b <= c <= d) The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 * A solution set is: (-1, 0, 0, 1) (-2, -1, 1, 2) (-2, 0, 0, 2)
 */
public class Four4Sum {		
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		Arrays.sort(num);
		//int i = 0;
		int j = 1;		
		Set set = new HashSet();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		
		if (num.length < 4)
			return res;

		for (int i = 0; i < num.length - 3; i++) {
			for (j = i + 1; j < num.length - 2; j++) {
				int left = target - (num[i] + num[j]);
				int start = j + 1;
				int end = num.length - 1;
				while (start < end) {
					if (num[start] + num[end] == left) {
						ArrayList<Integer> result = new ArrayList<Integer>();
						result.add(num[i]);
						result.add(num[j]);
						result.add(num[start]);
						result.add(num[end]);
						if (set.add(result))
							res.add(result);
						start++;
						end--;
					} else if (num[start] + num[end] < left) {
						start++;

					} else
						end--;
				}
			}
		}
		return res;
	}
	}
