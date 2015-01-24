package com.liuxiangwin.algor.leetcode.matrix;

import java.util.ArrayList;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * For example, Given the following matrix:
 * 
 * [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ]
 * 
 * You should return [1,2,3,6,9,8,7,4,5].
 */
// 光标转移有四个状态，依次是向右，向下，向左，向上。
// 光标转移状态的变化根据三个条件：1. 到达上界（n）2.到达下界（0）3.光标的下一个位置已经被填满。据此编码。
public class SpiralMatrix {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (matrix.length == 0)
			return list;
		int beginX = 0, endX = matrix.length - 1;
		int beginY = 0, endY = matrix[0].length - 1;
		while (true) {
			for (int i = beginY; i <= endY; i++) {
				list.add(matrix[beginX][i]);
			}
			if (++beginX > endX)
				break;
			for (int i = beginX; i <= endX; i++) {
				list.add(matrix[i][endY]);
			}
			if (beginY > --endY)
				break;
			for (int i = endY; i >= beginY; i--) {
				list.add(matrix[endX][i]);
			}
			if (beginX > --endX)
				break;
			for (int i = endX; i >= beginX; i--) {
				list.add(matrix[i][beginY]);
			}
			if (++beginY > endY)
				break;
		}
		return list;
	}

	public ArrayList<Integer> spiralOrder2(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (matrix == null || matrix.length == 0) {
			return result;
		}

		int beginX = 0;	int endX = matrix[0].length - 1;

		int beginY = 0; int endY = matrix.length - 1;

		while (true) {
			for (int i = beginX; i <= endX; i++) {
				result.add(matrix[beginY][i]);
			}
			if (++beginY > endY) {
				break;
			}

			for (int row = beginY; row <= endY; row++) {
				result.add(matrix[row][endX]);
			}
			if (--endX < beginX) {
				break;
			}
			for (int col = endX; col >= beginX; col--) {
				result.add(matrix[endY][col]);
			}
			if (--endY < beginY) {
				break;
			}
			for (int row = endY; row >= beginY; row--) {
				result.add(matrix[row][beginX]);
			}
			if (++beginX > endX) {
				break;
			}
		}
		return result;
	}

	private void method() {
		int n = 4; // matrix size

		int a[][] = new int[n][n];
		int c = 1;
		for (int i = n - 1, j = 0; i > 0; i--, j++) {
			for (int k = j; k < i; k++) {
				a[j][k] = c++;
			}
			for (int k = j; k < i; k++) {
				a[k][i] = c++;
			}
			for (int k = i; k > j; k--) {
				a[i][k] = c++;
			}
			for (int k = i; k > j; k--) {
				a[k][j] = c++;
			}
		}
	}

	public static void main(String args[]) {
		int[][] array = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, };
		SpiralMatrix spriMatrix = new SpiralMatrix();
		ArrayList<Integer> result = spriMatrix.spiralOrder(array);
		System.out.println(result.toString());
	}
}