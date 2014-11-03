package com.liuxiangwin.algor.leetcode.operator;
// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/single-number/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/19556493

// Given an array of integers, every element appears twice except for one. Find that single one.
// Note:
// Your algorithm should have a linear runtime complexity. 
// Could you implement it without using extra memory?

//首先 回忆 异或操作，任意数字与自身相异或，结果都为0.
// 还有一个重要的性质，即任何元素与0相异或，结果都为元素自身
 
public class SingleNumber {
    public int singleNumber_once_other_twice(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int result = 0;
        
        for(int num : A) {
            result ^= num;
        }
        
        return result;
    }
    
    
    private void single_three_num(int [] s)  
    {  
        int hash[]=new int[10];  
        for (int i=0;i<s.length;i++) //M为数组的长度  
        {  
            int index=s[i]-0;//只考虑9以内的数字，所以，减去了0  
            hash[index]++;  
        }  
        for (int j=0;j<10;j++)  
        {  
            if (hash[j] ==1)  //表示出现一次
            {  
            	System.out.println("the 3 number once is "+j);  
            }  
        }  
    }
    
    //1-1000放在含有1001个元素的数组中，只有唯一的一个元素值重复，
     //其它均只出现一次．
     //每个数组元素只能访问一次，设计一个算法，将它找出来；
     //不用辅助存储空间，
     //首先 回忆 异或操作，任意数字与自身相异或，结果都为0.
     // 还有一个重要的性质，即任何元素与0相异或，结果都为元素自身
     //能否设计一个算法实现？
   private  void FindRepeat(int array[], int length)
    {
      int result = 0;
           for(int i=1;i<=1000;i++)
                  result ^=  i;
           for(int i=0;i<=1000;i++)
                  result ^=  array[i];
    }
    
    
    //找出数组中唯一出现一次的两个数字  要求时间复杂度是O(n)，空间复杂度是O(1)。
    //首先 回忆 异或操作，任意数字与自身相异或，结果都为0.
    // 还有一个重要的性质，即任何元素与0相异或，结果都为元素自身
   //http://blog.csdn.net/wangwh485/article/details/6715357
    public static void main(String[] args) {
		SingleNumber slt = new SingleNumber();
		int[] A = new int[] { 1, 2, 1, 2, 3, 4, 4 };
		//int[] A = new int[] { 1,1, 2, 1, 2, 4, 4,4 };
		System.out.println(slt.singleNumber_once_other_twice(A));
		
		//System.out.println(getBitByOrder(10, 1));
		//System.out.println(getBitByOrder(10, 2));
		//System.out.println(getBitByOrder(10, 3));
		
		int[] B = new int[] { 2,1,2,5,3,3,6,7,6};
		slt.single_three_num(B);
		
		
    }

	private static void xorOperation() {
		//XOr operation
		System.out.println(1^0^1);
		System.out.println(0^1);
		System.out.println(1^1);
	}

	private static void orOperation() {
		//Or operation 有1就是1
		System.out.println(1|0);
		System.out.println(0|1);
		System.out.println(1|1);
		System.out.println();
	}

	private static void andOperation() {
		//And operation 只有1 才是1
		System.out.println(1&1);
		System.out.println(0&1);
		System.out.println(0&0);
		System.out.println();
	}
    
    public static int getBitByOrder(int num, int i){
    	int result = num & (1<<i);
        return result;
    	
    }
}