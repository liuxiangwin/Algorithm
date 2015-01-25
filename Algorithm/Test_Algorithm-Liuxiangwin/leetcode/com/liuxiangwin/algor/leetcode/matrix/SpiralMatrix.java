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
// ���ת�����ĸ�״̬�����������ң����£��������ϡ�
// ���ת��״̬�ı仯��������������1. �����Ͻ磨n��2.�����½磨0��3.������һ��λ���Ѿ����������ݴ˱��롣
public class SpiralMatrix {	

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

			for (int i = beginY; i <= endY; i++) {
				result.add(matrix[i][endX]);
			}
			if (--endX < beginX) {
				break;
			}
			for (int i = endX; i >= beginX; i--) {
				result.add(matrix[endY][i]);
			}
			if (--endY < beginY) {
				break;
			}
			for (int i = endY; i >= beginY; i--) {
				result.add(matrix[i][beginX]);
			}
			if (++beginX > endX) {
				break;
			}
		}
		return result;
	}

	public static void main(String args[]) {
		int[][] array = { { 1, 2, 3 ,4}, {  5, 6,7,8 }, { 9,10, 11,12 }, { 13,14, 15,16 }};
		SpiralMatrix spriMatrix = new SpiralMatrix();
		ArrayList<Integer> result = spriMatrix.spiralOrder2(array);
		System.out.println(result.toString());
	}
}