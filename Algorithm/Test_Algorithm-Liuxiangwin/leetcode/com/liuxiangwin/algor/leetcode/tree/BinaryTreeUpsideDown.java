package com.liuxiangwin.algor.leetcode.tree;

import com.liuxiangwin.algor.leetcode.uitl.BinaryTreePrinter;
import com.liuxiangwin.algor.leetcode.uitl.TreeNode;

public class BinaryTreeUpsideDown {

	public TreeNode UpsideDownBinaryTree(TreeNode root) {
		if (root == null)
			return null;

		// Working base condition
		if (root.left == null && root.right == null) {
			return root.left;
		}

		TreeNode newRoot = UpsideDownBinaryTree(root.left);
		
		newRoot.right = root;
		newRoot.left = root.right;
		
		root.left = null;
		root.right = null;

		return newRoot.right;
	}
	
	public static void main(String args[])
	{
		TreeNode root = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		root.left = n2;
		root.right = n3;

		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);

		n2.left = n4;
		n2.right = n5;
		n4.left = n6;
		n4.right = n7;
		
		
		BinaryTreePrinter.printNode(root);
		
		BinaryTreeUpsideDown solution = new BinaryTreeUpsideDown();
		TreeNode newRoot = solution.UpsideDownBinaryTree(root);
		
		BinaryTreePrinter.printNode(newRoot);
	}
}
