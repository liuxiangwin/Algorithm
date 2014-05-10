package com.liuxiangwin.Algorithm.question.test;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Stringproject {
	public static void main(String[] args) throws IOException {

		String s, f, t;
		int z = 0;

		//DataInputStream x = new DataInputStream(System.in);

		String[] a = { "fooo", "barr", "wing", "ding", "wing" };
		String m = Arrays.toString(a);

		char[] k = m.toCharArray();
		java.util.Arrays.sort(k);
		System.out.println("After Sort String "+Arrays.toString(k));
		t = process(k);
		System.out.println("After Sort process(k) T-- is "+t);
		System.out.println("Enter the string");
		
		s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";

		try {

			for (int i = 0; i <=s.length()-1; i++) {

				f = s.substring(i, i + t.length());
				char[] l = f.toCharArray();
				java.util.Arrays.sort(l);

				if (process(l).equalsIgnoreCase(t)) {
					z = 1;
				}
			}

		} catch (StringIndexOutOfBoundsException e) {
		}

		if (z > 0) {
			System.out.println("The given string is present at position");
		} else {
			System.out.println("The given string is not present");
		}

	}

	public static String process(char[] k) {
		StringBuffer n = new StringBuffer();
		for (int j = 0; j <= k.length - 1; j++) {
			if (Character.isLetter(k[j])) {
				n.append(k[j]);
			}
		}
		return n.toString();

	}

}
