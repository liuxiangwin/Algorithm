package com.liuxiangwin.algor.leetcode.dynamic;

public class DecodeWays {
	//http://blog.csdn.net/worldwindjp/article/details/19938131
	public int numDecodings(String string) {
		if (string == null || string.length() == 0)
			return 0;
		if (string.length() == 1) {
			if (string.equals("0")) {
				return 0;
			} else {
				return 1;
			}
		}
		if (string.length() == 2) {
			if (string.charAt(0) == '0')
				return 0;
			int value = Integer.parseInt(string);
			if (value == 10 || value == 20)
				return 1;
			if (value <= 26)
				return 2;
			if (value % 10 == 0)
				return 0;
			return 1;
		}

		int preV = numDecodings(string.substring(0, 2)) > 0 ? 1 : 0;
		return numDecodings(string.substring(0, 1))
				* numDecodings(string.substring(1, string.length())) + preV
				* numDecodings(string.substring(2, string.length()));
	}
	
	public int numDecodings2(String string) {
		if (string == null || string.length() == 0)
			return 0;
		int length = string.length();
		if (length < 1) {
			return 0;
		}
		int[] numarray = new int[length];
		int i = length - 1;
		numarray[i] = (string.charAt(i) == '0') ? 0 : 1;
		i--;
		while (i >= 0) {
			if (string.charAt(i) == '0')
				numarray[i] = 0;
			else if (string.charAt(i) == '1'
					|| (string.charAt(i) == '2' && string.charAt(i + 1) <= '6'))
				if (i == length - 2) {
					numarray[i] = numarray[i + 1] + 1;
				} else {
					numarray[i] = numarray[i + 1] + numarray[i + 2];
				}
			else
				numarray[i] = numarray[i + 1];
			i--;
		}
		return numarray[0];
	}

}
