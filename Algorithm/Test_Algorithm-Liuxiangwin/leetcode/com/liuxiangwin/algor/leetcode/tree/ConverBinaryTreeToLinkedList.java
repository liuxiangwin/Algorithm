package com.liuxiangwin.algor.leetcode.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


import java.util.Stack;

import com.liuxiangwin.algor.leetcode.uitl.BinaryTreeUtil;
import com.liuxiangwin.algor.leetcode.uitl.ListNode;
import com.liuxiangwin.algor.leetcode.uitl.TreeNode;

public class ConverBinaryTreeToLinkedList {

	public ListNode inorderTraversal(TreeNode root) {       

        ListNode head = new ListNode(0);    
        ListNode curr = head;
      
        if(root == null)
            return head.next; 
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        TreeNode current = root;
        while(!nodeStack.empty() || current != null){ 
            if(current != null){
                nodeStack.push(current);
                current = current.left;
 
            }else{
                TreeNode t = nodeStack.pop();         
                //result.add(t.val);
                curr.next = new ListNode(0);
                curr.next.val = t.val;                
                curr = curr.next;
                current = t.right;
            }
        }
 
        return head.next;
    }
	
	public ArrayList<Integer> inorderTraversal2(TreeNode root) {
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
	
	public static void printTree(ArrayList<LinkedList<TreeNode>> result){
		int depth = 0;
		for(LinkedList<TreeNode> entry : result) {
			Iterator<TreeNode> i = entry.listIterator();
			System.out.print("Link list at depth " + depth + ":");
			while(i.hasNext()){
				System.out.print(" " + ((TreeNode)i.next()).val);
			}
			System.out.println();
			depth++;
		}
	}

	public static void printLinkNode(ListNode node) {
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode n2 = new TreeNode(6);
		TreeNode n3 = new TreeNode(14);
		root.right = n3;
		root.left = n2;
		
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(8);
		TreeNode n6 = new TreeNode(12);
		TreeNode n7 = new TreeNode(16);
		
		n3.left= n6;
		n3.right= n7;
		
		n2.left=n4;
		n2.right=n5;
		
		BinaryTreeUtil.printNode(root);
		
		ConverBinaryTreeToLinkedList toLinkedList = new ConverBinaryTreeToLinkedList();
		
		ListNode result= toLinkedList.inorderTraversal(root);
		printLinkNode(result);
		
		ArrayList<Integer> result2 = toLinkedList.inorderTraversal2(root);
		System.out.println("ÖÐÐò±éÀú·ÇµÝ¹é "+result2.toString());
		
	}

}
