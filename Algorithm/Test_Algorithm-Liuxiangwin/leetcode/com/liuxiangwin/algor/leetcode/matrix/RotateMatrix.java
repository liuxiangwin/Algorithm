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
	public static void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
    		for (int j = 0; j < Math.ceil(((double) n) / 2); j++) {
    			int temp = matrix[i][j];
    			matrix[i][j] = matrix[n-1-j][i];
    			matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
    			matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
    			matrix[j][n-1-i] = temp;
    		}
    	}
        
        
        for(int layer = 0; layer < n/2; layer++){
            for(int i = layer; i < n-1-layer; i++){//避免重复处理n-1-layer
                int leftTop = matrix[layer][i];//注意二维矩阵的(i,j)index与数学坐标(x,y)中是相反的
                matrix[layer][i] = matrix[n-1-i][layer]; //先在纸上想清楚赋值的先后循序
                matrix[n-1-i][layer] = matrix[n-1-layer][n-1-i];
                matrix[n-1-layer][n-1-i] = matrix[i][n-1-layer];
                matrix[i][n-1-layer] = leftTop;
            }
        }
    }
	
	//[discurs]
	//(1) write your matrix on a paper.
	//(2) flip (not rotate) the paper upside down. (reverse)
	//(3) flip again, but this time bottom edge to the right. (swap)
	//123     789    741
	//456  —> 456 —> 852 —>OK
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
		
		
		System.out.println("-----------------------------------");
		int[][] matrix2 = AssortedMethods.randomMatrix(4, 4, 0, 9);
		ArrayUtil.printMatrix(matrix2);
		rotate2(matrix2);
		System.out.println();
		ArrayUtil.printMatrix(matrix2);
		
		
	}

}
