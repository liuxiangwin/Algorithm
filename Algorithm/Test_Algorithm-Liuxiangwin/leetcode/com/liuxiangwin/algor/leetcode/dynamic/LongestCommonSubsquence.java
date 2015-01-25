package com.liuxiangwin.algor.leetcode.dynamic;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LongestCommonSubsquence {
	/**
	 * 
	 * 
	 *  *          |     B   D   C   A   B  
	------------------------------------------------
			       | 0   0   0   0   0   0  
	      ------------------------------------------
	          A    | 0   0   0   0   1 < 1  
	      ------------------------------------------
	          B    | 0  (^1) <1  <1   1  ^2  
	      ------------------------------------------
	          C    | 0   1   1  (^2)  2  2  
	      ------------------------------------------
	          B    | 0  (^1) 1   2    2 (^3) 
	      ------------------------------------------

	 * 
	 * 
	 * @param X
	 * @param Y
	 * @return
	 */
	
	
	
	public static <E> List<E> LongestCommonSubsequence(E[] X, E[] Y) 
	{
		int[][] num = new int[X.length + 1][Y.length + 1]; // 2D array,
															// initialized to 0
		// Actual algorithm
		for (int i = 1; i <= X.length; i++) {
			for (int j = 1; j <= Y.length; j++) {
				if (X[i - 1].equals(Y[j - 1])) {
					num[i][j] = 1 + num[i - 1][j - 1];
				}
				else {
					num[i][j] = Math.max(num[i - 1][j], num[i][j - 1]);
				}
			}
		}

		System.out.println("length of LCS = " + num[X.length][Y.length]);

		int xpos = X.length, ypos = Y.length;
		List<E> result = new LinkedList<E>();
	
		while (xpos != 0 && ypos != 0) {
			if (X[xpos - 1].equals(Y[ypos - 1])) {
				result.add(X[xpos - 1]);
				xpos--;
				ypos--;
			} else if (num[xpos][ypos - 1] >= num[xpos][ypos]) {
				ypos--; // 那边大那边坐标就--
			} else {
				xpos--;
			}
		}
		Collections.reverse(result);
		return result;
	}
	

	private static void longestCommonSubsquence(String X ,String Y){		

	        // opt[i][j] = length of LCS of x[i..M] and y[j..N]
	        int[][] opt = new int[X.length()+1][Y.length()+1];

	        // compute length of LCS and all subproblems 
	        //via dynamic programming
	        for (int i = X.length()-1; i >= 0; i--) {
	            for (int j = Y.length()-1; j >= 0; j--) {
	                if (X.charAt(i) == Y.charAt(j))
	                    opt[i][j] = opt[i+1][j+1] + 1;
	                else 
	                    opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
	            }
	        }

	        // recover LCS itself and print it to standard output
	        int i = 0, j = 0;
		while (i < X.length() && j < Y.length()) {
			if (X.charAt(i) == Y.charAt(j)) {
				System.out.print(X.charAt(i));
				i++;
				j++;
			} else if (opt[i + 1][j] >= opt[i][j + 1]) {
				i++;
			} else {
				j++;
			}
		}
	        System.out.println();

	    }

	public static void main(String[] args) {}
       
}
