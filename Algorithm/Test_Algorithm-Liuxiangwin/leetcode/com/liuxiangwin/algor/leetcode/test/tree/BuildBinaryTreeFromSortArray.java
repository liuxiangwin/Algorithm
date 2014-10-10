package com.liuxiangwin.algor.leetcode.test.tree;

public class BuildBinaryTreeFromSortArray {

	public void buildTree(int[] num, int start, int end, TreeNode node) {
		if (start <= end) {
			int mid = (start + end) / 2;
			node = new TreeNode(num[mid]);
			buildTree(num, start, mid - 1, node.left);
			buildTree(num, mid + 1, end, node.right);
		}
	}

	public TreeNode sortedArrayToBST(int[] num) {
		// Start typing your C/C++ solution below
		// DO NOT write int main() function
		TreeNode root = null;
		buildTree(num, 0, num.length - 1, root);
		return root;
	}
   public static void main(String args[])
   {
	   int[] number ={9,12,14,17,19,23,50,54,67,72,76};
	   BuildBinaryTreeFromSortArray binaryTreeFromSortArray = new BuildBinaryTreeFromSortArray();
	   binaryTreeFromSortArray.sortedArrayToBST(number);
   }
}
