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
		int[] input1= {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; //Êä³ö£º25

		int[] input2 ={5, 2, 12, 1, 5, 3, 4, 11, 9, 4};// Êä³ö£º55
		
		System.out.println(new ContainerWithMostWater().maxArea(input1));
		
		System.out.println(new ContainerWithMostWater().maxArea(input2));
	}	
	
}