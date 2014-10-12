package com.liuxiangwin.algor.leetcode.test.tree;

import com.liuxiangwin.algor.leetcode.uitl.BinaryTreePrinter;
import com.liuxiangwin.algor.leetcode.uitl.TreeNode;

public class IsBanlancedTree {

	public int height(TreeNode node) {
		return node == null ? 0 : 1 + Math.max(height(node.left),
				height(node.right));
	}

	public boolean isHeightBalanced(TreeNode root) {
		return (root == null)
				|| (isHeightBalanced(root.left) 
				&& (isHeightBalanced(root.right) 
				&& Math.abs(height(root.left) - height(root.right)) <= 1));
	}

	public static void main(String args[]) {
		IsBanlancedTree isBanlancedTree = new IsBanlancedTree();
		
		TreeNode root = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(5);
		root.left = n2;
		root.right = n3;

		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(6);

		n2.left = n4;
		n2.right = n5;
		n3.right = n6;
		BinaryTreePrinter.printNode(root);
		
		System.out.println("is Balanced Tree : "+isBanlancedTree.isHeightBalanced(root));
	}

}
