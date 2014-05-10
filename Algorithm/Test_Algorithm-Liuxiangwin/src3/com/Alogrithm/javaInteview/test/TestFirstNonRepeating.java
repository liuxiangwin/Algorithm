package com.Alogrithm.javaInteview.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TestFirstNonRepeating {
	public Character firstNonRepeating(String s) {
		char[] strChars = s.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		Queue<Character> queue = new LinkedList<Character>();
		for (int i = 0; i < strChars.length; i++) {
			if (map.containsKey(strChars[i])) {
				map.put(strChars[i], map.get(strChars[i]) + 1);
			} else {
				map.put(strChars[i], 1);
				queue.add(strChars[i]);
			}
		}
		while (!queue.isEmpty()) {
			char firstUnique = queue.poll();
			if (map.get(firstUnique) == 1) {
				return firstUnique;
			}
		}
		return null;

	}
}
