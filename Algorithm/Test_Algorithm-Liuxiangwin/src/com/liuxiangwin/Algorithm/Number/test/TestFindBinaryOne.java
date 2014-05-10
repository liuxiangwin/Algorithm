package com.liuxiangwin.Algorithm.Number.test;

public class TestFindBinaryOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
       int output=count3(8283);;
       //System.out.println(output);
       int testNumber = 10;
       fun_1(testNumber);
       System.out.println("---");
       System.out.println("The binary zero in "+ testNumber+" is "+exchangeToBinary(10));
	}
	/**
	 * this is the simply one
	 * @param n
	 */
	private static int exchangeToBinary(int n) {
		int zeroNumber = 0;
		while (n != 0) {
			System.out.println(n % 2);// Could use DataStruce record each result
			if (n % 2 == 0) {
				zeroNumber++;
			}
			n = n / 2;// Keep the left to divide
		}
		return zeroNumber;
	}
	
	private static int fun_1(int n)
	{ 
	   
		
	   if(n<2)   
	      System.out.println(n);
	   if(n>=2)  
	   {
	     fun_1(n/2);
	     System.out.println(n%2);
	    
	   }
	   return 0;
	}
	

	

	

	public static int count1(int i) {
		int count = 0;
		while (i != 0) {
			count++;
			i = i & (i - 1);
		}
		return count;
	}

	public static int count2(int i) {
		int count = 0;
		while (i != 0) {
			count += i & 1;
			i = i >> 1;
		}
		return count;
	}

	public static int count3(int i) {
		int count = 0;
		while (i != 0) {
			count += i % 2;
			i = i / 2;
		}
		return count;

	}

}
