package com.liuxiangwin.Algorithm.String.test;

import java.util.HashMap;
import java.util.Map;

public class TestStringisBrother {

	/**
	 * If string A and string B contain the same characters, 
	 * they are called "brother string".
	 * for example: "abc" and "cab", "aabb" and "baab".
	 * The question is how to check if two strings are 
	 *  brother string(fast)?
	 * 	
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isBrotherString("bab","adb"));
		
		System.out.println(isBrotherString("bab","bac"));

	}

	private static boolean isBrotherString(String string,String toCheckString) {
		if(string.length() != toCheckString.length())
		{
			return false;
		}
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < string.length(); i++) {
			int count = 0;
			String value = String.valueOf(string.charAt(i));
			if (map.containsKey(value)) {
				count = map.get(value);
				map.put(value, count + 1);
			} else {
				map.put(value, 1);
			}
		}
		
		
		int  checkCount=0;
		for (int j = 0; j < toCheckString.length(); j++) {
			String checkValue = String.valueOf(toCheckString.charAt(j));
			if (map.containsKey(checkValue)) {
				checkCount++;
			} 
		}
		return checkCount==toCheckString.length()?true:false;
	}

}
