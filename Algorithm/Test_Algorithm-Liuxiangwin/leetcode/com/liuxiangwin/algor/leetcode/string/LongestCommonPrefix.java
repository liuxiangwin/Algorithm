package com.liuxiangwin.algor.leetcode.string;



/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 */

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		int index = 0;
		while (index < strs[0].length()) {//取第一个字符串作为基准
			char c = strs[0].charAt(index);//index 用来索引第一个字符
			for (int i = 1; i < strs.length; ++i) {//遍历的string数组
				if (index >= strs[i].length() 
				|| strs[i].charAt(index) != c) {
					return strs[0].substring(0, index);
				}
			}
			index++;//只有遍历每次string数组完了才会index++ 第一个字符的每个字符
		}
		return strs[0];
	}
	
	public static void main(String[] args) {
		String[] strs = { "abc", "acd", "ade" };

		LongestCommonPrefix slt = new LongestCommonPrefix();
		System.out.println(slt.longestCommonPrefix(strs));
	}
}