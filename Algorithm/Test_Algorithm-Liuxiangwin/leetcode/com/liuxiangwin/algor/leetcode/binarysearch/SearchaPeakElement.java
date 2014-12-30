package com.liuxiangwin.algor.leetcode.binarysearch;

public class SearchaPeakElement {
//http://www.geeksforgeeks.org/find-a-peak-in-a-given-array/
	/**
	 * 1) If input array is sorted in strictly increasing order, 
	 * the last element is always a peak element. For example, 
	 * 50 is peak element in {10, 20, 30, 40, 50}.
	 * 
		2) If input array is sorted in strictly decreasing order, 
		the first element is always a peak element. 
		100 is the peak element in {100, 80, 60, 50, 20}.
		
		3) If all elements of input array are same, 
		every element is a peak element.
		
		For input array {10, 20, 15, 2, 23, 90, 67}, 
		there are two peak elements: 20 and 90.
		 Note that we need to return any one peak element.
	 * @param arr
	 * @param low
	 * @param high
	 * @param n
	 * @return
	 */
	//The time complexity of the following program is O (log n).
	public static void peak(int[] arr)
    {
        peak(arr, 0, arr.length - 1);
    }    
    public static void peak (int arr[], int low, int high)
    {
        if (low >= high-1)	
            return;
        int mid = (low + high) / 2;
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]){
        	System.out.print(arr[mid] +" ");
        }            
        /* Recursively find other peak elements */        
        peak (arr, low, mid);
        peak (arr, mid, high);    
    }     
	

	public static void main(String args[])
	{
		SearchaPeakElement find = new SearchaPeakElement();
	    int [] array = {26, 20, 15, 50, 40, 60, 25, 90 };		
		peak(array);
		
	}

}