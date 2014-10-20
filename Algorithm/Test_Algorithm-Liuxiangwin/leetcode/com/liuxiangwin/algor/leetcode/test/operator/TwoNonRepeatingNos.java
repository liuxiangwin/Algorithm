package com.liuxiangwin.algor.leetcode.test.operator;

public class TwoNonRepeatingNos {
	
	public void get2NonRepeatingNos(int arr[])
	{
      int x ,y,xor =0; 
      int set_bit_no =0;
	  /* Get the xor of all elements */
	  for(int i = 1; i < arr.length; i++)
	  {
		  xor ^= arr[i];
	  }		  
	  System.out.println(Integer.toBinaryString(xor));//1100 --> 12
	  
	  System.out.println(Integer.toBinaryString((xor-1)));
	 
	  /* Get the rightmost set bit in set_bit_no */  
	  set_bit_no = xor & ~(xor-1); 
	  
	  
	  System.out.println(Integer.toBinaryString(set_bit_no));
	 
	  /* Now divide elements in two sets by comparing rightmost set
	   bit of xor with bit at same position in each element. */
	 /* for(int i = 0; i < arr.length; i++)
	  {
		 if(arr[i] & set_bit_no)  
	    {
	    	x = x ^ arr[i]; //XOR of first set 	
	    }	     
	    else
	    {
	    	y = y ^ arr[i]; //XOR of second set	
	    }
	     
	  }*/
	}
   public static void main(String args[])
   {
	   int[] arry= {2, 4, 7, 9, 2, 4}; 
	   TwoNonRepeatingNos nonRepeatingNos = new TwoNonRepeatingNos();
	   nonRepeatingNos.get2NonRepeatingNos(arry);
   
   }
}

