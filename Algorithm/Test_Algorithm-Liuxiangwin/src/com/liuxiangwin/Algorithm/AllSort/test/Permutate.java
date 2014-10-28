package com.liuxiangwin.Algorithm.AllSort.test;

import java.util.Arrays;

public class Permutate {
	/**
	 * �ַ���abc����ȫ����Ϊ�������ǿ�����ô������abcΪ��

	�̶�a�������bc�����У�abc��acb����ú�a��b�������õ�bac
	�̶�b�������ac�����У�bac��bca����ú�c�ŵ���һλ�ã��õ�cba
	�̶�c�������ba�����У�cba��cab��
	
	
	http://taop.marchtea.com/01.06.html
	 */
	public static int total = 0;
	
	public static void main(String[] args) {
		String str[] = { "a", "b", "c" };
		CalcAllPermutation(str, 0, str.length);
		System.out.println(total);
		
	}



	public static void CalcAllPermutation(String[] string, int from, int length) {
		if (from == length - 1) {
			printArray(string);
			total++;
		} else {
			for (int i = from; i < length; i++) {
				swap(from, i, string);
				CalcAllPermutation(string, from + 1, length);
				swap(from, i, string);
			}
		}
	}
	
	public static void swap( int i, int j,String[] str) {
		String temp = new String();
		temp = str[i];
		str[i] = str[j];
		str[j] = temp;
	}

	
	private static void printArray(String[] strArray) {
		System.out.println( Arrays.toString(strArray));
	}
}
