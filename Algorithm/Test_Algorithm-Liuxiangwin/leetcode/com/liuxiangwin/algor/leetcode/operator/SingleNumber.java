package com.liuxiangwin.algor.leetcode.operator;

import java.util.Arrays;

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
		while ((xorResult & 1) != 1)// Ѱ�ҵ�һ������Ϊ1��λ��
		{
			xorResult >>= 1;
			++bitNum;//bitNum��¼������Ҫ���ƶ���λ����1
		}

		int flag = (1 << bitNum);
		int res1 = 0;
		int res2 = 0;
		for (int num : A) {
			if ((num & flag) == 1) {//֤����ͬ����������һλ��ͬ�Ǹ�
				res1 ^= num;
			} else {
				res2 ^= num;
			}
		}

		return new int[] { res1, res2 };
	}
    
    
    private void single_three_num(int [] s) //ֻ�����10���ڵ����� 
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
            	System.out.println("the total 3 number once is "+j);  
            }  
        }  
    }
    
    //http://www.2cto.com/kf/201401/275860.html
    //Given an array of integers, 
    //every element appears three times except for one. Find that single one.
    
    public int singleNumberBitMap(int A[]) {
            int[] bitnum= new int[32];
            int res=0;
            for(int i=0; i< 32; i++){//i����32λ�ϵ�ÿһλ
                for(int j=0; j< A.length; j++){
                    bitnum[i]+= (A[j]>>i)&1;//������ÿ������32λ�ϵļӺ�
                }
                res|=(bitnum[i]%3)<<i;
            }
            return res;
        }

    
    
    private int singleNumber_other_three(int A[], int n) {
        int ones = 0, twos = 0, threes = 0;
        for(int i = 0; i < n; i++)
        {
            threes = twos & A[i]; //�Ѿ��������β����ٴγ���
            twos = twos | ones & A[i]; //�����������εĻ�����������һ�ε����ٴγ��ֵ�
            ones = ones | A[i]; //����һ�ε�
            
            twos = twos & ~threes; //��ĳһλ�������κ����Ǿʹӳ���������������λ
            ones = ones & ~threes; //��ĳһλ�������κ����Ǿʹӳ���һ����������λ
        }
        //ÿ��ѭ���ȼ��� twos�����������ε� 1 �ķֲ���Ȼ��������һ�ε� 1 �ķֲ������� ���߽���������õ��������ε� 1 �ķֲ������
        //Ȼ��� threes ȡ�������� ones��twos�����������������Ŀ���ǽ����������ε�λ�����㡣
   
        return ones; //twos, threes���ն�Ϊ0.ones��ֻ����һ�ε���
    }
    
    
    
    
    
    //1-1000���ں���1001��Ԫ�ص������У�ֻ��Ψһ��һ��Ԫ��ֵ�ظ���
     //������ֻ����һ�Σ�
     //ÿ������Ԫ��ֻ�ܷ���һ�Σ����һ���㷨�������ҳ�����
     //���ø����洢�ռ䣬
     //���� ���� ��������������������������򣬽����Ϊ0.
     // ����һ����Ҫ�����ʣ����κ�Ԫ����0����򣬽����ΪԪ������
     //�ܷ����һ���㷨ʵ�֣�
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
    
    
    //�ҳ�������Ψһ����һ�ε���������  Ҫ��ʱ�临�Ӷ���O(n)���ռ临�Ӷ���O(1)��
    //���� ���� ��������������������������򣬽����Ϊ0.
    // ����һ����Ҫ�����ʣ����κ�Ԫ����0����򣬽����ΪԪ������
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
    }

    
    //to to
    //http://blog.csdn.net/qdlovecsj/article/details/10183363
    //http://www.zhihu.com/question/19659409
}