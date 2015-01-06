package com.liuxiangwin.Algorithm.Array.test;

import java.util.LinkedList;

public class TestFindRadomNumber {
	private static LinkedList<Integer> list = new LinkedList<Integer>();  
	/** 
	 *  ���˼·�� 
	 *  1.�����жϣ����n>m,��n�д���m���������ܲ�����ϣ���ʱ��n=m�� 
	 *  2.��������n������n==m������������������� 
	 *  3.��n�����������⣺nû�м��룬ȡn=n-1,m=m,�ݹ飻 
	 *  4.n���룬ȡn=n-1,m=m-n,�ݹ顣 
	 *  5.������ 
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
	            findSum(sum - range, range - 1);// n���룬ȡn=n-1,m=m-n   
	            list.pop();  
	            findSum(sum, range - 1);    // nû�м��룬ȡn=n-1,m=m   
	        }  
	        else  
	        {  
	            System.out.print("The sum is "+sum);  //  sum < n ,ֱ�����n�Ϳ���������   
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
