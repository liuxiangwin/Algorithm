package com.liuxiangwin.Algorithm.Number.test;

public class TestFindNumberInMatrix {
  /**
   * 
   * 
   * ����ֱ�Ӷ�λ�������Ͻǵ�Ԫ�أ������Զ��ֲ��ң���Ҫ�ҵ�����6����������ߣ�
   * ��Ҫ������6����С�������ߣ�ֱ���ҵ�Ҫ�ҵ����֣�6��Ϊֹ�����������ʱ�临�Ӷ�O��m+n��������ͼ��ʾ�� 
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
