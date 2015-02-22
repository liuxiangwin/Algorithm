package com.liuxiangwin.algor.leetcode.combination.permutation;

import java.util.ArrayList;

public class PalindromePartitioning {
	/**
	 * Return all possible palindrome partitioning of s.
	 * 
	 * For example, given s = "aab", Return
	 * 
	 * [ ["aa","b"], ["a","a","b"] ]
	 */

	public ArrayList<ArrayList<String>> partition(String string) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

		if (string == null || string.length() == 0) {
			return result;
		}

		ArrayList<String> partition = new ArrayList<String>();
		addPalindrome(string, 0, partition, result);

		return result;
	}

	private void addPalindrome(String string, int begin,
			ArrayList<String> list, ArrayList<ArrayList<String>> result) {
		// stop condition
		if (begin == string.length()) {
			ArrayList<String> temp = new ArrayList<String>(list);
			result.add(temp);
			return;
		}

		for (int i = begin + 1; i <= string.length(); i++) {
			String str = string.substring(begin, i);
			if (isPalindrome(str)) {
				list.add(str);
				addPalindrome(string, i, list, result);
				list.remove(list.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;

		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	public static void main(String args[])
	{
		PalindromePartitioning partitioning = new PalindromePartitioning();
	    partitioning.partition("aab");
	}
}
