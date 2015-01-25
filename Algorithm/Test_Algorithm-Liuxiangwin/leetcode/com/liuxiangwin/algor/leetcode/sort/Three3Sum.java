package com.liuxiangwin.algor.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * 
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ? b ?
 * c) The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is: (-1, 0, 1) (-1, -1, 2)
 */
public class Three3Sum {

	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (num.length < 3)
			return result;
		// sort array
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			// //avoid duplicate solutions
			if (i == 0 || num[i] > num[i - 1]) {

				int negate = -num[i];

				int start = i + 1;
				int end = num.length - 1;

				while (start < end) {
					// case 1
					if (num[start] + num[end] == negate) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(num[i]);
						temp.add(num[start]);
						temp.add(num[end]);

						result.add(temp);
						start++;
						end--;
						// avoid duplicate solutions
						while (start < end && num[end] == num[end + 1])
							end--;

						while (start < end && num[start] == num[start - 1])
							start++;
						// case 2
					} else if (num[start] + num[end] < negate) {
						start++;
						// case 3
					} else {
						end--;
					}
				}

			}
		}

		return result;
	}

	public List<List<Integer>> threeSum_2(int[] num) {
		Arrays.sort(num);
		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		for (int i = 0; i < num.length - 2; i++) {
			int start = i + 1;
			int end = num.length - 1;
			while (start < end) {
				if (num[i] + num[start] + num[end] == 0) {
					LinkedList<Integer> oneResult = new LinkedList<Integer>();
					oneResult.add(num[i]);
					oneResult.add(num[start]);
					oneResult.add(num[end]);
					set.add(oneResult);
					start++;
					end--;
				} else {
					if (num[i] + num[start] + num[end] < 0)
						start++;
					else
						end--;
				}
			}
		}
		result.addAll(set);
		return result;
	}
	/**
	 *  For example, given array S = {-1 2 1 -4}, and target = 1.

       The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	
	 */
	public int threeSumClosest(int[] num, int target) {
		int closest = num[0] + num[1] + num[2];
		int diff = Math.abs(closest - target);
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			int start = i + 1;
			int end = num.length - 1;
			while (start < end) {
				int sum = num[i] + num[start] + num[end];
				int newDiff = Math.abs(sum - target);
				if (newDiff < diff) {
					diff = newDiff;
					closest = sum;
				}
				if (sum < target)
					start++;
				else
					end--;
			}
		}
		return closest;
	}

}
