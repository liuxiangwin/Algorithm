package com.liuxiangwin.Algorithm.Number.test;

public class TestFindNumberInMatrix {
  /**
   * 
   * 
   * 首先直接定位到最右上角的元素，再配以二分查找，比要找的数（6）大就往左走，
   * 比要找数（6）的小就往下走，直到找到要找的数字（6）为止，这个方法的时间复杂度O（m+n）。如下图所示： 
     img
   * 
   * 
   * @param array
   * @param searchKey
   * @return
   */
	private  boolean YoungMatrix(int[][] array, int searchKey){
	    int i = 0, j = array[0].length-1;
	    int row = array.length;
	  
	    int var = array[i][j];
	    while (true){
	        if (var == searchKey)
	            return true;
	        else if (searchKey > var && i < row - 1)
	            var = array[++i][j];
	        else if (searchKey < var && j > 0)
	            var = array[i][--j];
	        else
	            return false;
	    }
	}
	
	
}
