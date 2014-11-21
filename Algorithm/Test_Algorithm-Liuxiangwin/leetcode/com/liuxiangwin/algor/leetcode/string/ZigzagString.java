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
	private String convert(String s, int nRows){
	    if(nRows == 1) 
	    	return s;
	    String []res = new String[nRows];
	    int i = 0, j, gap = nRows-2;
	    while(i < s.length()){
	        for(j = 0; i < s.length() && j < nRows; ++j)
	        {
	        	res[j] += s.charAt(i++);	        			
	        }	        	
	        for(j = gap; i < s.length() && j > 0; --j) 
	        {
	        	res[j] += s.charAt(i++);
	        }
	        	
	    }
	    String str = "";
	    for(i = 0; i < nRows; ++i){
	    	str += res[i];
	    }
	        
	    return str;
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
				
	}

}
