package com.liuxiangwin.algor.leetcode.memorydata;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FourBillionInteger {
	//http://stackoverflow.com/questions/7153659/find-an-integer-not-among-four-billion-given-ones
	//http://www.hawstein.com/posts/12.3.html
	//http://www.robbiehaoyan.com/category/ctci/
	/**
	 * My analysis:

The size of the file is 4 * 10^9(就是10亿==G) * 4 bytes = 16 GiB.

We can do external sorting, thus we get to know the range of the 
integers. My question is what is the best way to detect the missing
 integer in the sorted big integer sets?

My understanding(after reading all answers):

Assuming we are talking about 32-bit integers. 
There are 2^32 = 4*109= 4294967296 (42亿) distinct integers.

Case 1: we have 
 1 GiB = 1 * 10^9 bytes * 8 bits/byte = 8 billion(80亿) bits memory. 
Solution: if we use one bit representing one distinct integer,
 it is enough. we don't need sort. Implementation:
	 */
	
	//32位的指针可以拥有从0x00000000到0xFFFFFFFF
	//之间的任何一个值（其中一个F位4位，8个F位32位）。
	//这个范围化为十进制为429497296个值，大小正好为4GB
	
	int radix = 8;
	byte[] bitfield = new byte[0xffffffff/radix];
	private void F() throws FileNotFoundException{
	    Scanner in = new Scanner(new FileReader("a.txt"));
	    while(in.hasNextInt()){
	        int n = in.nextInt();
	        bitfield[n/radix] |= (1 << (n%radix));
	    }

	    for(int i = 0; i< bitfield.length; i++){
	        for(int j =0; j< radix; j++){
	            if( (bitfield[i] & (1<<j)) == 0)
	            	System.out.print(i*radix+j);
	        }
	    }
	}
}
