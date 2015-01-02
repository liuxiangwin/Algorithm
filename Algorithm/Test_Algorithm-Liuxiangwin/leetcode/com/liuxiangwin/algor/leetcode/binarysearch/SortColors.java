package com.liuxiangwin.algor.leetcode.binarysearch;

import java.io.Console;
import java.util.Arrays;
import java.util.Random;

import com.liuxiangwin.Algorithm.Sort.test.TestQucikSort;

public class SortColors {

	public void sortColors(int[] A) {
		if (A == null || A.length == 0)
			return;
		int[] res = new int[A.length];
		int[] helper = new int[3];
		for (int i = 0; i < A.length; i++) {//记录每个元素出现次数
			helper[A[i]]++;
		}
		for (int i = 1; i < 3; i++) {
			helper[i] = helper[i] + helper[i - 1];//记录每个元素需要的位置数
		}
		for (int i = A.length - 1; i >= 0; i--) {
			res[helper[A[i]] - 1] = A[i];//根据个数其实和位置数放入元素
			helper[A[i]]--;
		}
		for (int i = 0; i < A.length; i++) {
			A[i] = res[i];
		}
	}
	
	public static void countSort(int[] arr, int k)
    {

        int[] C = new int[k + 1];

        for (int j = 0; j < arr.length; j++)
        {
            C[arr[j]]++;//出现次数 key为元素本身
        }

        int z = 0;
        for (int i = 0; i <= k; i++)//遍历辅助数组 
        {
            while (C[i]-- > 0)
            {
                arr[z++] = i;//辅助数组的下标就是元素
            }
        }
    }
	
	//http://blog.csdn.net/shiquxinkong/article/details/18627339
   public void sortColors2(int arr[]) {
	       int low = 0;
	       int index = 0;
	       int high = arr.length - 1;
	       for(; index <= high;){
	           if(arr[index] == 0){//red
	             swap(arr,low++, index++);
	             }
	           else if(arr[index] == 2){//blue
	             swap(arr,index, high--);
	             }
	           else{ 
	        	   ++index;//write
	           }
	       }
	    }
	private void swap(int[] arr,int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	
/**
 * oogle
https://1024.bz/


http://blog.csdn.net/joe_007/article/details/12952821

http://compsci.ca/v3/viewtopic.php?t=18782

http://blog.itpub.net/7899089/viewspace-736668/



sort color
http://blog.csdn.net/linhuanmars/article/details/24286349

http://heai.info/2014-11/markdown-leetcode-find-minimum-in-rotated-sorted-array-ii/
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortColors sortColors = new SortColors();
		int a[] ={1,1,1,2,2,0,1,1};
	    sortColors.sortColors(a);
	    System.out.println(Arrays.toString(a));
	    System.out.println("------------------------");
	    
	    int b[] ={1,1,1,2,2,0,1,1};
	    System.out.println(Arrays.toString(b));	    
	    sortColors.sortColors2(b);
	    System.out.println(Arrays.toString(b));
	    
	    
	    System.out.println("------------------------");
	    int c[] ={0,1,2,2,0,1};
	    System.out.println(Arrays.toString(c));	    
	    sortColors.sortColors2(c);
	    System.out.println(Arrays.toString(c));
	    
	    SortComparison.sortComparsion();
	}

}
class SortComparison
{
	public static void  sortComparsion() {
		 int[] A = new int[1000000];
         int[] B = new int[1000000];


         for (int i = 0; i < A.length; i++)
         {             
             A[i]=(int)(Math.random()*100);
            	
         }
         B = Arrays.copyOf(A, A.length);
         SortComparison sw = new SortComparison();
         long a = System.currentTimeMillis();
         TestQucikSort quickSort = new TestQucikSort();
         quickSort.quickSort(B, 0, B.length-1);
         long b = System.currentTimeMillis();
         System.out.println("The quick sort time is "+(b-a));

        
         long c = System.currentTimeMillis();
         new SortColors().countSort(A,100);
         long d = System.currentTimeMillis();
         System.out.println("The count sort time is "+(d-c));
         
         //可见计数排序要比快速排序快将近6倍左右。
	}

/**
 * 当数据量越来越大时，

归并排序：比较次数少，速度慢。稳定性：所以排序时稳定的。

快速排序：比较次数多，速度快。 稳定性 即不保序的。

快速排序的优势越来越明显。



原因分析：个人认为是当数据量越来越大时，尽管归并排序的比较次数较少，
但是归并排序后期的合并操作所花费的时间便越来越大，
合并操作对整体的效率影响越来越明显，
包括后面大量数据的赋值操作等。
所以当数据量变大时，不需要专门合并的快速排序的优势就变得越发明显。
 */
}