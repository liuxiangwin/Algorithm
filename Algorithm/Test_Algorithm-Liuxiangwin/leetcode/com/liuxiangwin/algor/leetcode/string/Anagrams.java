package com.liuxiangwin.algor.leetcode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Anagrams {
	/**
	 * Given an array of strings, return all groups of strings that are
	 * anagrams. Note: All inputs will be in lower-case. For example:
	 * Input:����["tea","and","ate","eat","den"] Output: ["tea","ate","eat"]
	 * 
	 * @param args
	 */
	public List<String> anagrams(String[] strs) {
        HashMap<String, Integer> m = new HashMap<String, Integer>();
        
        LinkedList<String> result = new LinkedList<String>();
        for(int i=0; i<strs.length; i++){
            char[] word = strs[i].toCharArray();
            //sort it can easy to check they are anagrams or not
            Arrays.sort(word);
            if (!m.containsKey(String.valueOf(word))){
                m.put(String.valueOf(word), i);//����map������string���±�
            }else{
                if (m.get(String.valueOf(word))>=0){//ֻ�е�һ���ظ��ܽ��������������
                	//m.get(String.valueOf(word)ȡ���ǵ�һ��sting�������е�����
                	result.add(strs[m.get(String.valueOf(word))]);
                	m.put(String.valueOf(word), -1);
                }
                result.add(strs[i]);
            }
        }
        return result;
    }
    //Assuming there are k strings, 
	//and the average length of string is n, 
	//the complexity will be O(Knlogn).

	 

	public static void main(String[] args) {
	  String[] string = {"tea","and","ate","eat","den"};
	  Anagrams anagrams = new Anagrams();
	  System.out.println(anagrams.anagrams(string).toString()) ;
	}

}
