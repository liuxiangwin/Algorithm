package com.liuxiangwin.algor.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordBreak {
	/**
	 * s = "leetcode", dict = ["leet", "code"].
	 * 
	 * Return true because "leetcode" can be segmented as "leet code"
	 * 
	 * @param string
	 * @return
	 */
	//http://www.danielbit.com/blog/puzzle/leetcode/leetcode-word-break
	public boolean wordBreak_navie(String s, Set<String> dict) {
		return wordBreakHelper(s, dict, 0);
	}

	public boolean wordBreakHelper(String s, Set<String> dict, int start) {
		if (start == s.length())
			return true;

		for (String a : dict) {
			int len = a.length();
			int end = start + len;

			// end index should be <= string length
			if (end > s.length())
				continue;

			if (s.substring(start, start + len).equals(a))
				if (wordBreakHelper(s, dict, start + len))
					return true;
		}

		return false;
	}
	
	
	  public boolean wordBreak_dp(String s, Set<String> dict) {
	        boolean[] table = new boolean[s.length()+1];
	 
	        table[0] = true;
	        for (int i=1; i<s.length()+1; ++i)
	            for (int k=0; k<i; k++) {
	                table[i] = table[k] && dict.contains(s.substring(k,i));
	                if (table[i])
	                    break;
	            }
	 
	        return table[s.length()];
	    }
	
	
	 //Time: O(string length * dict size)
    //One tricky part of this solution is the case:
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
					strMap[i] = true;//leetcode subString(1,4)leet ËùÒÔstrMAP[4]=true
				}
			}
		}
		return strMap[len];
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
	   
	  

	public static void main(String[] args) {
		String string = "leetcode";
		Set<String> dict = new HashSet<String>();   
		dict.add("leet");
		dict.add("code");
		WordBreak workBreak = new WordBreak();
		workBreak.wordBreak(string, dict);	
		workBreak.wordBreak(string, dict);		
		workBreak.wordBreak2(string, dict);
		
		System.out.println("navie approach "+workBreak.wordBreak_navie(string,dict));
	}

}
