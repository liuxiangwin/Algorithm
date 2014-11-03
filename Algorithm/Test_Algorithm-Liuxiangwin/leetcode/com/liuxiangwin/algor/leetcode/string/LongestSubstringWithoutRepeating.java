package com.liuxiangwin.algor.leetcode.string;

import java.util.HashMap;

// Analysis: http://blog.csdn.net/lilong_dream/article/details/19431417

// Given a string, find the length of the longest substring without repeating characters. 
// For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
// For "bbbbb" the longest substring is "b", with the length of 1.

public class LongestSubstringWithoutRepeating {

	public static int lengthOfLongestSubstring2(String s) {

		char[] arr = s.toCharArray();
		int pre = 0;

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], i);
			} else {
				pre = pre > map.size() ? pre : map.size();
				i = map.get(arr[i]);
				map.clear();
			}
		}

		return Math.max(pre, map.size());
	}

	private int getLongestConsecutiveSubString(String str, 
			int currentPos,	int count, int maxLength) {
		if (currentPos == str.length()) {
			return maxLength;
		}
		if (str.charAt(currentPos) == str.charAt(currentPos - 1)) {
			count++;
			if (count > maxLength)
				maxLength = count;
		} else {
			count = 1;
		}
		return getLongestConsecutiveSubString(str, currentPos + 1, count,
				maxLength);
	}

	public int GetResult(String str) {
		if (str == null || str.isEmpty())
			return 0;
		if (str.length() == 1)
			return 1;
		return getLongestConsecutiveSubString(str, 1, 1, 1);
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeating slt = new LongestSubstringWithoutRepeating();
		int len2 = slt.lengthOfLongestSubstring2("ababcc");

		System.out.println(len2);

	}
}
