package com.liuxiangwin.Algorithm.Array.test;

public class TestRevseNumber {

	/**
	 * @param args
	 */
	private static  int depth = 0;
	public static void main(String[] args) {
		
		System.out.println(reveseNumber(5709320));
		
		System.out.println(reveseNumberRecusively(5709320));
      
	}
	/**
	 * this is normal method
	 * @param number
	 * @return
	 */
	private static int reveseNumber(int number){
	int reversedNum = 0;
		while (number != 0) {
		    reversedNum = reversedNum * 10 + number % 10;
		    number = number / 10;   
		}
		return reversedNum;
	}
    /**
     * ReveseNumber through recursively method
     * @param number
     * @return
     */
	private static int reveseNumberRecusively(int number){		
		if(number < 1){
			return 0;
		}
		int lastNum = number % 10;
		number = (number - lastNum)/10;
		return reveseNumberRecusively(number) 
				+ (int)(lastNum * Math.pow(10,depth++));
		
	}
}
