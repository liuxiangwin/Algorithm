package com.liuxiangwin.algor.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordBreak {
	/**
	 * 
	 Given a string s and a dictionary of words dict, determine if s can be
	 * segmented into a space-separated sequence of one or more dictionary
	 * words. s = "leetcode", dict = ["leet", "code"].
	 * 
	 * Return true because "leetcode" can be segmented as "leet code"
	 * 
	 * @param string
	 * @return
	 */
	// http://www.danielbit.com/blog/puzzle/leetcode/leetcode-word-break
	public boolean wordBreak_navie(String string, Set<String> dict) {
		return wordBreakHelper(string, dict, 0);
	}

	public boolean wordBreakHelper(String string, Set<String> dictSet, int start) {
		if (start == string.length())
			return true;

		for (String dicword : dictSet) {
			int dicwordLeng = dicword.length();
			int end = start + dicwordLeng;

			// end index should be <= string length
			if (end > string.length())
				continue;

			if (string.substring(start, start + dicwordLeng).equals(dicword))
				if (wordBreakHelper(string, dictSet, start + dicwordLeng))
					return true;
		}

		return false;
	}

	// Time: O(string length * dict size)
	// One tricky part of this solution is the case:
	public boolean wordBreak2(String string, Set<String> dict) {
		boolean[] t = new boolean[string.length() + 1];
		t[0] = true; // set first to be true, why?
		// Because we need initial state

		for (int start = 0; start < string.length(); start++) {
			// should continue from match position
			if (!t[start])
				continue;

			for (String dicword : dict) {
				int dicwordLeng = dicword.length();
				int end = start + dicwordLeng;
				if (end > string.length())
					continue;

				if (t[end])
					continue;

				if (string.substring(start, end).equals(dicword)) {
					t[end] = true;
				}
			}
		}

		return t[string.length()];
	}

	// Time: O(string length * dict size)
	// One tricky part of this solution is the case:
	public boolean wordBreak(String s, Set<String> dict) {
		Map<String, Boolean> wordMap = new HashMap<String, Boolean>();
		for (String word : dict) {
			wordMap.put(word, true);
		}

		int len = s.length();
		boolean[] strMap = new boolean[len + 1];
		strMap[0] = true;
		// f(n) = f(0,i) + f(i,j) + f(j,n)
		for (int i = 1; i <= len; i++) {
			for (int j = 0; j < i; j++) {
				if (strMap[j] && wordMap.containsKey(s.substring(j, i))) {
					strMap[i] = true;// leetcode subString(1,4)leet
										// ËùÒÔstrMAP[4]=true
				}
			}
		}
		return strMap[len];
	}

	public static void main(String[] args) {
		String string = "leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		WordBreak workBreak = new WordBreak();
		workBreak.wordBreak(string, dict);
		workBreak.wordBreak(string, dict);
		workBreak.wordBreak2(string, dict);

		System.out.println("navie approach "
				+ workBreak.wordBreak_navie(string, dict));
	}

}
