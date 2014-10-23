package com.liuxiangwin.algor.leetcode.string;

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

	private void addPalindrome(String string, int start,
			ArrayList<String> partition, ArrayList<ArrayList<String>> result) {
		// stop condition
		if (start == string.length()) {
			ArrayList<String> temp = new ArrayList<String>(partition);
			result.add(temp);
			return;
		}

		for (int i = start + 1; i <= string.length(); i++) {
			String str = string.substring(start, i);
			if (isPalindrome(str)) {
				partition.add(str);
				addPalindrome(string, i, partition, result);
				partition.remove(partition.size() - 1);
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
