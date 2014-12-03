package com.liuxiangwin.algor.leetcode.tree;

import com.liuxiangwin.algor.leetcode.uitl.BinaryTreePrinter;
import com.liuxiangwin.algor.leetcode.uitl.TreeNode;

/**
 * 
 * //Time Complexity: O(n)
	 *T(n) = 2T(n/2) + C
	  T(n) -->  Time taken for an array of size n
	   C   -->  Constant (Finding middle of array and 
	   linking root to left and right subtrees take constant time) 
 */


public class ConvertSortArrayToBinaryTree {

	public TreeNode sortedArrayToBST(int[] num, int start, int end) {
		if (start <= end) {
			int mid = (start + end) / 2;
			
			TreeNode node = new TreeNode(num[mid]);
			
			node.left = sortedArrayToBST(num, start, mid-1);
			node.right = sortedArrayToBST(num, mid+1, end);
			return node;
		}		
	   return null;
	}


	public static void main(String args[]) {
		int[] number = { 9, 12, 14, 17, 19, 23, 50, 54, 67, 72, 76 };
		ConvertSortArrayToBinaryTree btFromSortArray = new ConvertSortArrayToBinaryTree();
		TreeNode root = btFromSortArray.sortedArrayToBST(number,0,number.length-1);
		BinaryTreePrinter.printNode(root);
	}
}

