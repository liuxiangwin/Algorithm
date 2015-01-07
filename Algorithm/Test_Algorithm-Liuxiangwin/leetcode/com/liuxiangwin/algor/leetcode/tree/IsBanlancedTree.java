package com.liuxiangwin.algor.leetcode.tree;

import com.liuxiangwin.algor.leetcode.uitl.BinaryTreeUtil;
import com.liuxiangwin.algor.leetcode.uitl.TreeNode;

public class IsBanlancedTree {

	public int height(TreeNode node) {
		//看左子树高还是右子树高，高的那个的高度加一就是整个二叉树的高度了
		return node == null ? 
			0 :	1 + Math.max(height(node.left),height(node.right));
	}
	
	//它是一 棵空树或足有都是一个平衡树
	//它的左右两个子树的高度差的绝对值不超过1	
	public boolean isHeightBalanced(TreeNode root) {
		return (root == null)|| (isHeightBalanced(root.left) 
				&& (isHeightBalanced(root.right) 
				&& Math.abs(height(root.left) - height(root.right)) <= 1));
	}
	
	public int maxDistanceOfTree(TreeNode root) {
		int leftHeight, rightHeight;
		leftHeight = rightHeight = 0;
		if (root.left != null) {
			leftHeight = height(root.left);
		}

		if (root.right != null) {
			rightHeight = height(root.right);
		}
		return leftHeight + rightHeight;
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
		BinaryTreeUtil.printNode(root);
		
		System.out.println("is Balanced Tree : "+isBanlancedTree.isHeightBalanced(root));
		
		System.out.println(isBanlancedTree.height(root));		
		
		System.out.println("Max distance in tree "+isBanlancedTree.maxDistanceOfTree(root));
		
		
		
		
		TreeNode root3 = new TreeNode(1);
		TreeNode n23 = new TreeNode(2);
		TreeNode n33 = new TreeNode(5);
		root3.left = n23;
		root3.right = n33;

		TreeNode n43 = new TreeNode(3);
		TreeNode n63 = new TreeNode(6);
		n23.left = n43;
		n33.right = n63;
	
		BinaryTreeUtil.printNode(root3);		
		
		System.out.println("is Balanced Tree : "+isBanlancedTree.isHeightBalanced(root3));
		
		
		
		
		
		TreeNode root2 = new TreeNode(1);
		TreeNode n22 = new TreeNode(2);
		TreeNode n32 = new TreeNode(5);
		root2.left = n22;
		root2.right = n32;

		TreeNode n42 = new TreeNode(3);
		TreeNode n62 = new TreeNode(6);
		
		TreeNode n72 = new TreeNode(7);
		TreeNode n82 = new TreeNode(8);

		n22.left = n42;
		n32.right = n62;
		n42.left = n72;
		n62.right = n82;
		BinaryTreeUtil.printNode(root2);
		
		
		System.out.println("is Balanced Tree : "+isBanlancedTree.isHeightBalanced(root2));
		System.out.println("Height of tree "+isBanlancedTree.height(root2));
		System.out.println("Max distance in tree "+isBanlancedTree.maxDistanceOfTree(root2));
		
	}

}
