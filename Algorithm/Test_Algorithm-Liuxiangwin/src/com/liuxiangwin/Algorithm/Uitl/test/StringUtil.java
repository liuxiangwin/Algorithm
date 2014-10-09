package com.liuxiangwin.Algorithm.Uitl.test;

import java.util.Scanner;

public class StringUtil {
	private static int[][] c;
	private static int n;
	private static char ss[];
	

	public String isPalindrome(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 
			&& s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}
	
	
	

	private static void init() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		ss = sc.next().toCharArray();
		c = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				c[i][j] = computeMatrixC(i, j);
			}
	}

	private static int getResult() {
		return c[0][n - 1];
	}

	/**
	 * c[i,j] = 0(when i >=j) c[i,j] = c[i + 1, j - 1](when a[i] == a[j]) c[i,j]
	 * = min(c[i,j - 1],c[i + 1,j]) + 1;
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	private static int computeMatrixC(int i, int j) {
		if (i >= j)
			return 0;
		else if (ss[i] == ss[j])
			return computeMatrixC(i + 1, j - 1);
		else
			return 1 + (computeMatrixC(i, j - 1) < computeMatrixC(i + 1, j) ? computeMatrixC(
					i, j - 1) : computeMatrixC(i + 1, j));
	}

	public static void main(String[] args) {
		init();
		System.out.println(getResult());
	}

}
