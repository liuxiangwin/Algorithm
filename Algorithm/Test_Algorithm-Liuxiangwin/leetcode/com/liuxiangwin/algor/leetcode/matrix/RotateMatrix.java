package com.liuxiangwin.algor.leetcode.matrix;

import com.liuxiangwin.algor.leetcode.uitl.ArrayUtil;
import com.liuxiangwin.multithreading.lock.AssortedMethods;

public class RotateMatrix {
	
	public static void rotate(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i]; // save top

				// left -> top
				matrix[first][i] = matrix[last-offset][first]; 			

				// bottom -> left
				matrix[last-offset][first] = matrix[last][last - offset]; 

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last]; 

				// top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}
	}
	
	
	public static void main(String[] args) {
		int[][] matrix = AssortedMethods.randomMatrix(4, 4, 0, 9);
		ArrayUtil.printMatrix(matrix);
		rotate(matrix, 4);
		System.out.println();
		ArrayUtil.printMatrix(matrix);
	}

}
