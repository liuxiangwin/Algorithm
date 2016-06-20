package com.liuxiangwin.algor.leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays {
   
	//For a HashSet, complexity is O(1) for all three.
	
	/**
    * Example:
	  Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
    * @param nums1
    * @param nums2
    * @return
    */
	public int[] intersection(int[] nums1, int[] nums2) {

		int len1 = nums1.length, len2 = nums2.length;

		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> interSet = new HashSet<Integer>();

		for (int i = 0; i < len1; i++) {
			set.add(nums1[i]);
		}

		for (int i = 0; i < len2; i++) {
			if (set.contains(nums2[i]))
				interSet.add(nums2[i]);
		}

		int[] ret = new int[interSet.size()];
		int cnt = 0;
		for (int num : interSet) {
			ret[cnt++] = num;
		}

		return ret;

	}

	/**
	 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
	 * 
	 * @param args
	 */

	public int[] intersect(int[] nums1, int[] nums2) {

		List<Integer> list = new ArrayList<Integer>();
		List<Integer> interList = new ArrayList<Integer>();

		for (int num : nums1) {
			list.add(num);
		}

		for (int i = 0; i < nums2.length; i++) {
			if (list.contains(nums2[i])) {
				interList.add(nums2[i]);
				list.remove(list.indexOf(nums2[i]));
			}
		}

		int[] ret = new int[interList.size()];
		int cnt = 0;
		for (int num : interList) {
			ret[cnt++] = num;
		}

		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
