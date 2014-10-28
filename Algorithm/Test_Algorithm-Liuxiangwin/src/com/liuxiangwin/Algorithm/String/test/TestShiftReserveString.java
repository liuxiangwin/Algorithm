package com.liuxiangwin.Algorithm.String.test;

import java.util.Arrays;

public class TestShiftReserveString {

	/**
	 *            -->(a b) (c d e f) 
	 * leftExpect*
	 * ------>    (c d e f)(a b)
	 *         (ba)(fedc)--(cdefab) 
	 *         
	 *        
	 *         reverse(0 rotate-1);
	 *         reverse(rotate stringLength);
	 *         reverse(0 stringLength);
	 *         
	 *         (a b c d)( e f)-->
	 * rigthExpect* 
	 * ------> (e f)(a b c d)
	 *        
	 *         (dcba)(fe)--(efabcd)
	 *         
	 *         reverse(0 rotate-1);
	 *         reverse(rotate stringLength);
	 *         reverse(0 stringLength);
	 *         
	 *     TimeComplextiy 时间复杂度为O(n)，Space空间复杂度为O(1)，
	 */
	public static void main(String[] args) {
		int[] testArray1 = { 5, 7, 0, 9, 3, 2, 0 };
		rightShift(testArray1, 2);
		System.out.println("rightShift " + Arrays.toString(testArray1));

		int[] testArray2 = { 5, 7, 0, 9, 3, 2, 0 };
		rightShiftByWhile(testArray2, 2);
		System.out.println("rightShift by while " + Arrays.toString(testArray2));
		
		String testArray3 = "5709320";
		rightCharShiftByWhile(testArray3.toCharArray(), 2);
		System.out.println("rightCharShiftByWhile " + Arrays.toString(testArray2));
		
		
		char[] testArray4 = "abcdef".toCharArray();
		leftShift(testArray4,2);
		System.out.println("leftShit " + Arrays.toString(testArray4));
		
		
		System.out.println(rotateSentence("I am a student.".toCharArray()));
	}
	
	
	private static void rightShift(int[] array, int rotateNum) {
		if (rotateNum < 0) {
			return;
		}
		reserve(array, 0, array.length - 1);
		reserve(array, 0, rotateNum - 1);
		reserve(array, rotateNum, array.length - 1);
		
	}
     
	private static void leftShift(char[] array, int rotateNum) {
		if (rotateNum < 0) {
			return;
		}
		reverseCharByWhile(array, 0, array.length - 1);
		reverseCharByWhile(array, 0, array.length - rotateNum-1);
		reverseCharByWhile(array, array.length - rotateNum, array.length - 1);
		
	}
	
	
	public static char[] rotateSentence(char[] sentence) {
        int start = 0;
        int end = 0;
        int i = 0;
        while (i < sentence.length) {
            // 空格是单词的分隔符
            while (i < sentence.length && sentence[i] != ' ') {
                i++;
            }
            end = i - 1;
            sentence = rotate(sentence, start, end);        // 旋转一个单词
            start = (++i);
        }
        sentence = rotate(sentence, 0, sentence.length - 1);    // 翻转整个句子
        return sentence;
    }
	
	
	
	private static void rightShiftByWhile(int[] array, int rotateNum) {

		if (rotateNum < 0) {
			return;
		}
		reverseByWhile(array, 0, array.length - 1);
		reverseByWhile(array, 0, rotateNum - 1);
		reverseByWhile(array, rotateNum, array.length - 1);
		
	}

	private static void reserve(int[] array, int startIndex, int endIndex) {
		for (int i = 0; i < (endIndex - startIndex + 1) / 2; i++) {
			// for (int i = 0; i < array.length -1/ 2; i++) {
			int tmp = array[startIndex + i];
			array[startIndex + i] = array[endIndex - i];
			array[endIndex - i] = tmp;
		}
	}

	private static void reverseByWhile(int[] string, int start, int end) {

		while (start < end) {
			int temp = string[start];
			string[start] = string[end];
			string[end] = temp;
			start++;
			end--;
		}

	}
	
	private static void rightCharShiftByWhile(char[] array, int rotateNum) {

		if (rotateNum < 0) {
			return;
		}
		reverseCharByWhile(array, 0, array.length - 1);
		reverseCharByWhile(array, 0, rotateNum - 1);
		reverseCharByWhile(array, rotateNum, array.length - 1);
		
	}
	
	
	private static void reverseCharByWhile(char[] charArray, int start, int end) {

		while (start < end) {
			char temp = charArray[start];
			charArray[start] = charArray[end];
			charArray[end] = temp;
			start++;
			end--;
		}

	}
	
	 private static char[] rotate(char[] str, int start, int end) {
	        while (start < end) {
	            char tmp = str[start];
	            str[start] = str[end];
	            str[end] = tmp;
	            start++;
	            end--;
	        }
	        return str;
	    }
}
