package com.liuxiangwin.Algorithm.Array.test;

import java.util.LinkedList;

public class TestFindRadomNumber {
	private static LinkedList<Integer> list = new LinkedList<Integer>();  
	/** 
	 *  求解思路： 
	 *  1.首先判断，如果n>m,则n中大于m的数不可能参与组合，此时置n=m； 
	 *  2.将最大的数n加入且n==m，则满足条件，输出； 
	 *  3.将n分两种情况求解：n没有加入，取n=n-1,m=m,递归； 
	 *  4.n加入，取n=n-1,m=m-n,递归。 
	 *  5.结束。 
	 * @param sum 
	 * @param range 
	 */  
	    public static void findSum(int sum, int range)  
	    {  
	        if ( range < 1 || sum < 1)  
	            return;  
	        if (sum > range)  
	        {  
	            list.add(range);  
	            findSum(sum - range, range - 1);// n加入，取n=n-1,m=m-n   
	            list.pop();  
	            findSum(sum, range - 1);    // n没有加入，取n=n-1,m=m   
	        }  
	        else  
	        {  
	            System.out.print("The sum is "+sum);  //  sum < n ,直接输出n就可以满足了   
	            for (int i = 0; i < list.size(); i ++)  
	                System.out.print("  "+ list.get(i));  
	            System.out.println();  
	        }  
	    }  
	    /** 
	     * @param args 
	     */  
	    public static void main(String[] args) {  
	        // TODO Auto-generated method stub   
	        int sum = 10; 
	        
	        //int sum = 4;  
	        int range = 9;  
	        findSum(sum,range);  
	    }  


}
