package com.liuxiangwin.algor.leetcode.binarysearch;

import java.util.Arrays;

public class FirstMissingPositive {

	/*
	 * Given [1,2,0] return 3, and [3,4,-1,1] return 2
	 * �����Ҫ��������ʱ��ͳ����ռ䣬˼��������Counting sort�еķ����� ���˽�����ѿ��Բμ� ��Ȼ�����ö���ռ䣬�Ǿ�ֻ���������鱾��
	 * ��Counting sortһ�������������index����Ϊ���ֱ���������� ���������յ���˳�����ηŵ������С� ����A[0]=1,
	 * A[1]=2, A[2]=3, ... , ����һ���� �������ĸ�����Ԫ��Υ����A[i]=i+1 ��˵��i+1��������Ҫ��ĵ�һ��ȱʧ��������
	 * ������Щ���ڷ�Χ�ڵ����֣����ǿ���ֱ������������˵������0�� ���߳������鳤�ȵ���������Щ�����������ǵĴ𰸡���������
	 */
	public static int firstMissingPositive(int[] A) {
		if (A == null || A.length == 0) {
			return 1;
		}
		for (int i = 0; i < A.length; i++) {
			// if(A[i]<=A.length && A[i]>0 && A[A[i]-1]!=A[i]
			// && A[i] - 1 != i)
			if (A[i] > 0 && A[A[i] - 1] != A[i] && A[i] - 1 != i) {
				int temp = A[A[i] - 1];
				A[A[i] - 1] = A[i];
				A[i] = temp;
				i--;
			}
		}
		for (int i = 0; i < A.length; i++) {
			if (A[i] != i + 1)
				return i + 1;
		}
		return A.length + 1;
	}

	/*
	 * For simplicity, 
	 * consider the data in the range 0 to 9. 
	 * Input data: 1, 4, 1, 2, 7, 5, 2 
	 * 
	 * 1) Take a count array to store the count of each unique
	 * object. Index: 0 1 2 3 4 5 6 7 8 9 
	 *         Count: 0 2 2 0 1 1 0 1 0 0
	 * 
	 * 2) Modify the count array such that each element at each index stores the
	 * sum of previous counts. 
	 * 			Index: 0 1 2 3 4 5 6 7 8 9 
	 * 			Count: 0 2 4 4 5 6 6 7 7 7
	 * The modified count array indicates the position of each object in the
	 * output sequence.
	 * 
	 * 3) Output each object from the input sequence followed by decreasing its
	 * count by  
	 * 1. Process the input data: 1, 4, 1, 2, 7, 5, 2. 
	 * Position of 1 is 2. Put data 1 at index 2 in output.
	 *  
	 *  Decrease count by 1 to place next data 1 at an index 1 smaller than this index.
	 */

	void sort(char arr[]) {
		int n = arr.length;

		// The output character array that will have sorted arr
		char output[] = new char[n];

		// Create a count array to store count of inidividul
		// characters and initialize count array as 0
		int count[] = new int[256];
		for (int i = 0; i < 256; i++)
			count[i] = 0;

		// store count of each character
		for (int i = 0; i < n; i++)
		     count[arr[i]]++;

		// Change count[i] so that count[i] now contains actual
		// position of this character in output array
		for (int i = 1; i <= 255; i++)
			count[i] += count[i - 1];

		// Build the output character array
		//       1, 4, 1, 2, 7, 5, 2 
		//Index: 0 1 2 3 4 5 6 7 8 9 
		//Count: 0 2 4 4 5 6 6 7 7 7
		for (int i = 0; i < n; i++) {
			//��count -1��λ�ô�Ž��
			output[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}

		// Copy the output array to arr, so that arr now
		// contains sorted characters
		for (int i = 0; i < n; ++i)
			arr[i] = output[i];
	}

	public static void main(String[] args) {

		int[] missPos = { 3, 4, -1, 1 };
		System.out.println("First missing positive "
				+ FirstMissingPositive.firstMissingPositive(missPos));

		int[] missPos2 = { 3, 4, -1, 1 };
		System.out.println("First missing positive "
				+ FirstMissingPositive.firstMissingPositive(missPos2));

		int[] missPos3 = { 7, 11, 8, 10 };
		System.out.println("First missing positive "
				+ FirstMissingPositive.firstMissingPositive(missPos3));
	}
}
