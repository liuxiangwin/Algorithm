package com.liuxiangwin.algor.leetcode.operator;

/**
 * Problem: Get maximum binary Gap.
For example, 9's binary form is 1001, the gap is 2.

Thoughts
The key to solve this problem is the 
fact that an integer x & 1 will get 
the last digit of the integer.
 *
 */
public class MaxBinaryGap {
	public static int solution(int number) {
		int max = 0;
		int count = -1;
		int result = 0;
        
		while (number > 0) {
			// 通过右移操作来&每个bit位
			result = number & 1;  //(这个操作做的是计算那位的是1还是0) 
			number = number >> 1; //(这个操作做的是每次右移一位)
			//如果是0
			if (result ==0 && count >= 0) {
				count++;
			} 
			//表示到头了 //第一次1会进来，max 和count都置为0
			if (result == 1) {
				max = count > max ? count : max;
				count = 0;
			}
		} 
		return max;
	}
	//cacaluatet the 1 in the binary number
    private static int countBinaryOne(int number){
		int count = 0;
		int tmpres = 0;
		while (number > 0) {
			tmpres = number & 1;
			if (tmpres == 1) {
				count++;
			}
			number = number >> 1;

		}
		return count;
	}
    //   110101 1000  [base2]          593 100 [base10]
    // -           1  [base2]        -       1 [base10]     
    //-------------------------------------------------
    //   110101 0111                   593 099    
    //  当一个数减去1的时候，等同于最低有效位的1变成0， 其最低有效位的0变成1
    
    //  所用   n & (n-1)=
    //   110101 1000  [base2]                                  110101 1000  [base2]
    // & 110101 0111  [base2]      ^(001010 1000) [base2]    & 001010 1000  [base2]
    //-----------------------------------------------------------------------------
    //   110101 0000                                           000000 1000(取的最低位的1)
    
    private static int countBinaryOne2(int number) {
    	int count;
		for (count = 0; number > 0; count++) {
			number &= number - 1;
		}
		return count;
    }
	public static void main(String[] args) {
		//10 binary number 1001
		System.out.println(solution(9));
		
		int number = 10;
		System.out.println(number+" binary: "+Integer.toBinaryString(number)+
				" has '1' numbers is "+countBinaryOne(number));
		
		
		System.out.println(number+" binary: "+Integer.toBinaryString(number)+
				" has '1' numbers is "+countBinaryOne2(number));
	}
}
