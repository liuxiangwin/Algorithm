package com.liuxiangwin.algor.leetcode.string;

public class StringisSame {

	public static boolean isSameAfterPermutation(char[] s1, char[] s2) {
		if(s1.length!=s2.length){
			return false;
		}		
		int hash[] = new int[256];

		for (int i = 0; i < s1.length; i++) {
			hash[s1[i]]++;
		}

		for (char c : s2) {
			hash[c]--;
			if (hash[c] < 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		StringisSame stringisSame = new StringisSame();
	    boolean result = stringisSame.isSameAfterPermutation("God".toCharArray(), "doG".toCharArray());
	    System.out.println(result);
	    
	    boolean result2 = stringisSame.isSameAfterPermutation("Good".toCharArray(), "dood".toCharArray());
	    System.out.println(result2);
	}

}
