package com.liuxiangwin.algor.leetcode.test.tree;

import java.util.Stack;

import com.liuxiangwin.algor.leetcode.uitl.BinaryTreePrinter;
import com.liuxiangwin.algor.leetcode.uitl.TreeNode;
/**
 *       1
        / \
       2   5
      / \   \
     3   4   6

 *
 */
public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;

		while (p != null || !stack.empty()) {

			if (p.right != null) {
				stack.push(p.right);
			}

			if (p.left != null) {
				p.right = p.left;
				p.left = null;
			} else if (!stack.empty()) {
				TreeNode temp = stack.pop();
				p.right = temp;
			}

			p = p.right;
		}
	}
	
	public static void main(String args[])
	{
		FlattenBinaryTreeToLinkedList  binaryTreeToLinkedList = new FlattenBinaryTreeToLinkedList();
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
		n3.right =n6;
		BinaryTreePrinter.printNode(root);
		
		binaryTreeToLinkedList.flatten(root);
		BinaryTreePrinter.printNode(root);
		
	}
}
