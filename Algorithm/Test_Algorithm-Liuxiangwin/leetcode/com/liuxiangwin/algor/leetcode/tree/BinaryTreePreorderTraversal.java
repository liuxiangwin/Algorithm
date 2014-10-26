package com.liuxiangwin.algor.leetcode.tree;
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
import com.liuxiangwin.algor.leetcode.uitl.ListNode;
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
	private volatile int i;
	
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
	//1.What is preorder? (parent node is processed before its children)
    //2.Use Stack from Java Core library
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
	
	//Use a stack to track nodes
	//Understand when to push node into the stack and 
	//when to pop node out of the stack
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>(); 
        
        if(root == null)
            return result; 
 
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        //define a pointer to track nodes
        TreeNode current = root;
        while(!nodeStack.empty() || current != null){ 
            // if it is not null, push to stack //and go down the tree to left
            if(current != null){
                nodeStack.push(current);
                current = current.left;
 
            // if no left child // pop stack, process the node
            // then let p point to the right
            }else{
                TreeNode t = nodeStack.pop();         
                result.add(t.val);
                current = t.right;
            }
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
	
	
	
	public ArrayList<Integer> postorderTraversalIter(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		nodeStack.push(root);// 最后访问
		
		while (!nodeStack.isEmpty()) {
			TreeNode current = nodeStack.peek();
			// 根节点无子节点
			if (current.left == null && current.right == null) {
				result.add(current.val);
				nodeStack.pop();
			}             
			if (current.left != null) {
				nodeStack.push(current.left);
				current.left = null;
				continue;
			}
			if (current.right != null) {
				nodeStack.push(current.right);
				current.right = null;
				continue;
			}
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
		
		ArrayList<Integer> res2_lter = slt.inorderTraversal(root);
		System.out.println("中序遍历非递归 "+res2_lter.toString());
		
		ArrayList<Integer> res3 = slt.postorderTraversal(root);
		System.out.println("后序遍历 "+res3.toString());
		
		ArrayList<Integer> res3_lter = slt.postorderTraversalIter(root);
		System.out.println("后序 遍历非递归 "+res3_lter.toString());
	}
}