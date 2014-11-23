package com.liuxiangwin.algor.leetcode.string;

public class StringRemoveByTarget {

	private char[] delete_ch(char[] src, char[] del_chs) {
		int[] hash = new int[256];
		int p_slow = 0;
		int p_fast = 0;
		int del_len = del_chs.length;
		
		for (int i = 0; i < del_len; i++) {
			hash[del_chs[i]] = 1;
		}
		while(p_fast<src.length)
		{
			if (hash[src[p_fast]] == 1) {
				p_fast++;
			}
			src[p_slow++] = src[p_fast++];
		}

		return src;
	}
	
	public static void main(String[] args) {
		StringRemoveByTarget testStringRemove = new StringRemoveByTarget();
				char src[] = "They are students".toCharArray();
		char del_chs[] = "haeiou".toCharArray();		
				
	char[] charDeleted = testStringRemove.delete_ch(src, del_chs);
	System.out.println(String.valueOf(charDeleted));
		
	
	}
}
