package com.liuxiangwin.Algorithm.String.test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestStringCompress {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String LongString = "eeeeeaaaff";
		System.out.println(compressString(LongString));
		
		String duplicateString = "eeeeeaaff";
		
		System.out.println(compressBad(LongString));
		
	}

	// "eeeeeaaaff" 压缩为 "e5a3f2"，请编程实现。
	private static String compressString(String string) {
		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
		StringBuilder stringBuild = new StringBuilder();
		for (int i = 0; i < string.length(); i++) {
			String curr = String.valueOf(string.charAt(i));
			if (map.containsKey(curr)) {
				map.put(curr, map.get(curr) + 1);
			} else {
				map.put(curr, 1);
			}
		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			stringBuild.append(key);
			stringBuild.append(value);
		}
		return stringBuild.toString();
	}
	//O(stingLength+)
	public static String compressBad(String str) {		
		String mystr = "";
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				mystr += last + "" + count;
				last = str.charAt(i);
				count = 1;
			}
		}
		return mystr + last + count;
	}


}
