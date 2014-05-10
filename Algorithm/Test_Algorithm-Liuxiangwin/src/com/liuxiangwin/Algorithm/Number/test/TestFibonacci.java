package com.liuxiangwin.Algorithm.Number.test;

import java.math.BigInteger;

public class TestFibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println("The fibonacci of"+i+" is " + fibonacci(i));
		}
	}
	
	private static int fibonacci(int number)
	{
		if(number<= 0)
		{
			return 0;
		}
		else if(number == 1)
		{
	        return 1;
		}
		else
		{
			return fibonacci(number-1)+fibonacci(number-2);
		}
		
	}
	
	/*
    * Java program to calculate Fibonacci number using loop or Iteration.
    * @return Fibonacci number // �ǵݹ��㷨
    * first 10 Fibonacci numbers are 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
    */
   public static int fibonacci2(int number){
       if(number == 1 || number == 2){
           return 1;
       }
       int fibo1=1, fibo2=1, fibonacci=1;
       for(int i= 3; i<= number; i++){
    	 //Fibonacci number is sum of previous two Fibonacci number
           fibonacci = fibo1 + fibo2; 
           fibo1 = fibo2;
           fibo2 = fibonacci;
         
       }
       return fibonacci; //Fibonacci number
   }
}
