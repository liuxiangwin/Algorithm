package com.Alogrithm.Microsoft.Inteview.test;

public class TestFindNumberInMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Given a matrix, whose rows and columns (M * N) are sorted. 
	//Suppose if Rows are sorted left to right in ascending order. 
	//Columns are sorted top to bottom in ascending order
	boolean FindElem(int[][] matrix, int elem, int rows, int columns) {
		int rowIndex = 0;
		int colIndex = columns - 1;
		while (rowIndex < rows && colIndex >= 0) {
			if (matrix[rowIndex][colIndex] == elem) {
				return true;
			} else if (matrix[rowIndex][colIndex] > elem) {
				colIndex--;
			} else {
				rowIndex++;
			}
		}
		return false;
	}

}
