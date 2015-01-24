package com.liuxiangwin.algor.leetcode.dynamic;

public class CuttingRod {
	/**
	 * length   | 1   2   3   4   5   6   7   8  
	--------------------------------------------
	   price    | 1   5   8   9  10  17  17  20
	   
	   
	    i       | Ri          opt solution  
	--------------------------------------------
	    1       | 1           no cuts
	--------------------------------------------
	    2       | 5           no cuts
	--------------------------------------------
	    3       | 8           no cuts(可以是2+1=3 也就是1+5=6但不是最大的
	--------------------------------------------
	    4       | 10          2 ,2
	--------------------------------------------
	    5       | 13          2, 3
	--------------------------------------------
	    6       | 17          no cuts
	--------------------------------------------
	    7       | 18          1, 6    
	--------------------------------------------
	    8       | 22          2, 6    
	 * 
	 * 
	 * Optimal substructure
	 *       
	 *         S    
	----------------------------
	 * r= max(pn,r1+r(n-1)+...)
	 * 
	 */
	
	private int cutRod_bottomUp(int price[], int length) {
		int val[] = new int[length + 1];
		val[0] = 0;

		// Build the table val[] in bottom up manner
		// and return the last entry
		// from the table
		for (int j = 1; j <= length; j++) {
			int max_val = Integer.MIN_VALUE;		
			for (int i = 0; i < j; i++) {
				max_val = Math.max(max_val, price[i] + val[j - i - 1]);
			}
			val[j] = max_val;// record the value
		}
		return val[length];
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
	//http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
	
	//http://blog.csdn.net/ditian1027/article/details/25193841
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
