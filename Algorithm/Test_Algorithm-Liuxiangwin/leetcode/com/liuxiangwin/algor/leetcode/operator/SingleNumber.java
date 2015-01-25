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
				res1 ^= num;// ���4����1��һλ�����൱�ڲ��������
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
    private int single_three_num_not_in10(int [] s) //ֻ�����10���ڵ����� 
    {  
        int result =0;;  
        int xorResult = 0;

		for (int num : s) {
			xorResult ^= num;
		}
		int flips =0;
		for (int num : s) {
			flips ^= lowbit(num ^ xorResult);//���������������� lowbit��������ͬ��һ����ͬ�����Է�Ϊ����
			//// ��ʾ���ǣ�flips=lowbit(a^b)^lowbit(a^c)^lowbit(b^c) 
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
            for(int i=0; i< 32; i++){//i����32λ�ϵ�ÿһλ
                for(int index = 0; index < A.length; index ++){
                    bitnum[i]+= (A[index ]>>i)&1;//������ÿ������32λ�ϵļӺ�
                }
                res|=(bitnum[i]%3)<<i;
            }
            return res;
        }

    
    
    private int singleNumber_other_three(int A[], int n) {
        int ones = 0, twos = 0, xthrees = 0;
        for(int i = 0; i < n; i++)
        {     
            twos = twos | (ones & A[i]); //��twos��¼����ǰΪֹ�������� "1" ����3k+2�ε�λ����            
            ones = ones ^ A[i]; //��ones��¼����ǰΪֹ�������� "1" ����3k+1�ε�λ��;            
            //��ones��twos��ĳһλͬʱΪ��1��ʱ������λ���ֶ�����"1" 3k+3�Σ�Ҳ����3k�Σ��������λ��
            xthrees = ~(ones & twos); // xthrees �Ƕ����� "1" û�г���3k�ε�λ��            
            ones = ones & xthrees;
            twos = twos & xthrees;         
        }       
        return ones; //twos, threes���ն�Ϊ0.ones��ֻ����һ�ε���
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
    
    //����һ������Ȥ��λ�����⡣��˼������⣬�����[1]���ܵ�˼·��
    //http://ladder.azurewebsites.net/forum.php?mod=viewthread&tid=1731
    //����ö����������������ÿһ�����ֵĻ���������Ǳ���һ�������е����е�����
    //�����������������Ķ����Ʊ���ÿλ�ϵġ�1������һ�飬��ô������Ҫ�ҵ��Ǹ�ֻ����һ�ε������⣬
      //�������е����ֶ����Ʊ�ʾ��ÿһλ��1����������3k�Σ�kΪ�Ǹ���������
    //������а취�����еĶ����Ʊ������Щ3k����1�����㣬��ôʣ�µĶ����Ʊ��ͱ�ʾ����Ҫ�ҵ�������
 
    //��0����ʼ�趨ones=0; twos=0;

         //��1����twos��¼����ǰΪֹ�������� "1" ����3k+2�ε�λ����
    //twos = twos | (ones & A);

    //��2����ones��¼����ǰΪֹ�������� "1" ����3k+1�ε�λ����
    //ones = ones ^ A;

    //��3����ones��twos��ĳһλͬʱΪ��1��ʱ������λ���ֶ����ơ�1�� 3k+3�Σ�Ҳ����3k�Σ��������λ��
    //xthrees = ~(ones & twos); // xthrees �Ƕ����� "1" û�г���3k�ε�λ��
    
    //ones = ones & xthrees;
    //twos = twos & xthrees;

    //��4�����������������е���֮��ones��¼�ľ������ս����

    //��չ��
    //ͬ���ĵ������Խ��{����һ������n�����������飬
    //����һ�����������������е��������������Σ��ҳ����ֻ�������ε�������}��return twos�����ˡ�

    //��ǿ����չ: 
    //{����һ������n�����������飬��һ������x����b�Σ�
     //һ������y����c�Σ��������е���������a�Σ�����b��c������a�ı������ҳ�x��y��}���Բμ�[1]��˼·��һ���ġ�

    
    
    
    //1-1000���ں���1001��Ԫ�ص������У�ֻ��Ψһ��һ��Ԫ��ֵ�ظ���
     //������ֻ����һ�Σ�
     //ÿ������Ԫ��ֻ�ܷ���һ�Σ����һ���㷨�������ҳ�����
     //���ø����洢�ռ䣬
     //���� ���� ��������������������������򣬽����Ϊ0.
     // ����һ����Ҫ�����ʣ����κ�Ԫ����0����򣬽����ΪԪ������
     //�ܷ����һ���㷨ʵ�֣�
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
    
    
	// lowbit��ʾ����ĳ������������ɨ���һ�γ���1��λ��
	private int lowbit(int x)
	{
	   return x&~(x-1);
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