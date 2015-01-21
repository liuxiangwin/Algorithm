package com.liuxiangwin.Algorithm.AllSort.test;

import java.util.Arrays;

public class Permutate {
	/**
	 * �ַ���abc����ȫ����Ϊ�������ǿ�����ô������abcΪ��
                       a       | b        | c
                     /         |              \
          (swap a with a)  (swap a with b)     (swap a with c)                        
              /                 |                 \
             /                  |                  \
          a b c               b a c                c b a
           / \                   |                  /      \
     b with b  b with c     a with a  a with c    b with b   b with a
          /   \                |     |              /         \
       a b c    a c b        b a c  b c a        c b a       c a b
       
         
	�̶�a�������bc�����У�abc��acb����ú�a��b�������õ�bac
	�̶�b�������ac�����У�bac��bca����ú�c�ŵ���һλ�ã��õ�cba
	�̶�c�������ba�����У�cba��cab��
	
	
	http://taop.marchtea.com/01.06.html
	http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
	http://blog.csdn.net/u010500263/article/details/18178243 
	 *
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
