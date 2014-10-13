package com.liuxiangwin.algor.leetcode.test.tree;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.liuxiangwin.algor.leetcode.uitl.BinaryTreePrinter;
import com.liuxiangwin.algor.leetcode.uitl.TreeNode;


/**
 * 
	    A (root)               
	   / \    \   
	  /   \    \  
	 /     \    \ 
	/       \    \
	B       C     D  
   /  \  /     
  /    \/  
E     F   



      1               
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
	
	   
 * Breadth First Search (BFS)  
 *   A--B--C--D--E--F
 *   1--3--2--6--9--5--6
 * 
 * Depth First Search (DFS) 
 * 
 *   A--B--E--F--C--D
 *   1--3--6--9--2--5--9
 * 
 */
 
public class BinaryTreeDFSandBFS {
	//¹ã¶È±éÀú
	private  ArrayList<Integer> breadtheFrist(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Queue queue = new ConcurrentLinkedQueue();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			TreeNode node = (TreeNode) queue.remove();
			result.add(node.val);
			//node.visited = true;
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}

		}
		return result;
	}
	
	
/*	private  ArrayList<Integer> deptheFrist(TreeNode root) {
		
		// DFS uses Stack data structure
	    Stack stack = new Stack();
	    stack.push(this.root);
	    root.visited=true;
	    while(!stack.isEmpty()) {
	    	TreeNode node = (TreeNode)stack.peek();
	        Node child = getUnvisitedChildNode(n);
	        if(child != null) {
	            child.visited = true;
	            s.push(child);
	        }
	        else {
	            s.pop();
	        }
	    }
	    // Clear visited property of nodes
	    clearNodes();
		
		
		
		
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		Queue queue = new ConcurrentLinkedQueue();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			TreeNode node = (TreeNode) queue.remove();
			result.add(node.val);
			node.visited = true;
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}

		}
		return result;
	}*/
	
	public static void main(String[] args) {
		BinaryTreeDFSandBFS dfsAndbfs = new BinaryTreeDFSandBFS();
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
		
		ArrayList<Integer> res= dfsAndbfs.breadtheFrist(root);
		System.out.println("=====================");
		System.out.println(res.toString());
		
	
	}
  
}
