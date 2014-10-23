package com.liuxiangwin.algor.leetcode.tree;

import java.util.ArrayList;

import com.liuxiangwin.algor.leetcode.uitl.*;

public class RecoverBinarySearchTree {
	public TreeNode mis1,mis2;
	public TreeNode prev;

	public void recoverTree(TreeNode root) {
		mis1 = mis2 = prev = null;
		inorder(root);
		swap(mis1, mis2);
	}

	public void inorder(TreeNode node) {
		if (node.left != null)
			inorder(node.left);
		if (prev != null && (prev.val > node.val)) {
			//prev是需要调整的元素
			if (mis1 == null)
				mis1 = prev;
			mis2 = node;
		}
		prev = node;
		if (node.right != null)
			inorder(node.right);
	}
	
	
	private void swap(TreeNode nodeP,TreeNode nodeQ)
	{
		int temp =nodeP.val;
		nodeP.val = nodeQ.val;
		nodeQ.val= temp;
	}	

	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(10);
		TreeNode n2 = new TreeNode(8);
		TreeNode n3 = new TreeNode(12);	
		
		
		TreeNode n4 = new TreeNode(6);
		TreeNode n5 = new TreeNode(9);
		TreeNode n6 = new TreeNode(14);
		root.left = n2;
		root.right = n6;
		
		
		n2.left=n4;
		n2.right=n5;
		
		n6.right = n3;
		BinaryTreePrinter.printNode(root);
		
		BinaryTreePreorderTraversal slt = new BinaryTreePreorderTraversal();
		                  
		ArrayList<Integer> res = slt.preorderTraversalIter(root);
		System.out.println("前序遍历 "+res.toString());
		ArrayList<Integer> res2 = slt.iorderTraversal(root);
		System.out.println("中序遍历 "+res2.toString());
		
		ArrayList<Integer> res3 = slt.postorderTraversal(root);
		System.out.println("后序遍历 "+res3.toString());
		
		RecoverBinarySearchTree recoverBinarySearchTree = new RecoverBinarySearchTree();
		recoverBinarySearchTree.recoverTree(root);
		
		BinaryTreePrinter.printNode(root);
		
		
	}
}


class Solution2 {
	
	private TreeNode p, q;
	private TreeNode pre;

	public void recoverTree(TreeNode root) {
		if (root == null) {
			return;
		}
		getWrong(root);
		int tmp = p.val;
		p.val = q.val;
		q.val = tmp;
	}
	//中序遍历。p为最左边的错误节点，q为最右边的错误节点�?
	public void getWrong(TreeNode root) {
		getWrong(root.left);
		if (pre != null && root.val < pre.val) {
			if (p == null) {
				p = pre;
				q = root;
			} else {
				q =root;
			}
		}
		pre = root;
		getWrong(root.right);
	}
}