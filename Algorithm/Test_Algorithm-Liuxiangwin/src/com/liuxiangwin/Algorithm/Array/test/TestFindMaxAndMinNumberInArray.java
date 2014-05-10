package com.liuxiangwin.Algorithm.Array.test;

public class TestFindMaxAndMinNumberInArray {

	/**
	 * @param args
	 * Allocate the max and min intital value is 
	 */
	public static void main(String[] args) {
		int[] array = new int[] { 9, 2, 6, 7, 8};		
		int i=0 ;
		
		int max= Integer.MIN_VALUE;
		while(i+1<array.length-1){
			
			max = max(max,max(array[i],array[i+1]));
			i++;
		}
		
		int j= array.length-1 ;		
		int min= array[array.length-1];
		while(j-1 >=0){
			
			min = min(min,min(array[j],array[j-1]));
			j--;
		}
		
		System.out.println("the max number is " +  max );
		System.out.println("the min number is " +  min );
		
	}
    
	
	private static int max(int x, int y) {
		return x >= y ? x : y;
	}

	private static int min(int x, int y) {
		return x <= y ? x : y;
	}
}
