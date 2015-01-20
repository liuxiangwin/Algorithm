package com.liuxiangwin.algor.leetcode.dynamic;

public class CuttingRod {
	/**
	 * length   | 1   2   3   4   5   6   7   8  
	--------------------------------------------
	   price    | 1   5   8   9  10  17  17  20
	   
	   
	 * @param args
	 */
	
	private int cutRod_bottomUp(int price[], int n) {
		int val[] = new int[n + 1];
		val[0] = 0;

		// Build the table val[] in bottom up manner
		// and return the last entry
		// from the table
		for (int j = 1; j <= n; j++) {
			int max_val = Integer.MIN_VALUE;
			;
			for (int i = 0; i < j; i++) {
				max_val = Math.max(max_val, price[i] + val[j - i - 1]);
			}
			val[j] = max_val;// record the value
		}
		return val[n];
	}
	
	
	private int cutRod(int price[], int n)
	{
	   if (n <= 0)
	     return 0;
	   int max_val = Integer.MIN_VALUE;
	 
	   // Recursively cut the rod in different pieces and compare different 
	   // configurations
	   //Let cutRoad(n) be the required (best possible price)
	   //value for a rod of lenght n. cutRod(n) 
	   //can be written as following.

      //cutRod(n) = max(price[i] + cutRod(n-i-1)) 
	   //for all i in {0, 1 .. n-1}
	   
	   for (int i = 0; i<n; i++){
	         max_val = Math.max
	        (max_val, price[i] + cutRod(price, n-i-1));
	   }
	   return max_val;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
