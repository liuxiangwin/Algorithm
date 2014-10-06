package com.liuxiangwin.algor.leetcode.test.operator;
// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/single-number/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/19556493

// Given an array of integers, every element appears twice except for one. Find that single one.
// Note:
// Your algorithm should have a linear runtime complexity. 
// Could you implement it without using extra memory?
 
public class SingleNumber {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int result = 0;
        
        for(int num : A) {
            result ^= num;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
		SingleNumber slt = new SingleNumber();
		//int[] A = new int[] { 1, 2, 1, 2, 3, 4, 4 };
		int[] A = new int[] { 1,1, 2, 1, 2, 4, 4,4 };
		System.out.println(slt.singleNumber(A));
		
		System.out.println(getBitByOrder(10, 1));
		System.out.println(getBitByOrder(10, 2));
		System.out.println(getBitByOrder(10, 3));
		
    }

	private static void xorOperation() {
		//XOr operation
		System.out.println(1^0^1);
		System.out.println(0^1);
		System.out.println(1^1);
	}

	private static void orOperation() {
		//Or operation 有1就是1
		System.out.println(1|0);
		System.out.println(0|1);
		System.out.println(1|1);
		System.out.println();
	}

	private static void andOperation() {
		//And operation 只有1 才是1
		System.out.println(1&1);
		System.out.println(0&1);
		System.out.println(0&0);
		System.out.println();
	}
    
    public static int getBitByOrder(int num, int i){
    	int result = num & (1<<i);
        return result;
    	
    }
}