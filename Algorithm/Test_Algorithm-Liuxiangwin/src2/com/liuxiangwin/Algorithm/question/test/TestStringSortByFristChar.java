package com.liuxiangwin.Algorithm.question.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

import com.liuxiangwin.util.CharSortedUtil;

public class TestStringSortByFristChar {
	public static void main(String[] args) {
		// checkString();

		String[] a = { "fooo", "barr", "wing", "ding", "wing" };
		String m = Arrays.toString(a);

		char[] k = m.toCharArray();
		System.out.println("Before Sort String " + Arrays.toString(k));

		CharSortedUtil.quickSortByAscending(k, 0, k.length - 1);

		System.out.println("After Sort String " + Arrays.toString(k));

		String[] strArray = { "Adam", "Martha", "Terry" };

		sortByFristChar(strArray);

	}

	private static void sortByFristChar(String[] strings) {
		char[] tmp = new char[strings.length];

		char[] charArray = { 'T', 'M', 'A' };

		String[] result = new String[strings.length];
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < strings.length; i++) {
			map.put(strings[i].substring(0, 1), strings[i]);
		}

		for (int i = 0; i < charArray.length; i++) {
			result[i] = map.get(String.valueOf(charArray[i]));
		}
		System.out.println("After Sub String " + Arrays.toString(tmp));
		System.out.println(Arrays.toString(result));

	}

	private static void checkString() {
		String[] A = { "apple", "banana", "mango", "potato", "apple" };
		String[] B = { "apple", "brinjal", "mango", "Raadish", "onion",
				"banana" };
		String[] temp = new String[10];
		Hashtable hash = new Hashtable();
		for (int i = 0; i < A.length; i++) {
			hash.put(i, A[i]);

		}
		int k = 0;
		for (int j = 0; j < B.length; j++) {
			if (hash.contains(B[j])) {
				temp[k] = B[j];
				k++;
			}
		}
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]);

		}
	}

}
