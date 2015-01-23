package com.liuxiangwin.algor.leetcode.binarysearch;


/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
 * forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 *                                | 
 *|     |             |           | 
 *|     |             |           |         |
 *|     |             |     |     |         |
 *|     |      |      |     |     |    |    |    |
 *|     |      |      |     |     |    |    |    |
 *|_____|______|______|_____|_____|____|____|____|________
 *1     2      3      4     5     6    7    8    9
 * http://m4tiku.duapp.com/report?pid=154 (Chinese version)
 * 
 * (English version)
 * http://www.lifeincode.net/programming/leetcode-container-with-most-water-java/
 */

//The complexity of this algorithm is O(n).
//设置两个指针left和right，初始化left=0，right=num.size()-1.
//计算left和right的最大面积max。比max更大的面积只可能是具有更高的隔板，
//所以left和right中更小的那个隔板向内侧移动。
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int len = height.length, low = 0, high = len - 1;
		int maxArea = 0;
		while (low < high) {
			maxArea = Math.max(maxArea,
			(high - low) * Math.min(height[low], height[high]));
			
			if (height[low] < height[high]) {
				low++;
			} else {
				high--;
			}
		}
		return maxArea;
	}
	
	public static void main(String[] args) {
		int[] input1= {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; //输出：25

		int[] input2 ={5, 2, 12, 1, 5, 3, 4, 11, 9, 4};// 输出：55
		
		System.out.println(new ContainerWithMostWater().maxArea(input1));
		
		System.out.println(new ContainerWithMostWater().maxArea(input2));
	}	
	
}