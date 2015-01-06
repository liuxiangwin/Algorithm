package com.liuxiangwin.algor.leetcode.tree;

import java.util.ArrayList;

import com.liuxiangwin.algor.leetcode.uitl.BinaryTreeUtil;
import com.liuxiangwin.algor.leetcode.uitl.TreeNode;

public class CheckPathSumWithTarget {

	
	
	/**
	 * Definition for binary tree
	 * struct TreeNode {
	 *     int val;
	 *     TreeNode *left;
	 *     TreeNode *right;
	 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
	 * };
	 */  
	  
	  public boolean hasPathSum(TreeNode node, int target,int sum) {
	        // Start typing your C/C++ solution below
	        // DO NOT write int main() function
		  if (node == null) {
			  return false;
		  }
		  if (node.left == null && node.right == null){
	            return sum + node.val == target;
		  }	               
	      return hasPathSum(node.left, target, sum + node.val)
	            || hasPathSum(node.right, target, sum + node.val);
	    }
	  
	  
	private void findRoute(TreeNode node, int sum,ArrayList<Integer> respath)
	{		
		respath.add(node.val);
		sum -= node.val;
		if(node.left == null&& node.right == null){
			if(sum == 0){
				System.out.println(respath.toString());
			}
		}
		else{
			if(node.left!=null){
				findRoute(node.left, sum, respath);
			}
			if(node.right!=null){
				findRoute(node.right, sum, respath);
			}
		}
		//这里remove掉最后的元素是由于运行到这里说明没有匹配成功，则应去除最后的节点
		respath.remove(respath.size()-1);
	}
	
	  public static void main(String[] args) {
		  CheckPathSumWithTarget checkPathSum = new CheckPathSumWithTarget();
			TreeNode root = new TreeNode(5);
			TreeNode n2 = new TreeNode(4);
			TreeNode n3 = new TreeNode(8);			
			root.left = n2;
			root.right = n3;
			
			TreeNode n4 = new TreeNode(11);
			TreeNode n5 = new TreeNode(13);
			TreeNode n6 = new TreeNode(4);
			TreeNode n7 = new TreeNode(7);
			TreeNode n8 = new TreeNode(2);
			TreeNode n9 = new TreeNode(5);
			
			n2.left=n4;
			n4.left=n7;
			n4.right=n8;
			
			n3.left= n5;
			n3.right= n6;
			
			n6.right=n9;
			
			BinaryTreeUtil.printNode(root);
			
			System.out.println(checkPathSum.hasPathSum(root,22,0));
			
			ArrayList<Integer> respath = new ArrayList<Integer>(); 
			checkPathSum.findRoute(root, 22, respath);
			
			new findAllSum().findSum(root, 22);
	  }
	
}
class findAllSum{
	public static void findSum(TreeNode node, int sum) {
		int depth = depth(node);
		int[] path = new int[depth];
		findSum(node, sum, path, 0);
	}
	
	public static void findSum(TreeNode node, int sum, int[] path, int level) {
		if (node == null) {
			return;
		}		
		path[level] = node.val;
		
		int t = 0;
		for (int i = level; i >= 0; i--){
			t += path[i];
			if (t == sum) {
				print(path, i, level);
			}
		}
		
		findSum(node.left, sum, path, level + 1);
		findSum(node.right, sum, path, level + 1);
		
		/* Remove current node from path.
		 *  Not strictly necessary, since we would
		 * ignore this value, but it's good practice.
		 */
		path[level] = Integer.MIN_VALUE; 
	}
	
	public static int depth(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + Math.max(depth(node.left), depth(node.right));
		}
	}
	private static void print(int[] path, int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}

}