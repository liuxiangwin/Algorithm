package com.liuxiangwin.algor.leetcode.string;

public class FirstAppearChar {

	public char firstOnlyCharacter(String A) {
		int[] array = new int[256];
		//A到Z对应的256个字符，重复的字符位置就加一
		//store the characters in A to array
		for (int i = 0; i < A.length(); i++) {
			array[A.charAt(i)] += 1;
		}

		//遍历字符以后第一个1就是要找的结果
		//get the first charater with only one appearance in A
		for (int i = 0; i < A.length(); i++) {
			if (array[A.charAt(i)] == 1) 
				return A.charAt(i);
		}
		
		return 0;
	}

	public static void main(String[] args) {
		FirstAppearChar  fisAppearChar = new FirstAppearChar();
		System.out.println(fisAppearChar.firstOnlyCharacter("abaccdeff"));
	}

}
