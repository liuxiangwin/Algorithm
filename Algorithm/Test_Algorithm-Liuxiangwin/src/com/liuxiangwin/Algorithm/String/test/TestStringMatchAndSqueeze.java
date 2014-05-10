package com.liuxiangwin.Algorithm.String.test;

public class TestStringMatchAndSqueeze {
    /**
     * Not clearly
     * @param args
     */
	public static void main(String args[]) {
		String  longString= "ThisAlan_LiuG";
		
		String pattern = "Alan_Liu";
		
		System.out.println(stringMatches(longString, pattern));
		System.out.println(removeBlank("a     te"));

	

	}

	public static int stringMatches(String longString, String patter) {
		int cnt = 0, patternLen = patter.length(), stringLen = longString.length();
		//char[] result=new char[]
		
		if (patternLen > stringLen)
			return 0;
		for (int str = 0; str < stringLen; str++) {
			int j;
			for (j = 0; j < patternLen; j++) {
				if (longString.charAt(str + j) != patter.charAt(j))
					break;
			}
			if (j == patter.length())
				cnt++;
		}
		return cnt;
	}

	public static String removeBlank(String s) {
		char[] a = s.toCharArray();
		int index = 0;
		//index is in order to control the not blank string
		for (int i = 0; i < a.length; i++) {
			// The index not add until not blank ++, a[index]is temporary store
			// /then not blank is will stored the real value
			a[index] = a[i];
			if (a[index] != ' ')
				index++;
			else if (a[index - 1] != ' ')
				index++;
		}
		return new String(a, 0, index);
	}

}
