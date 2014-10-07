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
		System.out.println(xorString(duplicateString));
	}

	// "eeeeeaaaff" 压缩为 "e5a3f2"，请编程实现。
	private static String compressString(String string) {
		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
		StringBuilder stringBuild = new StringBuilder();
		for (int i = 0; i < string.length(); i++) {
			String stringCurrent = String.valueOf(string.charAt(i));
			if (map.containsKey(stringCurrent)) {
				map.put(stringCurrent, map.get(stringCurrent) + 1);
			} else {
				map.put(stringCurrent, 1);
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
	
	private static char xorString(String string) {
		char[] array = string.toCharArray();
		char result = 0;
		for(char element: array)
		{
			result ^= element;	
		}
		
		return result;
	}

}
