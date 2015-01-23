package com.liuxiangwin.algor.leetcode.binarysearch;

public class FirstMissingPositive {

	/* Given [1,2,0] return 3, and [3,4,-1,1] return 2
	 * �����Ҫ��������ʱ��ͳ����ռ䣬˼��������Counting sort�еķ�����
	 * ���˽�����ѿ��Բμ� ��Ȼ�����ö���ռ䣬�Ǿ�ֻ���������鱾��
	 * ��Counting sortһ�������������index����Ϊ���ֱ����������
	 * ���������յ���˳�����ηŵ������С�
	 * ����A[0]=1, A[1]=2, A[2]=3, ... , ����һ����
	 * �������ĸ�����Ԫ��Υ����A[i]=i+1
	 * ��˵��i+1��������Ҫ��ĵ�һ��ȱʧ��������������Щ���ڷ�Χ�ڵ����֣����ǿ���ֱ������������˵������0�����߳������鳤�ȵ���������Щ�����������ǵĴ𰸡���������
	 */
	public static int firstMissingPositive(int[] A) {
	    if(A==null || A.length==0)
	    {
	        return 1;
	    }
	    for(int i=0;i<A.length;i++)
	    {
	        if(A[i]<=A.length && A[i]>0 && A[A[i]-1]!=A[i])
	        {
	            int temp = A[A[i]-1];
	            A[A[i]-1] = A[i];
	            A[i] = temp;
	            i--;
	        }
	    }
	    for(int i=0;i<A.length;i++)
	    {
	        if(A[i]!=i+1)
	            return i+1;
	    }
	    return A.length+1;
	}
	
	public static int firstMissingPositive2(int A[]) {
		if (A == null || A.length == 0) {
			return 1;
		}
		int i = 0;
		while (i < A.length) {
			while (i < A.length && A[i] != i + 1) {
				if (A[i] <= 0 || A[i] > A.length || A[i] == A[A[i] - 1])
					i++;
				else {
					int temp = A[A[i] - 1];
					A[A[i] - 1] = A[i];
					A[i] = temp;

				}

			}
			i++;
		}
		for (int j = 0; i < A.length; i++)
			if (A[i] != (i + 1))
				return i + 1;
		return A.length + 1;
	}
	


}
