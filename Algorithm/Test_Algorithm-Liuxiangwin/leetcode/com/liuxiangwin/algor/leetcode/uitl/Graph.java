package com.liuxiangwin.algor.leetcode.uitl;

public class Graph {
	private Node vertices[];
	public int count;

	public Graph(int number) {
		vertices = new Node[number];
		count = 0;
	}

	public void addNodes(Node node) {
		if (count < 30) {
			vertices[count] = node;
			count++;
		} else {
			System.out.print("Graph full");
		}
	}

	public Node[] getNodes() {
		return vertices;
	}
}
