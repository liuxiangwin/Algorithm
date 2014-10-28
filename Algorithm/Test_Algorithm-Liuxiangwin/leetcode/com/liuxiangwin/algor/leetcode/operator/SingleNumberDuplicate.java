package com.liuxiangwin.algor.leetcode.operator;

public class SingleNumberDuplicate {
	
	  public int singleNumberDuplicate(int[] A) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int result = 0;
	        
	        for(int num : A) {
	            result ^= num;
	        }
	        
	        return ~result;
	    }
	  public static void main(String[] args) {
		  SingleNumberDuplicate slt = new SingleNumberDuplicate();
			int[] A = new int[] { 1, 2, 1, 3, 4, 5, 6 };
		System.out.println(slt.singleNumberDuplicate(A)); 
	  }
}
