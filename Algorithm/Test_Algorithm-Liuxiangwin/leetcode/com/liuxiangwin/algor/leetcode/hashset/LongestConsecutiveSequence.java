package com.liuxiangwin.algor.leetcode.hashset;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * Thoughts
 * 
 * Because it requires O(n) complexity, we can not solve the problem by sorting
 * the array first. Sorting takes at least O(nlogn) time.
 * 
 * Java Solution 1
 * 
 * We can use a HashSet to add and remove elements. HashSet is implemented by
 * using a hash table. Elements are not ordered. The add, remove and contains
 * methods have constant time complexity O(1).
 * 
 * @author liuxiangwin
 *
 */
public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		int max = 1;

		for (int num : nums)
			set.add(num);

		for (int num : nums) {
			int left = num - 1;
			int right = num + 1;
			int count = 1;
            
			//O(1)的查找和去重复杂度
			while (set.contains(left)) {
				count++;
				set.remove(left);
				left--;
			}
			//O(1)的查找和去重复杂度
			while (set.contains(right)) {
				count++;
				set.remove(right);
				right++;
			}

			max = Math.max(count, max);//计算最长连续长度
		}

		return max;
	}
	
	public static void main(String args[])
	{
		LongestConsecutiveSequence  consecutiveSequence = new LongestConsecutiveSequence();
		int[] num ={100, 4, 200, 1, 3, 2};
		int result = consecutiveSequence.longestConsecutive(num);
		
		System.out.println(result);
	
		
	}
}
