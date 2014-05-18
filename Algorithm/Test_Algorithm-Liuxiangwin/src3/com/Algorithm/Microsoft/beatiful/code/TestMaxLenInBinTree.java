package com.Algorithm.Microsoft.beatiful.code;

import java.util.ArrayList;
import java.util.List;


public class TestMaxLenInBinTree {

	/*
	 a.			1
	 		   /  \
	 		  2    3
	 		 / \  / \
	 		4   5 6  7
	 	max=4	pass "root"
	 	
	 b.			1
	 		   /  \
	 		  2    3
	 		 / \    
	 		4   5    
	 	   /     \
	 	  6       7
	 	 /         \
	 	8           9
	 	max=6. do not pass "root"
	 */
	public static void main(String[] args) {
		int[] array_A = { 1, 2, 3, 4, 5, 6, 7 };
		// store in LevelOrder,Complete Binary Tree. 0==no child
		int[] array_B = { 1, 2, 3, 4, 5, 0, 0, 6, 0, 0, 7, 0, 0, 0, 0, 8, 0, 0, 0, 0,
				0, 0, 9 };
		TestMaxLenInBinTree maxLengthTree = new TestMaxLenInBinTree();
		
		Node aRoot = maxLengthTree.createTree(array_B);
		maxLengthTree.findMaxLen(aRoot);
		System.out.println(maxLengthTree.maxLength);

	}

	private int maxLength=0;
	
	public void findMaxLen(Node node){
		
		if(node==null) return ;
		
		if(node.getLeft()==null){
			node.setMaxLeftLength(0);
		}
		if(node.getRight()==null){
			node.setMaxRightLength(0);
		}
		
		if(node.getLeft()!=null){
			//has left node recursive find left node
			findMaxLen(node.getLeft());
		}
		if(node.getRight()!=null){
			//has right node recursive find right node
			findMaxLen(node.getRight());
		}
		
		if(node.getLeft()!=null){
			int temp=0;
			Node left=node.getLeft();
			if(left.getMaxLeftLength()>left.getMaxRightLength()){
				temp=left.getMaxLeftLength();
			}else{
				temp=left.getMaxRightLength();
			}
			//finally  because the node has left node 
			//so the length need plus 1;
			node.setMaxLeftLength(temp+1);
		}
		if(node.getRight()!=null){
			int temp=0;
			Node right=node.getRight();
			if(right.getMaxLeftLength()>right.getMaxRightLength()){
				temp=right.getMaxLeftLength();
			}else{
				temp=right.getMaxRightLength();
			}
			node.setMaxRightLength(temp+1);
		}
		if(node.getMaxLeftLength()+node.getMaxRightLength()> maxLength){
			maxLength=node.getMaxLeftLength()+node.getMaxRightLength();
		}
	}
	
	public Node createTree(int[] data){
		List<Node> nodeList=new ArrayList<Node>();
		for(int each:data){
			Node n=new Node(each);
			nodeList.add(n);
		}
		int lastRootIndex=data.length/2-1;
		for(int i=0;i<=lastRootIndex;i++){
			Node root=nodeList.get(i);
			Node left=nodeList.get(i*2+1);
			if(left.getData()!=0){
				root.setLeft(left);
			}else{
				root.setLeft(null);
			}
			if(i*2+2<data.length){
				Node right=nodeList.get(i*2+2);
				if(right.getData()!=0){
					root.setRight(right);
				}else{
					root.setRight(null);
				}
			}
			
		}
		Node root=nodeList.get(0);
		return root;
	}
	class Node{
		private int data;
		private Node left;
		private Node right;
		private int maxLeftLength;//the max length of leftTree
		private int maxRightLength;
		
		public Node(int i){
			data=i;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
			this.left=null;
			this.right=null;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		public int getMaxLeftLength() {
			return maxLeftLength;
		}
		public void setMaxLeftLength(int maxLeftLen) {
			this.maxLeftLength = maxLeftLen;
		}
		public int getMaxRightLength() {
			return maxRightLength;
		}
		public void setMaxRightLength(int maxRightLen) {
			this.maxRightLength = maxRightLen;
		}
	}
}

