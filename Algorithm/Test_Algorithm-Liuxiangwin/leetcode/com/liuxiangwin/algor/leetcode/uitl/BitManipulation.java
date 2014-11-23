package com.liuxiangwin.algor.leetcode.uitl;

public class BitManipulation {
	

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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
