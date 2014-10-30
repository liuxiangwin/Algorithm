package com.liuxiangwin.algor.leetcode.string;

public class FirstAppearChar {

	public char firstOnlyCharacter(String inString) {
		int[] array = new int[256];
		//A��Z��Ӧ��256���ַ����ظ����ַ�λ�þͼ�һ
		//store the characters in A to array
		for (int i = 0; i < inString.length(); i++) {
			array[inString.charAt(i)] += 1;
		}

		//�����ַ��Ժ��һ��1����Ҫ�ҵĽ��
		//get the first charater with only one appearance in A
		for (int i = 0; i < inString.length(); i++) {
			if (array[inString.charAt(i)] == 1) 
				return inString.charAt(i);
		}
		
		return 0;
	}

	public static void main(String[] args) {
		FirstAppearChar  fisAppearChar = new FirstAppearChar();
		System.out.println(fisAppearChar.firstOnlyCharacter("abaccdeff"));
	}

}
