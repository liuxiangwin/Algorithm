package com.liuxiangwin.algor.leetcode.test.tree;
// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 18, 2014
// Source:   http://oj.leetcode.com/problems/binary-tree-preorder-traversal/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/20306491

// Given a binary tree, return the preorder traversal of its nodes' values.
//
// For example:
// Given binary tree {1,#,2,3},
//   1
//    \
//     2
//    /
//   3
// return [1,2,3].
//
// Note: Recursive solution is trivial, could you do it iteratively?

import java.util.ArrayList;
import java.util.Stack;

import com.liuxiangwin.algor.leetcode.uitl.BinaryTreePrinter;
import com.liuxiangwin.algor.leetcode.uitl.TreeNode;
/**
 * 
 *             1               
		      / \       
		     /   \      
		    /     \     
		   /       \    
		   3       2       
		  / \       \   
		 /   \       \  
		 6   9       5   
		              \ 
		              6 
	Time Complexity: O(n)
	
	Depth First Traversals:
	(a) Inorder
	(b) Preorder
	(c) Postorder
 */


public class BinaryTreePreorderTraversal {
	// Recursive
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (root != null) {
			result.add(root.val);

			result.addAll(preorderTraversal(root.left));

			result.addAll(preorderTraversal(root.right));
		}

		return result;
	}

	
	// iterative
	public ArrayList<Integer> preorderTraversalIter(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (root == null) {
			return result;
		}

		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		nodeStack.push(root);

		while (!nodeStack.empty()) { 
			TreeNode node = nodeStack.pop();
			result.add(node.val);

			if (node.right != null) {
				nodeStack.push(node.right);
			}

			if (node.left != null) {
				nodeStack.push(node.left);
			}
		}

		return result;
	}
	
	
	
	public ArrayList<Integer> iorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (root != null) {
			result.addAll(iorderTraversal(root.left));

			result.add(root.val);
			
			result.addAll(iorderTraversal(root.right));
		}

		return result;
	}
	
	
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (root != null) {
			

			result.addAll(postorderTraversal(root.left));

			result.addAll(postorderTraversal(root.right));
			
			result.add(root.val);
		}

		return result;
	}
	public static void main(String[] args) {
		BinaryTreePreorderTraversal slt = new BinaryTreePreorderTraversal();
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
		ArrayList<Integer> res = slt.preorderTraversalIter(root);
		System.out.println("前序遍历 "+res.toString());
		
		
		ArrayList<Integer> resIter = slt.preorderTraversalIter(root);
		System.out.println("前序遍历 "+resIter.toString());
		
		ArrayList<Integer> res2 = slt.iorderTraversal(root);
		System.out.println("中序遍历 "+res2.toString());
		
		ArrayList<Integer> res3 = slt.postorderTraversal(root);
		System.out.println("后序遍历 "+res3.toString());
	}
}