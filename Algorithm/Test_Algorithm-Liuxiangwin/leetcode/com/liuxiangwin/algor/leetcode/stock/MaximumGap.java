package com.liuxiangwin.algor.leetcode.stock;

import java.util.Arrays;

import com.liuxiangwin.algor.leetcode.uitl.ArrayUtil;

public class MaximumGap {
	
	
	static class Bucket {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		void add(int n) {
			min = Math.min(n, min);
			max = Math.max(n, max);
		}
	}

	public int maximumGap(int[] num) {
		if (num.length < 2)
			return 0;

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < num.length; i++) {
			max = Math.max(max, num[i]);
			min = Math.min(min, num[i]);
		}

		int gap = (int) Math.ceil((double) (max - min) / (num.length - 1));
		int n = (max - min) / gap + 1;

		Bucket[] buckets = new Bucket[n];

		for (int i = 0; i < num.length; i++) {
			int index = (num[i] - min) / gap;

			if (buckets[index] == null)
				buckets[index] = new Bucket();

			buckets[index].add(num[i]);
		}

		int maxGap = Integer.MIN_VALUE;

		int prev = min;

		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] == null)
				continue;

			maxGap = Math.max(maxGap, buckets[i].min - prev);

			prev = buckets[i].max;
		}

		return maxGap;
	}
	
	
	public int maxGap(int[] num)
	{
		int res= 0;
		Arrays.sort(num);
		for (int i=1; i<num.length;i++)
		{
			res= Math.max(res, (num[i]-num[i-1]));
		}
		return res;
	}
	
	public static void main(String[] args) {
	   int[] maxGapData = { 2 ,13,5,25,4,1};
	   int maxGap = new MaximumGap().maximumGap(maxGapData);
	   System.out.println("the maxGap is "+maxGap);
	   
	   System.out.println("===================");
	   int maxGap2 = new MaximumGap().maxGap(maxGapData);
	   System.out.println("the maxGap2 is "+maxGap2);
	   
	   int[] data = { 73, 22, 93, 43, 55};
	   RadixSort.sort(data, 3);
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println("===================");
		int[] unsorted = { 99, 65, 24, 47, 50, 88,33, 66, 67, 31, 18 };
		int[] sorted = BucketSort.bucket_sort(unsorted, 99);
		System.out.println(Arrays.toString(sorted));
		for (int i = 0; i < sorted.length; i++) {
			if(sorted[i]!=0)				
			System.out.print(sorted[i] + " ");
		}
	}
}


class  RadixSort{
	// http://www.cnblogs.com/ganganloveu/p/4162290.html
	// http://www.meetqun.com/thread-3214-1-1.html
	//http://www.cnblogs.com/developerY/p/3172379.html
	/** * 第一次排序(个位):		
		3 4 2		
		5 7 6		
		3 5 6		
		0 5 8		
		第二次排序(十位):		
		3 4 2		
		3 5 6		
		0 5 8		
		5 7 6		
		第三次排序(百位):		
		0 5 8		
		3 4 2		
		3 5 6		
		5 7 6		
		结果: 58 342 356 576			
		*/
	// RadixSort
	public static void sort(int[] number, int pos) {// d表示最大的数有多少位
		int k = 0;
		int n = 1;
		int m = 1;// 控制键值排序依据在哪一位
		int[][] temp = new int[10][number.length];// 数组的第一维表示可能的余数0-9
		int[] order = new int[10];// 数组orderp[i]用来表示该位是i的数的个数
		while (m <= pos) {
			for (int i = 0; i < number.length; i++) {
				int lsd = ((number[i] / n) % 10);
				temp[lsd][order[lsd]] = number[i];
				order[lsd]++;
			}
			//ArrayUtil.printMatrix(temp);
			//System.out.println("---------------------------");
			for (int i = 0; i < 10; i++) {
				if (order[i] != 0) {
					for (int j = 0; j < order[i]; j++) {
						number[k] = temp[i][j];
						k++;
					}
				}
				order[i] = 0;
			}
			//System.out.println(Arrays.toString(order));
			//System.out.println("==============================");
			n *= 10;// 排序下一位
			k = 0;
			m++;
		}
	}
}


class BucketSort{
		/**
		 * 准备10个空桶,最大数个空桶
	[6 2 4 1 5 9]           待排数组
	[0 0 0 0 0 0 0 0 0 0]   空桶
	[0 1 2 3 4 5 6 7 8 9]   桶编号(实际不存在) 
	
	1,顺序从待排数组中取出数字,首先6被取出,然后把6入6号桶,这个过程类似这样:空桶[ 待排数组[ 0 ] ] = 待排数组[ 0 ]
	
	[6 2 4 1 5 9]           待排数组
	[0 0 0 0 0 0 6 0 0 0]   空桶
	[0 1 2 3 4 5 6 7 8 9]   桶编号(实际不存在) 
	
	2,顺序从待排数组中取出下一个数字,此时2被取出,将其放入2号桶,是几就放几号桶
	
	[6 2 4 1 5 9]           待排数组
	[0 0 2 0 0 0 6 0 0 0]   空桶
	[0 1 2 3 4 5 6 7 8 9]   桶编号(实际不存在) 
	
	3,4,5,6省略,过程一样,全部入桶后变成下边这样
	
	[6 2 4 1 5 9]           待排数组
	[0 1 2 0 4 5 6 0 0 9]   空桶
	[0 1 2 3 4 5 6 7 8 9]   桶编号(实际不存在)	
		 */
	public static int[] bucket_sort(int[] unsorted, int maxNumber)
    {
        int[] sorted = new int[maxNumber + 1];
        for (int i = 0; i < unsorted.length; i++)
        {
            sorted[unsorted[i]] = unsorted[i];
        }
        return sorted;
    }
	
}