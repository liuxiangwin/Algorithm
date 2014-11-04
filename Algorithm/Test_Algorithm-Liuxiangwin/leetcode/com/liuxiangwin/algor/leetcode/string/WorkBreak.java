package com.liuxiangwin.algor.leetcode.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WorkBreak {
	/**
	 * s = "leetcode", dict = ["leet", "code"].
	 * 
	 * Return true because "leetcode" can be segmented as "leet code"
	 * 
	 * @param string
	 * @return
	 */
	public boolean wordBreak(String string, Set<String> dict) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = string.length() - 1; i >= 0; i--) {
			String sub = string.substring(i);
			if (dict.contains(sub)) {
				list.add(i);
			} else {
				for (Integer index : list) {
					sub = string.substring(i, index);
					if (dict.contains(sub)) {
						list.add(i);
						break;
					}
				}
			}
		}
		if (list.isEmpty()) {
			return false;
		} else {
			Integer index = list.get(list.size() - 1);
			return index == 0;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
