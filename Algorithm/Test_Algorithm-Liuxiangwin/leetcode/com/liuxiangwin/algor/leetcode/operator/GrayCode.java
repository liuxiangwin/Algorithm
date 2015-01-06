package com.liuxiangwin.algor.leetcode.operator;

import java.util.Arrays;

public class GrayCode {
	//For example, given n = 2, return [0,1,3,2]. 
	//Its gray code sequence is:
	//All the binary code in 2 bit
	//00 - 0
	//01 - 1
	//11 - 3
	//10 - 2	
	//Binary Code ��1011 Ҫת����Gray Code

	//1011 = 1����д��һλ��, 1(��һλ��ڶ�λ��� 1^0 = 1),
	//1(�ڶ�λ������λ�� 0^1=1), 0 (1^1 =0) = 1110
	//��ʵ�͵��� (1011 >> 1) ^ 1011 = 1110
	//(���� >>1) ���^ (����)
	public  int[] grayCode(int n) {
	 int size = 1 << n;
     int [] grayCodes  = new int[size];     
     for (int i = 0; i < size; i++){
         int gCode = i ^ (i>>1);//binary operation
         grayCodes[i] = gCode;  //decimal operation
     }

     return grayCodes;
	}
	
	
	public static void main(String[] args) {
		GrayCode grayCode = new GrayCode();
		System.out.println(Arrays.toString(grayCode.grayCode(2)));

	}

}
