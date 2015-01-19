package com.liuxiangwin.algor.leetcode.string;



/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 */

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strArray) {
		if (strArray.length == 0)
			return "";
		int index = 0;
		while (index < strArray[0].length()) {//ȡ��һ���ַ�����Ϊ��׼
			char c = strArray[0].charAt(index);//index ����������һ���ַ�
			for (int i = 1; i < strArray.length; ++i) {//������string����
				if (index >= strArray[i].length() 
				|| strArray[i].charAt(index) != c) {
					return strArray[0].substring(0, index);
				}
			}
			index++;//ֻ�б���ÿ��string�������˲Ż�index++ ��һ���ַ���ÿ���ַ�
		}
		return strArray[0];
	}
	
	public static void main(String[] args) {
		String[] strs = { "abc", "acd", "ade" };

		LongestCommonPrefix slt = new LongestCommonPrefix();
		System.out.println(slt.longestCommonPrefix(strs));
	}
}