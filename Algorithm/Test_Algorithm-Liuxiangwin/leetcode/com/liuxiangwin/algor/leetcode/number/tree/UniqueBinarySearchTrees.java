package com.liuxiangwin.algor.leetcode.number.tree;
// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/unique-binary-search-trees/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/22754969

// Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
// For example,
// Given n = 3, there are a total of 5 unique BST's. 
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3

/**
 *  1          3     3      2      1
    \        /      /       / \       \
     3     2     1       1   3       2
    /     /        \                      \
   2    1          2                     3
本题使用一维线性规划解决。
如果n等于0时，结果为0；
如果n等于1时，只有一个节点，结果为1；
如果n等于2时，根节点有两种选择，结果为2；
如果n大于3时，根节点有n种选择，确定根节点后分别计算左右子树的可能情况，
然后相乘就是当前根节点下所有的变形种类，之后在求和即可。算法实现如下：
 * @author liuxiangwin
 *
 */
public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		int[] num = new int[n + 1];
		num[0] = 1;
		num[1] = 1;

		for (int i = 2; i <= n; ++i) {
			for (int j = 1; j <= i; ++j) {
				num[i] += num[j - 1] * num[i - j];
			}
		}

		return num[n];
	}
	
	public static void main(String[] args) {
		UniqueBinarySearchTrees slt = new UniqueBinarySearchTrees();
		int res = slt.numTrees(3);
		System.out.println(res);
	}
}