package com.liuxiangwin.algor.leetcode.uitl;

import com.liuxiangwin.algor.leetcode.graphic.WhetherRouteTwoNodes;

public class Node {
	private Node adjacentNodes[];
	public int adjacentCount;
	private String vertex;
	public WhetherRouteTwoNodes.State state;

	public Node(String vertex, int adjacentLength) {
		this.vertex = vertex;
		adjacentCount = 0; 
		adjacentNodes = new Node[adjacentLength];
	}

	public void addAdjacent(Node x) {
		if (adjacentCount < 30) {
			this.adjacentNodes[adjacentCount] = x;
			adjacentCount++;
		} else {
			System.out.print("No more adjacent can be added");
		}
	}

	public Node[] getAdjacent() {
		return adjacentNodes;
	}

	public String getVertex() {
		return vertex;
	}
}
