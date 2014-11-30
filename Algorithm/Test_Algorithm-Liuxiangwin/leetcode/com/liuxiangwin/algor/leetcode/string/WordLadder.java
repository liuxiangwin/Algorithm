package com.liuxiangwin.algor.leetcode.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (start and end), and a dictionary, find the length of
 * shortest transformation sequence from start to end, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary For example,
 * 
 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"]
 * 
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note:
 * 
 * Return 0 if there is no such transformation sequence. All words have the same
 * length. All words contain only lowercase alphabetic characters.
 */
//http://interactivepython.org/courselib/static/pythonds/Graphs/graphbfs.html
public class WordLadder {
	public static int ladderLength_BFS(String start, String end,
            HashSet<String> dict) {
        int result = 0;
        if (dict.size() == 0) {
            return result;
        }

        dict.add(start);
        dict.add(end);

        result = BFS(start, end, dict);

        return result;
    }


	private static int BFS(String start, String end, HashSet<String> dict) {
		
		Queue<String> queue = new LinkedList<String>();
		Queue<Integer> length = new LinkedList<Integer>();
		queue.add(start);
		length.add(1);

		while (!queue.isEmpty()) {
			String currWord = queue.poll();
			int len = length.poll();

			if (currWord.equals(end)) {// 表示到头了
					return len;
				}
				for (int i = 0; i < currWord.length(); i++) {
					char[] arr = currWord.toCharArray();
					for (char c = 'a'; c <= 'z'; c++) {
						if (c == arr[i])
							continue;

						arr[i] = c;
						String str = String.valueOf(arr);
						if (dict.contains(str)) {
							queue.add(str);
							length.add(len + 1);
							dict.remove(str);
						}
					}
				}
			}		
		return 0;
	}

	public static void main(String arg[]) {
		String start = "hit";
		String end = "cog";
		String[] dicts = { "hot", "dot", "dog", "lot", "log" };
		HashSet<String> dic = new HashSet<String>();
		
		for (String element : dicts) {
			dic.add(element);
		}

		WordLadder wordLadder = new WordLadder();	
		
		System.out.println(wordLadder.ladderLength_BFS(start, end, dic));

	}

}