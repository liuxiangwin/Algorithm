package com.liuxiangwin.algor.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
	public boolean wordBreaks(String string, Set<String> dict) {
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
	//Time: O(string length * dict size)
    //One tricky part of this solution is the case:
	   public boolean wordBreak2(String string, Set<String> dict) {
	        boolean[] t = new boolean[string.length()+1];
	        t[0] = true; //set first to be true, why?
	        //Because we need initial state
	 
	        for(int i=0; i<string.length(); i++){
	            //should continue from match position
	            if(!t[i]) 
	                continue;
	 
	            for(String element: dict){
	                int len = element.length();
	                int end = i + len;
	                if(end > string.length())
	                    continue;
	 
	                if(t[end]) continue;
	 
	                if(string.substring(i, end).equals(element)){
	                    t[end] = true;
	                }
	            }
	        }
	 
	        return t[string.length()];
	    }
	
		public boolean wordBreak(String s, Set<String> dict) {
			Map<String, Boolean> wordMap = new HashMap<String, Boolean>();
			for (String w : dict) {
				wordMap.put(w, true);
			}
			int len = s.length();
			boolean[] strMap = new boolean[len + 1];
			strMap[0] = true;
			for (int i = 1; i <= len; i++) {
				for (int j = 0; j < i; j++) {
					if (strMap[j] && wordMap.containsKey(s.substring(j, i))) {
						strMap[i] = true;
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
		WorkBreak workBreak = new WorkBreak();
		workBreak.wordBreaks(string, dict);
		
		
		workBreak.wordBreak(string, dict);
	}

}
