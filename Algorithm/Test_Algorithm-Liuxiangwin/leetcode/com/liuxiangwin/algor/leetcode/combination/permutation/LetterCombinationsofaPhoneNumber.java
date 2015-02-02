package com.liuxiangwin.algor.leetcode.combination.permutation;


import java.util.ArrayList;

/**
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */

public class LetterCombinationsofaPhoneNumber {
	private char[][] map = new char[][] { 
			{ 'a', 'b', 'c' }, { 'd', 'e', 'f' },
			{ 'g', 'h', 'i' }, { 'j', 'k', 'l' },
			{ 'm', 'n', 'o' },{ 'p', 'q', 'r', 's' }, 
			{ 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

	public ArrayList<String> letterCombinations(String string) {
		ArrayList<String> ret = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		letterCombinations(string, 0, sb, ret);
		return ret;
	}

	private void letterCombinations(String string, int i, StringBuilder sb,
			ArrayList<String> result) {
		if (i >= string.length()) {
			result.add(sb.toString());
		} else {
			int index = string.charAt(i) - '1' - 1;
			int size = map[index].length;
			for (int j = 0; j < size; j++) {
				sb.append(map[index][j]);
				letterCombinations(string, i + 1, sb, result);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
	public static void main(String args[])
	{
	   System.out.println(new LetterCombinationsofaPhoneNumber().letterCombinations("23"));	
	}
}