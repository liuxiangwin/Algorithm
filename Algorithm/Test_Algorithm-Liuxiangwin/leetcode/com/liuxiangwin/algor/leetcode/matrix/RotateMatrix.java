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
	
	//[discurs]
	//(1) write your matrix on a paper.
	//(2) flip (not rotate) the paper upside down. (reverse)
	//(3) flip again, but this time bottom edge to the right. (swap)
	//123     789    741
	//456  ¡ª> 456 ¡ª> 852 ¡ª>OK
	//789     123    963
	
	private void rotate(int[][] matrix) 
    {
        int m = matrix.length; 
        if(m == 0) 
        	return;
        int n = matrix[0].length;
        //std::reverse(matrix.begin(), matrix.end());
        for(int i = 0; i < m; i++)
            for(int j = 0; j < i; j++){}
                //std::swap(matrix[i][j], matrix[j][i]);
    }
	
	public static void main(String[] args) {
		int[][] matrix = AssortedMethods.randomMatrix(4, 4, 0, 9);
		ArrayUtil.printMatrix(matrix);
		rotate(matrix, 4);
		System.out.println();
		ArrayUtil.printMatrix(matrix);
	}

}
