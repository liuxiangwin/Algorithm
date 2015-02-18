package com.liuxiangwin.algor.leetcode.binarysearch;

import java.util.Arrays;
import java.util.Stack;

import com.liuxiangwin.algor.leetcode.binarysearch.ContainerWithMostWater;

/**
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * 
 *  * Note: You may not slant the container.
 *                                 
 *	                    |            
 *	             |      |                    
 *	             |      |                   
 *	             |      |           |    
 *	|            |      |     |     |   
 *	|_____|______|______|_____|_____|___
 *  0     1      2      3     4     5   
 * 
 * 
 * 
 * For example, Given height = [2,1,5,6,2,3], return 10.
 * 
 *http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
 */

public class LargestRectangleinHistogram {
	public int largestRectangleArea(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int index = 0;
		int maxArea = 0;
		int[] h = new int[height.length + 1];
		h = Arrays.copyOf(height, height.length + 1);
		while (index < h.length) {
			if (stack.isEmpty() || h[stack.peek()] <= h[index]) {
				stack.push(index);
				index++; //ֻ�г��� �����ǰ����Ԫ�زŻ�index++
				         //ͬʱ�����������Ԫ�زŻ���stack
			} else {
				int t = stack.pop();
				//��ʱ��ʼ���������������ȵ���ջ��Ԫ�أ�t=3������ͼ��ɫ���֡�
				// i=4;
				maxArea = Math.max(maxArea, 
				h[t] * (stack.isEmpty() ? index : index - stack.peek() - 1));
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		int[] input1 = { 2, 1, 5, 6, 2, 3 }; // �����25

		int[] input2 = { 5, 2, 12, 1, 5, 3, 4, 11, 9, 4 };// �����55

		System.out.println(new LargestRectangleinHistogram().largestRectangleArea(input1));

		//System.out.println(new ContainerWithMostWater().maxArea(input2));
	}

}