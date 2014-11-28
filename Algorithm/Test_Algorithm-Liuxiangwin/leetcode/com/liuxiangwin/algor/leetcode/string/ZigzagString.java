package com.liuxiangwin.algor.leetcode.string;

public class ZigzagString {
	
	/**
	 * 
	Zigzag:即循环对角线结构（

0	 	 	 	8	 	 	 	16	 	 	 
1	 	 	7	9	 	 	15	17	 	 	 
2	 	6	 	10	 	14	 	18	 	 	 
3	5	 	 	11	13	 	 	19	 	 	 
4	 	 	 	12	 	 	 	20	 	 	 
） 
	 *  "012345678920"
	 * input "PAYPALISHIRING" expect  "PAYPALISHIRING"
	 */
	//http://www.cnblogs.com/sanghai/p/3632528.html
	public String convert(String s, int nRows)
	    {
			String []res = new String[nRows];
	        for(int i = 0;i<s.length();)
	        {
	            for(int j = 0;j<nRows && i < s.length(); i++,j++)
	            {
	            	res[j]+= s.charAt(i);
	            }
	            
	            for(int j = nRows-2;j>0&&i<s.length();i++,j--)
	            {
	            	res[j]+= s.charAt(i);
	            }
	            
	        }
	        String result = "";
		    for(int i = 0; i < nRows; ++i){
		    	result += res[i];
		    }
	        return result;
	    
	}
	
	
	public static void main(String[] args) {
		ZigzagString zigzagString = new ZigzagString();
	//	0	 	 	 	8	 	 	 	16	 	 	 
	//	1	 	 	7	9	 	 	15	17	 	 	 
	//	2	 	6	 	10	 	14	 	18	 	 	 
	//	3	5	 	 	11	13	 	 	19	 	 	 
	//	4	 	 	 	12	 	 	 	20	
		
		char[] array = {'0','1','2','3','4','5','6','7','8','9','I'};
		//String result = zigzagString.convert2("PAYPALISHIRING", 3);
		
		String result = zigzagString.convert(String.valueOf(array), 3);
		System.out.println(result);
		//n=4
		// P              I               N
		// A         L    S         I   G
		// Y   A          H    R               (index 一定是Rows-2也就是2行开始 )
		// P              I
		
		//
		//N=5
		//		P               H
		//		A          S  I
		//		Y      I       R
		//		P   L          I      G       (index 一定是Rows-2也就是3行开始 )
		//		A              N
		
		char[] array2 = {'P','A','Y','P','A','L','I','S','H','I','R','I','G','N'};
		String result2 = zigzagString.convert(String.valueOf(array2), 4);
		System.out.println(result2);
				
	}

}
