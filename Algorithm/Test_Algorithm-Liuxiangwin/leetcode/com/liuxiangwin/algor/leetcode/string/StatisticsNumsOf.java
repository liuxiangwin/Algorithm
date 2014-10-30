package com.liuxiangwin.algor.leetcode.string;

public class StatisticsNumsOf {
	
	private void statisticsNumsOfChar(char[] str)
	{
	    int i,j,len = str.length;
	    int a[] = new int[256];

	    for (i = 0;i < len;i++)
	    {
	        
	    	a[str[i]]++;
	    	//a[*(str+i)] ++;
	    }
	    for (j = 0;j < 256;j++)
	    {
	        if(a[j] > 0)
	        {
	            System.out.println(a[j]);
	        }
	    }

	}
	
	
	public static void main(String[] args) {
		new StatisticsNumsOf().statisticsNumsOfChar("AbcABca".toCharArray());

	}

}
