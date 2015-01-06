package com.liuxiangwin.algor.leetcode.tree;

import java.util.Stack;


import com.liuxiangwin.algor.leetcode.uitl.BinaryTreeUtil;
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
        if (root == null) return;
        if (root.left != null) {
            TreeNode rightMost = findRightMost(root.left);
            TreeNode rightChild = root.right;
            root.right = root.left;
            root.left = null;
            rightMost.right = rightChild;
        }
        flatten(root.right);
    }
    
    private TreeNode findRightMost(TreeNode root) {
        if (root == null || root.right == null) return root;
        return findRightMost(root.right);
    }
    
    
    public static void main(String args[])
    {
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
		
		BinaryTreeUtil.printNode(root);
		
		FlattenBinaryTreeToLinkedList flList = new FlattenBinaryTreeToLinkedList();
		flList.flatten(root);
		
		BinaryTreeUtil.printNode(root);
		
    }
}
