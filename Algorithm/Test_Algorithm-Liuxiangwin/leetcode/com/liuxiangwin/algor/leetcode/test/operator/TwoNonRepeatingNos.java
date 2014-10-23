package com.liuxiangwin.algor.leetcode.test.operator;

public class TwoNonRepeatingNos {
	private static int x,y  =0; 
	public void get2NonRepeatingNos(int arr[])
	{
      int xor = arr[0];
	  
      int set_bit_no =0;
	  /* Get the xor of all elements */
	  for(int i = 1; i < arr.length; i++)
	  {
		  xor ^= arr[i];
	  }		  
	  System.out.println("xor binary :"+Integer.toBinaryString(xor)+"-- 10进制: "+ (xor));//1100 --> 12
	  
	  System.out.println("xor-1 :"+Integer.toBinaryString((xor-1))+"-- 10进制: "+ (xor-1));//1011
	  
	  System.out.println("~(xor-1) :"+Integer.toBinaryString(~(xor-1))+"-- 10进制: "+ ~(xor-1));//1011
	  
	  System.out.println("xor&~(xor-1) :"+Integer.toBinaryString(xor &~(xor-1))+"-- 10进制: "+ (xor&~(xor-1)));//1011
	 
	  /* Get the rightmost set bit in set_bit_no */  
	  set_bit_no = xor & ~(xor-1); 
	  
	  
	  
	  System.out.println(Integer.toBinaryString(set_bit_no));
	 
	  /* Now divide elements in two sets by comparing rightmost set
	   bit of xor with bit at same position in each element. */
	  for(int i = 0; i < arr.length; i++)
	  {
		 int temp= arr[i] & set_bit_no;
		 if(temp!=0)  
	    {
	    	x = x ^ arr[i]; //XOR of first set
	    	//System.out.println("x "+x);
	    }	     
		 else
		 {
			 y = y ^ arr[i]; //XOR of first set
		     //System.out.println("y "+x);
		 }		
	  }
	  System.out.println("x "+x); 
	 System.out.println("y "+y);
	}
	
	
	

	
	
   public static void main(String args[])
   {
	   //int[] arry= {2, 4, 7, 9, 2, 4}; 
	   
	   int arry[] = {2, 3, 7, 9, 11, 2, 3, 11};
	   TwoNonRepeatingNos nonRepeatingNos = new TwoNonRepeatingNos();
	   nonRepeatingNos.get2NonRepeatingNos(arry);
       
	   
	   System.out.println(Integer.toBinaryString(7));
	   System.out.println(Integer.toBinaryString(9));
   }
}

