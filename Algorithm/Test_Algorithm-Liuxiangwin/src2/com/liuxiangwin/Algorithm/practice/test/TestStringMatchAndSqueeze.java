package com.liuxiangwin.Algorithm.practice.test;

public class TestStringMatchAndSqueeze {

	public static void main(String args[]) {
		String pattern = "Alan_Liu";
		String string = "ThisAlan_LiuG";
		countMatches(pattern, string);
		System.out.println(squeezeBlank("a     te"));

	

	}

	static int countMatches(String p, String s) {
		int cnt = 0, pattern = p.length(), string = s.length();
		if (pattern > string)
			return 0;
		for (int i = 0; i < string; i++) {
			int j;
			for (j = 0; j < pattern; j++) {
				if (s.charAt(i + j) != p.charAt(j))
					break;
			}
			if (j == p.length())
				cnt++;
		}
		return cnt;
	}

	public static String squeezeBlank(String s) {
		char[] a = s.toCharArray();
		int index = 0;
		for (int i = 0; i < a.length; i++) {
			// The index not add until not blank ++, a[index]is temporary store
			// /then not blank is will stored the real value
			a[index] = a[i];
			if (a[index] != ' ')
				index++;
		
		}
		return new String(a, 0, index);
	}

}
