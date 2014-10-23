package com.liuxiangwin.algor.leetcode.number.tree;

import com.liuxiangwin.algor.leetcode.uitl.BinaryTreePrinter;
import com.liuxiangwin.algor.leetcode.uitl.TreeNode;


/**
 * 
		 *  1
		   / \
		  2   2
		 / \ / \
		3  4 4  3
 * 
 * @author liuxiangwin
 *
 */
public class IsSymmetricTree {

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return symmetric(root.left, root.right);
	}

	public boolean symmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		
		else if (left != null && right == null)
			return false;
		else if (left == null && right != null)
			return false;
		if (left.val != right.val)
			return false;

		return symmetric(left.left, right.right)
		    && symmetric(left.right, right.left);
	}
    
	public static void main(String args[])
	{  
		
		IsSymmetricTree isSymmetricTree = new IsSymmetricTree();
		TreeNode root = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(2);
		root.right = n3;
		root.left = n2;
		
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(3);

		n2.left=n4;
		n2.right=n5;
		
		n3.left= n6;
		n3.right= n7;
		BinaryTreePrinter.printNode(root);
		
		System.out.println("isSymmetricTree :"+isSymmetricTree.isSymmetric(root));
	}
}
