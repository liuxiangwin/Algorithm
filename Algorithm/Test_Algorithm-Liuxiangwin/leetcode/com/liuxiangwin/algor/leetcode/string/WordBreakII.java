package com.liuxiangwin.algor.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//  s = "catsanddog",
//  dict = ["cat", "cats", "and", "sand", "dog"].

//  A solution is ["cats and dog", "cat sand dog"].

public class WordBreakII {
	
    public List<String> wordBreak2(String string, Set<String> dict) {
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        
        //return findList(string, dict, map);
        return findList(string, dict);
    }
    private List<String> findList(String string,Set<String> dict){
    
    	
     //private List<String> findList(String string,Set<String> dict,Map<String, ArrayList<String>> map){ 	
   
    /*    if(map.containsKey(string)) 
        	return map.get(string);*/
        
        ArrayList<String> answerList = new ArrayList<String>();
        
        int length = string.length();
        if(length <= 0){
            return answerList;
        }
        for(int i = 1;i <= length;i++){
            String prefix = string.substring(0,i);
            if(dict.contains(prefix)){
                if(i == length)
                    answerList.add(prefix);
                else{                    
                    //List<String> temp = findList(string.substring(i), dict, map);
                	List<String> temp = findList(string.substring(i), dict);//截取后面的字符串
                    for(String tmp:temp){
                        tmp = prefix + " " + tmp;
                        answerList.add(tmp);
                    }
                }
            }
        }
        //map.put(string, answerList);
        return answerList;
    }
	
	
	
	public static void main(String[] args) {
		String string = "catsanddog";
		String[] dictString = {"cat", "cats", "and", "sand", "dog"};
		Set<String> dict = new HashSet<String>();   
		for(String value: dictString){
			dict.add(value);
		}
		
		WordBreakII breakII = new WordBreakII();
		List<String>  result = breakII.wordBreak2(string, dict);
		for(String  value:result)
		{
			System.out.println(value);
		}
		
	}

}
