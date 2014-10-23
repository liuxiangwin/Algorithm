package com.liuxiangwin.algor.leetcode.tree;

import com.liuxiangwin.algor.leetcode.uitl.BinaryTreePrinter;
import com.liuxiangwin.algor.leetcode.uitl.TreeNode;

public class MaximumAndMinimumDepthOfBinaryTree {

	public int maxiumDepthOfTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int maxLeft = maxiumDepthOfTree(root.left);

		int maxRight = maxiumDepthOfTree(root.right);

		return maxLeft < maxRight ? 
			maxRight + 1: maxLeft + 1;
	}

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int max = 1;
		return dfs(root, max);
	}

	int dfs(TreeNode root, int max) {
		if (root.left == null && root.right == null)
			return max;
		if (root.left == null && root.right != null)
			return dfs(root.right, max + 1);
		if (root.left != null && root.right == null)
			return dfs(root.left, max + 1);
		return Math.max(dfs(root.left, max + 1), dfs(root.right, max + 1));
	}
	
	
	public int minimumDepthOfTree(TreeNode root) {
		// Start typing your C/C++ solution below
		// DO NOT write int main() function
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}

		int minLeft = minimumDepthOfTree(root.left);
		int minRight = minimumDepthOfTree(root.right);

		if (minLeft == 0)
			return minRight + 1;
		else if (minRight == 0)
			return minLeft + 1;
		else
			return Math.min(minLeft + 1, minRight + 1);
	}
	
	
	public static void main(String args[])
	{
		MaximumAndMinimumDepthOfBinaryTree maxMin = new MaximumAndMinimumDepthOfBinaryTree();
		TreeNode root = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		root.right = n2;
		//n2.left = n3;
		root.left = n3;
		
		TreeNode n4 = new TreeNode(6);
		TreeNode n5 = new TreeNode(9);
		TreeNode n6 = new TreeNode(5);
		TreeNode n7 = new TreeNode(6);
		
		n3.left= n4;
		n3.right= n5;
		
		n2.right=n6;
		n6.right=n7;
		
		BinaryTreePrinter.printNode(root);
		
		System.out.println("The longest path in tree "+maxMin.maxiumDepthOfTree(root));
		
		System.out.println("The shortest path in tree "+maxMin.minimumDepthOfTree(root));
		
	}

}
