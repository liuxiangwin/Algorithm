package com.liuxiangwin.algor.leetcode.operator;

import java.util.Arrays;

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
        int result = 0;
        
        for(int num : A) {
            result ^= num;
        }
        
        return result;
    }
    
    
	public int[] twoNumber_once_other_twice(int[] A) {
		// Note: The Solution object is instantiated only once and is reused by
		int xorResult = 0;

		for (int num : A) {
			xorResult ^= num;
		}
		int bitNum = 0;
		while ((xorResult & 1) != 1)// 寻找第一个异或后为1的位置
		{
			xorResult >>= 1;
			++bitNum;//bitNum记录的是需要右移多少位出现1
		}

		int flag = (1 << bitNum);
		int res1 = 0;
		int res2 = 0;
		for (int num : A) {
			if ((num & flag) == 1) {//证明不同两个数中有一位相同那个
				res1 ^= num;// 如果4是有1那一位，就相当于不异或它了
			} else {
				res2 ^= num;
			}
		}

		return new int[] { res1, res2 };
	}
    
    
    private void single_three_num(int [] s) //只能求解10以内的数字 
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
            	System.out.println("the total 3 number once is "+j);  
            }  
        }  
    }
    private int single_three_num_not_in10(int [] s) //只能求解10以内的数字 
    {  
        int result =0;;  
        int xorResult = 0;

		for (int num : s) {
			xorResult ^= num;
		}
		int flips =0;
		for (int num : s) {
			flips ^= lowbit(num ^ xorResult);//三个数两两的异或后 lowbit有两个相同，一个不同，可以分为两组
			//// 表示的是：flips=lowbit(a^b)^lowbit(a^c)^lowbit(b^c) 
		}
		
		for (int num : s) {
			if(lowbit(xorResult ^ num) == flips)
			{
				result ^= num;
			}
				
		}
		return result;
    }
    
    
    //http://www.2cto.com/kf/201401/275860.html
    //Given an array of integers, 
    //every element appears three times except for one. Find that single one.
    
    public int singleNumberBitMap(int A[]) {
            int[] bitnum= new int[32];
            int res=0;
            for(int i=0; i< 32; i++){//i代表32位上的每一位
                for(int index = 0; index < A.length; index ++){
                    bitnum[i]+= (A[index ]>>i)&1;//数组中每个数在32位上的加和
                }
                res|=(bitnum[i]%3)<<i;
            }
            return res;
        }

    
    
    private int singleNumber_other_three(int A[], int n) {
        int ones = 0, twos = 0, xthrees = 0;
        for(int i = 0; i < n; i++)
        {     
            twos = twos | (ones & A[i]); //用twos记录到当前为止，二进制 "1" 出现3k+2次的位数；            
            ones = ones ^ A[i]; //用ones记录到当前为止，二进制 "1" 出现3k+1次的位数;            
            //当ones和twos的某一位同时为”1“时，即该位出现二进制"1" 3k+3次（也就是3k次），清零该位。
            xthrees = ~(ones & twos); // xthrees 是二进制 "1" 没有出现3k次的位数            
            ones = ones & xthrees;
            twos = twos & xthrees;         
        }       
        return ones; //twos, threes最终都为0.ones是只出现一次的数
    }
    
    
    private int singleNumber_two_otherthree(int A[], int n) {
        int ones = 0, twos = 0, xthrees = 0;
        for(int i = 0; i < n; i++)
        {     
            twos = twos | (ones & A[i]); 
            ones = ones ^ A[i];               
            xthrees = ~(ones & twos);             
            ones = ones & xthrees;
            twos = twos & xthrees;         
        }       
        return twos; 
    }
    private int[] twoNumber_otherthree(int A[], int n) {
        int ones = 0, twos = 0, xthrees = 0;
        int xones =0, xtwos =0;
        for(int i = 0; i < n; i++)
        {     
            twos = twos | (ones & A[i]); 
            ones = ones ^ A[i];               
            xthrees = ~(ones & twos); 
            
            
            ones = ones & xthrees;
            twos = twos & xthrees;         
        }
        
        //ones = ~ twos;
        //twos = twos &(~ones);
        return new int[]{ones,twos}; 
    }
    
    //这是一道很有趣的位运算题。百思不得其解，最后看了[1]介绍的思路。
    //http://ladder.azurewebsites.net/forum.php?mod=viewthread&tid=1731
    //如果用二进制来表达数组中每一个数字的话，如果我们遍历一遍数组中的所有的数，
    //即将数组中所有数的二进制表达的每位上的“1”都数一遍，那么除了需要找的那个只出现一次的整数外，
      //其他所有的数字二进制表示中每一位“1”都出现了3k次（k为非负整数）。
    //如果能有办法将所有的二进制表达中这些3k个“1”清零，那么剩下的二进制表达就表示了需要找到的数。
 
    //（0）初始设定ones=0; twos=0;

         //（1）用twos记录到当前为止，二进制 "1" 出现3k+2次的位数；
    //twos = twos | (ones & A);

    //（2）用ones记录到当前为止，二进制 "1" 出现3k+1次的位数；
    //ones = ones ^ A;

    //（3）当ones和twos的某一位同时为”1“时，即该位出现二进制”1“ 3k+3次（也就是3k次），清零该位。
    //xthrees = ~(ones & twos); // xthrees 是二进制 "1" 没有出现3k次的位数
    
    //ones = ones & xthrees;
    //twos = twos & xthrees;

    //（4）遍历完数组中所有的数之后，ones记录的就是最终结果。

    //扩展：
    //同样的道理，可以解决{给定一个包含n个整数的数组，
    //除了一个数出现两次外所有的整数均出现三次，找出这个只出现两次的整数。}，return twos就行了。

    //更强的扩展: 
    //{给定一个包含n个整数的数组，有一个整数x出现b次，
     //一个整数y出现c次，其他所有的数均出现a次，其中b和c均不是a的倍数，找出x和y。}可以参见[1]，思路是一样的。

    
    
    
    //1-1000放在含有1001个元素的数组中，只有唯一的一个元素值重复，
     //其它均只出现一次．
     //每个数组元素只能访问一次，设计一个算法，将它找出来；
     //不用辅助存储空间，
     //首先 回忆 异或操作，任意数字与自身相异或，结果都为0.
     // 还有一个重要的性质，即任何元素与0相异或，结果都为元素自身
     //能否设计一个算法实现？
    //Insert the numbers into a balanced binary search tree, 
    //when the duplicate comes up it will find that the value already exists in the tree, and it can then return. O ( n * log n ). 
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
    
    
	// lowbit表示的是某个数从右往左扫描第一次出现1的位置
	private int lowbit(int x)
	{
	   return x&~(x-1);
	}
    //找出数组中唯一出现一次的两个数字  要求时间复杂度是O(n)，空间复杂度是O(1)。
    //首先 回忆 异或操作，任意数字与自身相异或，结果都为0.
    // 还有一个重要的性质，即任何元素与0相异或，结果都为元素自身
   //http://blog.csdn.net/wangwh485/article/details/6715357
    public static void main(String[] args) {
		SingleNumber slt = new SingleNumber();
		int[] A = new int[] { 1, 2, 1, 2, 3, 4, 4 };
		System.out.println(slt.singleNumber_once_other_twice(A));	
		
		//int[] B = new int[] { 2,1,2,5,33,33,16,7,16};//will out of bound
		int[] B = new int[] { 2,1,2,5,3,3,6,7,6};
		slt.single_three_num(B);
		
		
		int arr[] = { 1, 3, 2, 9, 11, 1, 3, 11 };
		System.out.println("the two once number "+Arrays.toString(slt.twoNumber_once_other_twice(arr)));
		
		int[] C = new int[] { 6,7,5,3,3,10,11};
		int result = slt.FindRepeat(C,C.length);
		System.out.println("The twice number is "+result);
		
		
		int[] D = new int[] { 6,6,6,3,10,10,10};
		int result2 = slt.singleNumber_other_three(D,D.length);
		System.out.println("The single number of three is "+result2);
		
		int[] E = new int[] { 6,6,6,5,5,10,10,10};
		int result3 = slt.singleNumber_two_otherthree(E,E.length);
		System.out.println("The single twice number of three is "+result3);
		
		
		int[] F = new int[] { 6,6,6,1,5,5,10,10,10};
		int[] result4 = slt.twoNumber_otherthree(F,F.length);
		
		int result5 = slt.singleNumber_other_three(F,F.length);
		
		System.out.println("The single twice number of three is "+Arrays.toString(result4));
		System.out.println("The single twice number of three is "+ result5);

		int[] G = new int[] { 6,6,1,3,5,10,10,12,12};
		int result6 = slt.single_three_num_not_in10(G);
		System.out.println("The 3 number once of two "+ result6);
		
    }

    
    //to to
    //http://blog.csdn.net/qdlovecsj/article/details/10183363
    //http://www.zhihu.com/question/19659409
}