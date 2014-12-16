package com.liuxiangwin.algor.leetcode.graphic;

import com.liuxiangwin.algor.leetcode.uitl.ArrayUtil;

public class SetColRowZero {
	
	public static void setColRowZero(int[][] matrix){
		boolean[] row = new boolean[matrix.length];
		
		boolean[] col = new boolean[matrix[0].length];
		
		for(int i=0; i<matrix.length;i++)
		{
			for(int j=0;j<matrix[0].length;j++)
			{
				if(matrix[i][j]==0)
				{
					row[i]= true;
					col[j] = true;
				}
			}
		}
		
		for(int i=0; i<matrix.length;i++)
		{
			for(int j=0;j<matrix[0].length;j++)
			{
				if(row[i]|| col[j]){
					matrix[i][j]=0;
				}
			}
		}
	}
	public static void main(String[] args) {
		int [][] a = { { 1, 2,7, 8 }, { 3, 4, 5, 6 }, 
				{ 7, 8, 0,10},{ 5, 8, 6 ,12},
				};
		
		ArrayUtil.printMatrix(a);
		System.out.println("-------------------");
		setColRowZero(a);
		ArrayUtil.printMatrix(a);
		
	}

}
