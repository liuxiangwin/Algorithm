package com.liuxiangwin.algor.leetcode.number;

//http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
public class MedianOfTwoSortedArray {
	//Time Complexity: O(n)
	private int getMedian(int ar1[], int ar2[], int length) {
		int i = 0; /* Current index of i/p array ar1[] */
		int j = 0; /* Current index of i/p array ar2[] */
		int m1 = -1, m2 = -1;

		for (int index = 0; index <= length; index++) {
			if (i == length) {
				m1 = m2;
				m2 = ar2[0];
				break;
			} else if (j == length) {
				m1 = m2;
				m2 = ar1[0];
				break;
			}
			if (ar1[i] < ar2[j]) {
				m1 = m2; /* Store the prev median */
				m2 = ar1[i];
				i++;
			} else {
				m1 = m2; /* Store the prev median */
				m2 = ar2[j];
				j++;
			}
		}
		return (m1 + m2) / 2;
	}
	
	
	/* 
	 * log(min(m,n));
	 * This function returns median of ar1[] and ar2[].
	   Assumptions in this function:
	   Both ar1[] and ar2[] are sorted arrays
	   Both have n elements */
	private int getMedian_comparing_medians (int ar1[], int ar2[], int n)
	{
	    int m1; /* For median of ar1 */
	    int m2; /* For median of ar2 */
	 
	    /* return -1  for invalid input */
	    if (n <= 0)
	        return -1;
	 
	    if (n == 1)
	        return (ar1[0] + ar2[0])/2;
	 
	    if (n == 2)
	        return (Math.max(ar1[0], ar2[0]) + Math.min(ar1[1], ar2[1])) / 2;
	 
	    m1 = median(ar1, n); /* get the median of the first array */
	    m2 = median(ar2, n); /* get the median of the second array */
	 
	    /* If medians are equal then return either m1 or m2 */
	    if (m1 == m2)
	        return m1;
	 
	     /* if m1 < m2 then median must exist in ar1[m1....] and ar2[....m2] */
	    if (m1 < m2)
	    {
	        if (n % 2 == 0)
	            return getMedian_comparing_medians(ar1 + n/2 - 1, ar2, n - n/2 +1);
	        else
	            return getMedian_comparing_medians(ar1 + n/2, ar2, n - n/2);
	    }
	 
	    /* if m1 > m2 then median must exist in ar1[....m1] and ar2[m2...] */
	    else
	    {
	        if (n % 2 == 0)
	            return getMedian_comparing_medians(ar2 + n/2 - 1, ar1, n - n/2 + 1);
	        else
	            return getMedian_comparing_medians(ar2 + n/2, ar1, n - n/2);
	    }
	}
	
	/* Function to get median of a sorted array */
	int median(int arr[], int n)
	{
	    if (n%2 == 0)
	        return (arr[n/2] + arr[n/2-1])/2;
	    else
	        return arr[n/2];
	}
	 

	public static void main(String[] args) {
		int ar1[] = { 1, 22, 25, 26, 38 };
		
		//int ar1[] = { 1, 2, 5, 6, 8 };
		int ar2[] = { 16, 20, 27, 30, 45 };
		int result = new MedianOfTwoSortedArray().getMedian(ar1, ar2,
				ar1.length);
		System.out.println(result);

	}

}
