package com.liuxiangwin.algor.leetcode.string;

public class StatisticsNumsOf {
	
	private void statisticsNumsOfChar(char[] str)
	{
	    int i,j,len = str.length;
	    int a[] = new int[256];

	    for (i = 0;i < str.length;i++)
	    {        
	    	a[str[i]]+=1;
	    }
	    for (j = 0;j < 256;j++)
	    {
	        if(a[j] > 0)
	        {
	            System.out.println("the string "+Character.toString((char)j)+ " occuence is "+a[j]);
	        }
	    }

	}
	//s1 = "aabcc",
	//s2 = "dbbca",
 	//When s3 = "aadbbcbcac", return true.
	 //When s3 = "aadbbbaccc", return false.
	public boolean isInterleave(char[] str1, char[] str2, char[] str3) {
		int asci[] = new int[256];
		int asci2[] = new int[256];
		for (char c1 : str1) {
			asci[c1] += 1;
		}

		for (char c2 : str2) {
			asci[c2] += 1;
		}
		for (char c3 : str3) {
			asci2[c3] += 1;
		}
		
		 for (int j = 0;j < 256;j++)
		    {
		        if(asci[j] > 0)
		        {
		            System.out.println("combine string "+Character.toString((char)j)+ " occuence is "+asci[j]);
		        }
		    }
		 for (int j = 0;j < 256;j++)
		    {
		        if(asci2[j] > 0)
		        {
		            System.out.println("test string2 "+Character.toString((char)j)+ " occuence is "+asci2[j]);
		        }
		    }
		
		
		for (int j = 0; j < 256; j++) {
			if (asci[j] != asci2[j]) {
				return false;
			}
		}
		return true;
	}
	
	
	
	
	public static void main(String[] args) {
		new StatisticsNumsOf().statisticsNumsOfChar("AbcABca".toCharArray());
		System.out.println("============================");
		System.out.println("isInterleave "+new StatisticsNumsOf().isInterleave("aabcc".toCharArray(),"dbbca".toCharArray(),
				"aadbbcbcac".toCharArray()));
		
		System.out.println("isInterleave "+new StatisticsNumsOf().isInterleave("aabcc".toCharArray(),"dbbca".toCharArray(),
				"aadbbbaccc".toCharArray()));

	}

}
