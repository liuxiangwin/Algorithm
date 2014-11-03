package com.liuxiangwin.algor.leetcode.operator;
// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/single-number/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/19556493

// Given an array of integers, every element appears twice except for one. Find that single one.
// Note:
// Your algorithm should have a linear runtime complexity. 
// Could you implement it without using extra memory?

//���� ���� ��������������������������򣬽����Ϊ0.
// ����һ����Ҫ�����ʣ����κ�Ԫ����0����򣬽����ΪԪ������
 
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
        for (int i=0;i<s.length;i++) //MΪ����ĳ���  
        {  
            int index=s[i]-0;//ֻ����9���ڵ����֣����ԣ���ȥ��0  
            hash[index]++;  
        }  
        for (int j=0;j<10;j++)  
        {  
            if (hash[j] ==1)  //��ʾ����һ��
            {  
            	System.out.println("the 3 number once is "+j);  
            }  
        }  
    }
    
    //1-1000���ں���1001��Ԫ�ص������У�ֻ��Ψһ��һ��Ԫ��ֵ�ظ���
     //������ֻ����һ�Σ�
     //ÿ������Ԫ��ֻ�ܷ���һ�Σ����һ���㷨�������ҳ�����
     //���ø����洢�ռ䣬
     //���� ���� ��������������������������򣬽����Ϊ0.
     // ����һ����Ҫ�����ʣ����κ�Ԫ����0����򣬽����ΪԪ������
     //�ܷ����һ���㷨ʵ�֣�
   private  void FindRepeat(int array[], int length)
    {
      int result = 0;
           for(int i=1;i<=1000;i++)
                  result ^=  i;
           for(int i=0;i<=1000;i++)
                  result ^=  array[i];
    }
    
    
    //�ҳ�������Ψһ����һ�ε���������  Ҫ��ʱ�临�Ӷ���O(n)���ռ临�Ӷ���O(1)��
    //���� ���� ��������������������������򣬽����Ϊ0.
    // ����һ����Ҫ�����ʣ����κ�Ԫ����0����򣬽����ΪԪ������
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
		//Or operation ��1����1
		System.out.println(1|0);
		System.out.println(0|1);
		System.out.println(1|1);
		System.out.println();
	}

	private static void andOperation() {
		//And operation ֻ��1 ����1
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