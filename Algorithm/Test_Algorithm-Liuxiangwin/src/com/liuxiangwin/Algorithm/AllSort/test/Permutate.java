package com.liuxiangwin.Algorithm.AllSort.test;

import java.util.Arrays;

public class Permutate {
	public static int total = 0;
	
	public static void main(String[] args) {
		String str[] = { "a", "b", "c" };
		arrange(str, 0, str.length);
		System.out.println(total);
		
	}


	public static void arrange(String[] strArray, int start, int length) {
		if (start == length - 1) {
			printArray(strArray);
			total++;
		} else {
			for (int i = start; i < length; i++) {
				swap(strArray, start, i);
				arrange(strArray, start + 1, length);
				swap(strArray, start, i);
			}
		}
	}
	
	private static void printByforLoop(String[] strArray, int length) {
		for (int i = 0; i < length; i++) {
			System.out.print(strArray[i] + "  ");
		}
	}

	public static void swap(String[] str, int i, int j) {
		String temp = new String();
		temp = str[i];
		str[i] = str[j];
		str[j] = temp;
	}

	
	private static void printArray(String[] strArray) {
		System.out.println( Arrays.toString(strArray));
	}
}
