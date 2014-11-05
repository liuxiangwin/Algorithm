package com.liuxiangwin.algor.leetcode.string;

public class MoveStarWithString {

	private char[] moveStar(char[] s) {
		if (s.length < 0)
			return null;
		int starCount = 0;
		for (int i = s.length - 1; i >= 0; --i) {
			if (s[i] == '*') {
				++starCount;
			} else if (starCount > 0) {
				s[i + starCount] = s[i];
			}
		}
		for (int i = 0; i < starCount; ++i) {
			s[i] = '*';
		}
		return s;
	}

	public static void main(String[] args) {
		char[] s = "AB*C*D".toCharArray();
		MoveStarWithString withString = new MoveStarWithString();
		char[] result = withString.moveStar(s);
		System.out.println(String.valueOf(result));

	}
}
