package com.liuxiangwin.algor.leetcode.tree;

import com.liuxiangwin.algor.leetcode.uitl.BinaryTreeUtil;
import com.liuxiangwin.algor.leetcode.uitl.TreeNode;

public class IsFullorCompleteTree {
	//Full Tree 
     //�����һ�����κ��ӽڵ��⣬ÿһ���ϵ����н�㶼�������ӽ��\
	//�����һ���ϵ����ӽ��Ľ��ΪҶ�ӽ�㣩��
	//Ҳ����������⣬��Ҷ�ӽ��������н����������ӽ�㡣
	//�ڵ����ﵽ���ֵ������Ҷ�ӽ�������ͬһ����.
	
	public boolean isFull(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (height(root.left) != height(root.right)) {
			return false;
		}
		return isFull(root.left) && isFull(root.right);
	}

	public int height(TreeNode node) {
		// ���������߻����������ߣ��ߵ��Ǹ��ĸ߶ȼ�һ���������������ĸ߶���
		return node == null ? 0 : 1 + Math.max(height(node.left),
				height(node.right));
	}
	
	

	
	/**
	 * ��ȫ������(Complete Binary Tree)
����          ��������������Ϊh������ h ���⣬�������� (1��h-1) �Ľ�������ﵽ��������
		�� h �����еĽ�㶼��������������ߣ��������ȫ��������
	 * Return whether tree is complete. A complete tree has minimal height and
	 * any holes in tree would appear in last level to right.
	
	 */
	public boolean isComplete(TreeNode root) {		
		if (root == null) {
			return true;
		}
		// Case 1: Left is full, right is complete, heights same
		if (isFull(root.left) 
			&& isComplete(root.right)
			&& (height(root.left) == height(root.right))) {
			return true;
		}			
		// Case 2: Left is complete, right is full, heights differ
		if (isFull(root.right) 
			&& isComplete(root.left) 
			&& (height(root.left)== height(root.right) + 1)){
			return true;
		}			
		return false;
	}

	public static void main(String args[]) {
		IsFullorCompleteTree isFullorCompleteTree = new IsFullorCompleteTree();

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
		n3.left = n6;
		BinaryTreeUtil.printNode(root);

		System.out.println("is Full Tree : "+ isFullorCompleteTree.isFull(root));
		System.out.println("is Complete Tree : "+ isFullorCompleteTree.isComplete(root));
		
		TreeNode rootNs = new TreeNode(1);
		TreeNode n2Ns = new TreeNode(2);
		TreeNode n3Ns = new TreeNode(5);
		rootNs.left = n2Ns;
		rootNs.right = n3Ns;

		TreeNode n4Ns = new TreeNode(3);
		TreeNode n5Ns = new TreeNode(4);
		TreeNode n6Ns = new TreeNode(6);
		TreeNode n7Ns = new TreeNode(4);

		n2Ns.left = n4Ns;
		n2Ns.right = n5Ns;
		
		n3Ns.left =  n7Ns;
		n3Ns.right = n6Ns;
		BinaryTreeUtil.printNode(rootNs);

		System.out.println("is Full Tree : "+ isFullorCompleteTree.isFull(rootNs));
		
		System.out.println("is Complete Tree : "+ isFullorCompleteTree.isComplete(rootNs));

		//System.out.println(isBanlancedTree.height(root));

	}

}
