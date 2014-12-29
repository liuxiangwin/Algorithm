package com.liuxiangwin.algor.leetcode.tree;
import com.liuxiangwin.algor.leetcode.uitl.BinaryTreePrinter;
import com.liuxiangwin.algor.leetcode.uitl.TreeNode;
/**
 * 
		 *     8                                6
		      / \                              / \       
		     /   \                            /   \
		    /     \      RightRotation       /     \ 
		   /       \                        /       \
		   6        11                     4         8 
		  / \                             /         / \
		 /   \                           /         /   \
		 4   (7)                        2       (7)      11
	    /       
	   /          
      2                   

 */
public class RotationTree {	
	
	public TreeNode rightRotaion(TreeNode topNode){
		TreeNode leftSonNode = topNode.left;
		topNode.left = leftSonNode.right;
		leftSonNode.right = topNode;
		return leftSonNode;
	}
	
	public TreeNode leftRotaion(TreeNode topNode){
		TreeNode rightSonNode = topNode.right;
		topNode.right = rightSonNode.left;
		rightSonNode.left = topNode;
		return rightSonNode;
	}

	//https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/03.01.md
	//http://blog.csdn.net/v_july_v/article/details/6105630
	public static void main(String args[])
	{

		TreeNode root = new TreeNode(8);
		TreeNode n2 = new TreeNode(6);
		TreeNode n3 = new TreeNode(11);	
		
		
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(7);
		TreeNode n6 = new TreeNode(2);
		root.left = n2;
		root.right = n3;		
		
		n2.left=n4;
		n2.right=n5;
		
		n4.left = n6;
		BinaryTreePrinter.printNode(root);
		
		RotationTree rotationTree = new RotationTree();
		TreeNode  rightTop =rotationTree.rightRotaion(root);
		System.out.println("----------------------------");		
		BinaryTreePrinter.printNode(rightTop);
		
	}
	
	
	
	
	
	
	/**
	 *  	   8                                10
		      / \                              / \       
		     /   \                            /   \
		    /     \      LeftRotation        /     \ 
		   /       \                        /       \
		   6        10                     8         12 
		  			/ \                   / \          \
		 		   /   \                 /   \          \
		 		  (9)    12             6     (9)           14
	    				 \       
	   					  \          
                          14     
	 * 
	 * 
	 * 
	 */

}
