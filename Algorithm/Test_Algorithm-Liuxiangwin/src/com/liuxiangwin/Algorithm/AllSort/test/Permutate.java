package com.liuxiangwin.Algorithm.AllSort.test;

import java.util.Arrays;

public class Permutate {
	/**
	 * 字符串abc进行全排列为例，我们可以这么做：以abc为例
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
       
         
	固定a，求后面bc的排列：abc，acb，求好后，a和b交换，得到bac
	固定b，求后面ac的排列：bac，bca，求好后，c放到第一位置，得到cba
	固定c，求后面ba的排列：cba，cab。
	
	
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
