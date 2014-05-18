package com.Alogrithm.Microsoft.Inteview.test;



public class TestMaxSubMatrix {

	/**see http://blog.csdn.net/zhanxinhang/article/details/6731134
	 * Q35
求一个矩阵中最大的二维矩阵 ( 元素和最大 ). 如 :
1 2 0 3 4
2 3 4 5 1
1 1 5 3 0
中最大的是 :
4 5
5 3
three solutions:
1.brutalFind:calculate all the possible sum and find the largest
2.verticalFind:when matrix's rowIndex is larger than columnIndex,like "int[][] b" in the following code
3.herizonalFind:when matrix's rowIndex is smaller than columnIndex,like "int[][] a" in the following code
both 2 and 3 avoid duplicate calculation
	 */
	public static void main(String[] args) {
		TestMaxSubMatrix msm=new TestMaxSubMatrix();
		int[][] a={
				{2,3,4},
		        {1,3,3},
		        {1,4,6},
		        {1,4,8},
		        {2,3,2},
		};
		int[][] b={
				{1, 2, 0, 3, 4},
		        {2, 3, 4, 5, 1},
		        {1, 1, 5, 3, 0},
		};
		
		int[][] result=msm.findSumMaxSubMatrix(a);
		msm.printArray(result);
		System.out.println("----------------");
		result=msm.brutalFind(a);
		msm.printArray(result);
		System.out.println("----------------");
		
		result=msm.findSumMaxSubMatrix(b);
		msm.printArray(result);
		System.out.println("----------------");
		result=msm.brutalFind(b);
		msm.printArray(result);
	}
	
	public int[][] findSumMaxSubMatrix(int[][] a) {
		int[][] result = null;
		int row = a.length;
		int col = a[0].length;
		if (row >= col) {
			result = herizonalFind(a, row, col);
		} else {
			result = verticalFind(a, row, col);
		}
		return result;
	}
	
	public int[][] brutalFind(int[][] a){
		int[][] result=new int[2][2];
		int row=a.length;
		int col=a[0].length;
		int sum=0;
		int p=0;
		int q=0;
		for(int i=0;i<row-1;i++){
			for(int j=0;j<col-1;j++){
				int x=a[i][j];
				int y=a[i][j+1];
				int z=a[i+1][j];
				int k=a[i+1][j+1];
				int temp=x+y+z+k;
				if(temp>sum){
					sum=temp;
					p=i;
					q=j;
				}
			}
		}
		result[0][0]=a[p][q];
		result[0][1]=a[p][q+1];
		result[1][0]=a[p+1][q];
		result[1][1]=a[p+1][q+1];
		return result;
	}
	
	public int[][] herizonalFind(int[][] a,int row,int col){
		int[][] result=new int[2][2];
		int lastHerizonalSum=a[0][0]+a[0][1];
		int sum=0;
		int p=0;
		int q=0;
		for(int i=1;i<row;i++){
			for(int j=0;j<col-1;j++){
				int temp=lastHerizonalSum+a[i][j]+a[i][j+1];
				lastHerizonalSum=a[i][j]+a[i][j+1];
				if(temp>sum){
					sum=temp;
					p=i;
					q=j;
				}
			}
		}
		result[0][0]=a[p-1][q];
		result[0][1]=a[p-1][q+1];
		result[1][0]=a[p][q];
		result[1][1]=a[p][q+1];
		return result;
	}
	
	public int[][] verticalFind(int[][] a,int row,int col){
		int[][] result=new int[2][2];
		int lastVerticalSum=a[0][0]+a[1][0];
		int sum=0;
		int p=0;
		int q=0;
		for(int i=0;i<row-1;i++){
			for(int j=1;j<col;j++){
				int temp=lastVerticalSum+a[i][j]+a[i+1][j];
				lastVerticalSum=a[i][j]+a[i+1][j];
				if(temp>sum){
					sum=temp;
					p=i;
					q=j;
				}
			}
		}
		result[0][0]=a[p][q-1];
		result[0][1]=a[p][q];
		result[1][0]=a[p+1][q-1];
		result[1][1]=a[p+1][q];
		return result;
	}
	
	public void printArray(int[][] a){
		int row=a.length;
		int col=a[0].length;
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
}

