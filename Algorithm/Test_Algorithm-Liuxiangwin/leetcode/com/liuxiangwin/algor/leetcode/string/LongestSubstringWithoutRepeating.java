package com.liuxiangwin.algor.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;

// Analysis: http://blog.csdn.net/lilong_dream/article/details/19431417

// Given a string, find the length of the longest substring without repeating characters. 
// For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
// For "bbbbb" the longest substring is "b", with the length of 1.

//Two Pointers
public class LongestSubstringWithoutRepeating {
    private static String result ="";
	//ababcc
	public int lengthOfLongestSubstring(String s) {
		int start, i, maxx = 0;
		boolean sign[] = new boolean[256];
		for (start = 0, i = 0; i < s.length(); i++) {
			while (sign[s.charAt(i)]) {
				sign[s.charAt(i)] = false;
				++start;
			}
			sign[s.charAt(i)] = true;
			
			maxx = Math.max(maxx, i - start + 1);
			result =  s.substring(start);
		}
		return maxx;
	}

	private int getLongestConsecutiveSubString(String str, int currentPos,
			int count, int maxLength) {
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
		
		
 		int len2 = slt.lengthOfLongestSubstring("abcabd");
 		
 		System.out.println(len2 +" "+ LongestSubstringWithoutRepeating.result);
 		
		int len3 = slt.lengthOfLongestSubstring("bbbbb");

		
		
		System.out.println(len3);
		
		
		System.out.println(slt.GetResult("abcabd"));
		System.out.println(slt.GetResult("bbbbb"));

	}
}
