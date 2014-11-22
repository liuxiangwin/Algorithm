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
    
    //http://www.2cto.com/kf/201401/275860.html
    //Given an array of integers, 
    //every element appears three times except for one. Find that single one.
    
    public int singleNumberBitMap(int A[]) {
            int[] bitnum= new int[32];
            int res=0;
            for(int i=0; i< 32; i++){
                for(int j=0; j< A.length; j++){
                    bitnum[i]+= (A[j]>>i)&1;
                }
                res|=(bitnum[i]%3)<<i;
            }
            return res;
        }

    
    
    private int singleNumber(int A[], int n) {
        int ones = 0, twos = 0, threes = 0;
        for(int i = 0; i < n; i++)
        {
            threes = twos & A[i]; //已经出现两次并且再次出现
            twos = twos | ones & A[i]; //曾经出现两次的或者曾经出现一次但是再次出现的
            ones = ones | A[i]; //出现一次的
            
            twos = twos & ~threes; //当某一位出现三次后，我们就从出现两次中消除该位
            ones = ones & ~threes; //当某一位出现三次后，我们就从出现一次中消除该位
        }
        //每次循环先计算 twos，即出现两次的 1 的分布，然后计算出现一次的 1 的分布，接着 二者进行与操作得到出现三次的 1 的分布情况，
        //然后对 threes 取反，再与 ones、twos进行与操作，这样的目的是将出现了三次的位置清零。
      /*  for(int i=0; i<n; i++){
            two |= one&A[i];
            one^=A[i];
            //cout<<one<<endl;
            three=one&two;
            one&= ~three;
            two&= ~three;
        }*/
        
        
        return ones; //twos, threes最终都为0.ones是只出现一次的数
    }
    
    
    
    
    
    //1-1000放在含有1001个元素的数组中，只有唯一的一个元素值重复，
     //其它均只出现一次．
     //每个数组元素只能访问一次，设计一个算法，将它找出来；
     //不用辅助存储空间，
     //首先 回忆 异或操作，任意数字与自身相异或，结果都为0.
     // 还有一个重要的性质，即任何元素与0相异或，结果都为元素自身
     //能否设计一个算法实现？
	private int FindRepeat(int array[], int length) {
		int result = 0;
		for (int i = 0; i <= length-1; i++) {
			result ^= i;
		}
		for (int i = 0; i <= length-1; i++) {
			result ^= array[i];
		}
		return result;
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
		
		int[] C = new int[] { 6,7,5,3,3,10,11};
		int result = slt.FindRepeat(C,C.length);
		System.out.println("The twice number is "+result);
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
    
    //to to
    //http://blog.csdn.net/qdlovecsj/article/details/10183363
    //http://www.zhihu.com/question/19659409
}