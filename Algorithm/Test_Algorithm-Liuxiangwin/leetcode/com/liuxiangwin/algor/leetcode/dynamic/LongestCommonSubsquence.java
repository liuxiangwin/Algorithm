package com.liuxiangwin.algor.leetcode.dynamic;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LongestCommonSubsquence {
	
	public static <E> List<E> LongestCommonSubsequence(E[] s1, E[] s2)
	{
	        int[][] num = new int[s1.length+1][s2.length+1];  //2D array, initialized to 0
	 
	        //Actual algorithm
	        for (int i = 1; i <= s1.length; i++)
	                for (int j = 1; j <= s2.length; j++)
	                        if (s1[i-1].equals(s2[j-1]))
	                                num[i][j] = 1 + num[i-1][j-1];
	                        else
	                                num[i][j] = Math.max(num[i-1][j], num[i][j-1]);
	 
	        System.out.println("length of LCS = " + num[s1.length][s2.length]);
	 
	        int s1position = s1.length, s2position = s2.length;
	        List<E> result = new LinkedList<E>();
	 
	        while (s1position != 0 && s2position != 0)
	        {
	                if (s1[s1position - 1].equals(s2[s2position - 1]))
	                {
	                        result.add(s1[s1position - 1]);
	                        s1position--;
	                        s2position--;
	                }
	                else if (num[s1position][s2position - 1] >= num[s1position][s2position])
	                {
	                        s2position--;
	                }
	                else
	                {
	                        s1position--;
	                }
	        }
	        Collections.reverse(result);
	        return result;
	}
	

	private static void longestCommonSubsquence(String x ,String y){		
	        int M = x.length();
	        int N = y.length();

	        // opt[i][j] = length of LCS of x[i..M] and y[j..N]
	        int[][] opt = new int[M+1][N+1];

	        // compute length of LCS and all subproblems via dynamic programming
	        for (int i = M-1; i >= 0; i--) {
	            for (int j = N-1; j >= 0; j--) {
	                if (x.charAt(i) == y.charAt(j))
	                    opt[i][j] = opt[i+1][j+1] + 1;
	                else 
	                    opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
	            }
	        }

	        // recover LCS itself and print it to standard output
	        int i = 0, j = 0;
	        while(i < M && j < N) {
	            if (x.charAt(i) == y.charAt(j)) {
	                System.out.print(x.charAt(i));
	                i++;
	                j++;
	            }
	            else if (opt[i+1][j] >= opt[i][j+1]) i++;
	            else                                 j++;
	        }
	        System.out.println();

	    }

	public static void main(String[] args) {}
       
}
