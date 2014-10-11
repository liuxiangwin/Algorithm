package com.liuxiangwin.algor.leetcode.test.tree;

import com.liuxiangwin.algor.leetcode.uitl.BinaryTreePrinter;
import com.liuxiangwin.algor.leetcode.uitl.TreeNode;

public class BuildBinaryTreeFromSortArray {

	public TreeNode buildTree(int[] num, int start, int end) {
		if (start <= end) {
			int mid = (start + end) / 2;
			TreeNode node = new TreeNode(num[mid]);
			node.left = buildTree(num, start, mid-1);
			node.right = buildTree(num, mid+1, end);
			return node;
		}
	   return null;
	}

	public TreeNode sortedArrayToBST(int[] num) {
		// Start typing your C/C++ solution below
		return buildTree(num,0,num.length-1);
		
	}

	public static void main(String args[]) {
		int[] number = { 9, 12, 14, 17, 19, 23, 50, 54, 67, 72, 76 };
		BuildBinaryTreeFromSortArray btFromSortArray = new BuildBinaryTreeFromSortArray();
		TreeNode root = btFromSortArray.sortedArrayToBST(number);
		BinaryTreePrinter.printNode(root);
	}
}

