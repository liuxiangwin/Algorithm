package com.liuxiangwin.algor.leetcode.tree;

import com.liuxiangwin.algor.leetcode.uitl.BinaryTreeUtil;
import com.liuxiangwin.algor.leetcode.uitl.TreeNode;

/**
 * Throughts
 * 
 * This problem can be illustrated by using a simple example.
 * 
 * in-order: 4 2 5 (1) 6 7 3 8 post-order: 4 5 2 6 7 8 3 (1) From the post-order
 * array, we know that last element is the root. We can find the root in
 * in-order array. Then we can identify the left and right sub-trees of the root
 * from in-order array.
 * 
 * Using the length of left sub-tree, we can identify left and right sub-trees
 * in post-order array. Recursively, we can build up the tree.
 * 
 * @author liuxiangwin
 *
 */
public class ConstructTreeByXorder {

	public TreeNode buildTree_Postorder_Inorder(int[] inorder, int[] postorder) {

		return buildTree(inorder, 0, inorder.length - 1, postorder, 0,
				postorder.length - 1);
	}

	public TreeNode buildTree(int[] inorder, int iSt, int iEd, int[] postorder,
			int pSt, int pEd) {
		if (iSt > iEd || pSt > pEd)
			return null;

		int rootValue = postorder[pEd];
		TreeNode rootNode = new TreeNode(rootValue);

		int index = 0;// 在中序遍历中找到root节点的下标
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == rootValue) {
				index = i;
				break;
			}
		}
		int leftCount = index - iSt;		
		rootNode.left = buildTree(inorder, iSt, index - 1, 
				postorder,
			    pSt, (pSt + index - iSt - 1));//(pSt + leftCount - 1)
	
		rootNode.right = buildTree(inorder, index + 1, iEd, 
				postorder,
				pSt + index - iSt, pEd - 1);
	
		
		return rootNode;
	}

	public TreeNode buildTree_Preorder_Inorder(int[] inorder,int[] preorder ) {
		if (preorder == null || preorder.length == 0) {
			return null;
		}
		return buildTree2(inorder, 0,
				inorder.length - 1,preorder, 0, preorder.length - 1);
	}

	public TreeNode buildTree2(int[] inorder, int iSt, int iEd,
			int[] preorder, int pSt, int pEd) {
		
		int rootValue = preorder[pSt];

		int index = -1;
		for (int i = iSt; i <= iEd; i++) {
			if (inorder[i] == rootValue) {
				index = i;
				break;
			}
		}

		TreeNode rootNode = new TreeNode(rootValue);

		int leftCount = index - iSt;
		if (leftCount > 0) {
			rootNode.left = buildTree(inorder, iSt, index - 1,
					preorder, 
					pSt + 1, pSt + leftCount);
		}
		int rightCount = iEd - index;
		if (rightCount > 0) {
			rootNode.right = buildTree(inorder, index + 1, iEd,
					preorder, 
					pSt + leftCount + 1, pEd);
		}
		
		return rootNode;
	}

	public static void main(String[] args) {
		// /in-order:
		int[] inorder = { 4, 2, 5, 1, 6, 7, 3, 8 };
		// post-order:
		int[] postoder = { 4, 5, 2, 6, 7, 8, 3, 1 };
		

		ConstructTreeByXorder constructTree = new ConstructTreeByXorder();
		TreeNode root = constructTree.buildTree_Postorder_Inorder(inorder,
				postoder);

		BinaryTreeUtil.printNode(root);
		
		// pre-order:
		int[] preorder2 ={6, 5 ,4 ,8 ,7 ,9};
		// /in-order:
		int[] inorder2 = { 4, 5 ,6 ,7 ,8 ,9};
		
		TreeNode root2 = constructTree.buildTree_Preorder_Inorder
				(preorder2, inorder2);
			
		BinaryTreeUtil.printNode(root2);
		
		
		
	}

}
