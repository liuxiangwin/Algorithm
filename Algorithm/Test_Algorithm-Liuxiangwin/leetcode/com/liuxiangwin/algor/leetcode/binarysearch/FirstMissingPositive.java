package com.liuxiangwin.algor.leetcode.binarysearch;

public class FirstMissingPositive {

	/* Given [1,2,0] return 3, and [3,4,-1,1] return 2
	 * 这道题要求用线性时间和常量空间，思想借鉴到了Counting sort中的方法，
	 * 不了解的朋友可以参见 既然不能用额外空间，那就只有利用数组本身，
	 * 跟Counting sort一样，利用数组的index来作为数字本身的索引，
	 * 把正数按照递增顺序依次放到数组中。
	 * 即让A[0]=1, A[1]=2, A[2]=3, ... , 这样一来，
	 * 最后如果哪个数组元素违反了A[i]=i+1
	 * 即说明i+1就是我们要求的第一个缺失的正数。对于那些不在范围内的数字，我们可以直接跳过，比如说负数，0，或者超过数组长度的正数，这些都不会是我们的答案。代码如下
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
