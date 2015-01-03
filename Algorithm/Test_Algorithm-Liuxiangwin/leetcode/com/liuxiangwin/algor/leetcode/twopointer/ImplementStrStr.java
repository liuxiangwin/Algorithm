package com.liuxiangwin.algor.leetcode.twopointer;
// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 18, 2014
// Source:   http://oj.leetcode.com/problems/implement-strstr/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/23655843

// Implement strStr().
// Returns a pointer to the first occurrence of needle in haystack, 
// or null if needle is not part of haystack.

public class ImplementStrStr {
	public String strStr(String source, String target) {
		if (target != null && target.isEmpty()) {
			return source;
		}

		int sourceLeng = source.length();
		int targetLeng = target.length();
		if (sourceLeng < targetLeng) {
			return null;
		}

		for (int i = 0; i <= sourceLeng - targetLeng; ++i) {
			int j = 0;
			int k = i;//k每次都和 i一样，加一//j每次，只有匹配才进来
			while (j < targetLeng && 
			    source.charAt(k)== target.charAt(j)) {
				j++;
				k++;
			}

			if (j == targetLeng) {
				return source.substring(i);
			}
		}

		return null;
	}

	public static void main(String[] args) {
		ImplementStrStr slt = new ImplementStrStr();
		System.out.println(slt.strStr("abcdabc", "da"));
		System.out.println("abcdabc".substring("abcdabc".indexOf("d")));
	}
}