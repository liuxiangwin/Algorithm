package com.liuxiangwin.algor.leetcode.test.tree;

import com.liuxiangwin.algor.leetcode.uitl.BinaryTreePrinter;
import com.liuxiangwin.algor.leetcode.uitl.TreeNode;

/**
 * Throughts

This problem can be illustrated by using a simple example.

in-order:   4 2 5  (1)  6 7 3 8
post-order: 4 5 2  6 7 8 3  (1)
From the post-order array, we know that last element is the root. 
We can find the root in in-order array. Then we can identify the left and 
right sub-trees of the root from in-order array.

Using the length of left sub-tree, we can identify left and right 
sub-trees in post-order array. Recursively, we can build up the tree.
 * @author liuxiangwin
 *
 */
public class ConstructTreeByXorder {
	  private static TreeNode root;
	
	   public TreeNode buildTreeIoPo(int[] inorder, int[] postorder) {	      
	        return buildTree(inorder, 0, inorder.length-1, 
	        		postorder, 0, postorder.length-1);
	    }
	 
	    public TreeNode buildTree(int[] inorder, int in_s, int in_end, 
	                            int[] postorder, int p_s, int p_end){
	        if(in_s > in_end || p_s > p_end)
	            return null;
	 
	        int rootValue = postorder[p_end];
	        TreeNode root = new TreeNode(rootValue);
	 
	        int k=0;
	        //在中序遍历中找到root节点的下标
	        for(int i=0; i< inorder.length; i++){
	            if(inorder[i]==rootValue){
	                k = i;
	                break;
	            }
	        }
	 
	        root.left = buildTree(inorder, in_s, k-1,
	        		postorder, p_s, p_s + k- (in_s+1));
	        // Becuase k is not the length, it it need to -(inStart+1) 
	        //to get the length
	        root.right = buildTree(inorder, k+1,in_end, 
	        		postorder, p_s+ k -in_s, p_end-1);
	        // postStart+k-inStart = postStart+k-(inStart+1) +1                                     
	 
	        return root;
	    }
	
	
	TreeNode BuildTreePI(int[] preorder, int[] inorder, int p_s, int p_e,
			int i_s, int i_e) {
		if (p_s > p_e)
			return null;
		int pivot = preorder[p_s];
		int i = i_s;
		for (; i < i_e; i++) {
			if (inorder[i] == pivot)
				break;
		}
		int length1 = i - i_s - 1;
		int length2 = i_e - i - 1;
		TreeNode node = new TreeNode(pivot);
		node.left = BuildTreePI(preorder, inorder, p_s + 1, length1 + p_s + 1,
				i_s, i - 1);
		node.right = BuildTreePI(preorder, inorder, p_e - length2, p_e, i + 1,
				i_e);
		return node;
	}

	TreeNode buildTree(int[] preorder, int[] inorder) {
		return BuildTreePI(preorder, inorder, 0, preorder.length - 1, 0,
				inorder.length - 1);
	}
	
	
	public static void main(String...args)
	{
		///in-order:   
		int[] inorder={4, 2 ,5 , 1,  6 ,7 ,3, 8};
		//post-order:
		int[] postoder= {4, 5, 2,  6, 7 ,8 ,3 , 1};
		
		
		ConstructTreeByXorder constructTree = new ConstructTreeByXorder();
		TreeNode root = constructTree.buildTreeIoPo(inorder, postoder);
		
		BinaryTreePrinter.printNode(root);
		
		
		
		
		
		
	}
	
	
}
