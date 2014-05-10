package com.liuxiangwin.util;

import java.util.Arrays;

public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
         int[] array={2010,2012};
         System.out.println(Arrays.toString(array));
         swap(array,0,1);
         System.out.println(Arrays.toString(array));
         
         
	}
	
	public static void swap(int[] array,int i,int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
