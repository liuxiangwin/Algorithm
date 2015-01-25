package com.liuxiangwin.algor.leetcode.combination.permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermuataionsII {

	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		permuteUnique(num, 0, result);
		return result;
	}

	private void permuteUnique(int[] num, int from,
			ArrayList<ArrayList<Integer>> result) {

		if (from >= num.length) {
			ArrayList<Integer> item = convertArrayToList(num);
			result.add(item);
		}

		for (int i = from; i <= num.length - 1; i++) {
			if (containsDuplicate(num, from, i)) {
				swap(num, from, i);
				permuteUnique(num, from + 1, result);
				swap(num, from, i);
			}
		}
	}

	private ArrayList<Integer> convertArrayToList(int[] num) {
		ArrayList<Integer> item = new ArrayList<Integer>();
		for (int h = 0; h < num.length; h++) {
			item.add(num[h]);
		}
		return item;
	}

	private boolean containsDuplicate(int[] arr, int from, int i) {
		for (int j = from; j <= i - 1; j++) {
			if (arr[j] == arr[i]) {
				return false;
			}
		}
		return true;
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	
	
	public static ArrayList<ArrayList<Integer>> permuteUnique2(int[] num) {
		ArrayList<ArrayList<Integer>> returnList = new ArrayList<ArrayList<Integer>>();
		returnList.add(new ArrayList<Integer>());
	 
		for (int i = 0; i < num.length; i++) {
			Set<ArrayList<Integer>> currentSet = new HashSet<ArrayList<Integer>>();
			for (List<Integer> l : returnList) {
				for (int j = 0; j < l.size() + 1; j++) {
					l.add(j, num[i]);
					ArrayList<Integer> T = new ArrayList<Integer>(l);
					l.remove(j);
					currentSet.add(T);
				}
			}
			returnList = new ArrayList<ArrayList<Integer>>(currentSet);
		}
	 
		return returnList;
	}
	
	
}
