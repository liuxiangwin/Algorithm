package com.liuxiangwin.algor.leetcode.string;

public class StringisSame {

	public static boolean isSameAfterPermutation(char[] s1, char[] s2) {
		int hash[] = new int[256];

		for (int i = 0; i < s1.length; i++) {
			hash[s1[i]] = 1;
		}

		for (char c : s2) {
			if (hash[c] < 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		StringisSame stringisSame = new StringisSame();
	    boolean result = stringisSame.isSameAfterPermutation("God".toCharArray(), "dog".toCharArray());
	    System.out.println(result);
	}

}
