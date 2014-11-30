package com.liuxiangwin.algor.leetcode.binarysearch;

public class Searcha2DMatrix {
	
	//解法二、定位法

	//首先直接定位到最右上角的元素，再配以二分查找，比要找的数（6）比现在数大
	//大就往左走
	//，比要找数（6）比现在的数小就往下走，直到找到要找的数字（6）为止，
	//这个方法的时间复杂度O（m+n）。如下图所示： 
	//1  2 < ---8 <-- -9
    //   |	
	//   | 
	//   
	//2  4      9       12
	//   |
	//4  7      10      13
	//   | 
	//----
	//6  8      11      15
	private int[] index= new int[2];
	private boolean YoungMatrix(int [][] array, int searchKey){	   
	   int ROW = array.length;
	   int COL = array[0].length;
	   
	   int i = 0, j = COL -1;
	    int var = array[i][j];
	    while (true){
	        if (var == searchKey)
	        {
	            index[0]=i; 
	            index[1]=j;
	        	return true;
	        }            
	        else if (searchKey > var && i < ROW - 1)
	            var = array[++i][j];
	        else if (searchKey < var && j > 0)
	            var = array[i][--j];
	        else
	            return false;
	    }
	}
	
	
	public static void main(String[] args) {
       int [][] array= {
    		  {1, 2, 8, 9},
    		  {2, 4, 9, 12},
    		  {4, 7, 10, 13},
    	      {6, 8, 11, 15}};
      
       Searcha2DMatrix matrix = new Searcha2DMatrix();
       System.out.println(matrix.YoungMatrix(array, 6));
       System.out.println("The Row is "+ matrix.index[0]+ 
    		               " The Col is "+ matrix.index[1]);
	}

}
