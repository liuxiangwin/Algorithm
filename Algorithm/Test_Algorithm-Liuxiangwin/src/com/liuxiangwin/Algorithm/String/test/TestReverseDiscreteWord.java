package com.liuxiangwin.Algorithm.String.test;

import java.util.Arrays;

public class TestReverseDiscreteWord {

	/**
	 * Attention this case the String array is a char array
	 */
	public static void main(String[] args) {
		char[] sentense = { 'i', ' ', 'l', 'o', 'v', 'e', ' ', 'y', 'o', 'u' };

		System.out.println("Before reverse" + Arrays.toString(sentense));

		reverse(sentense, 0, sentense.length - 1);

		System.out.println("After reverse" + Arrays.toString(sentense));

		char[] testSentense2 = { 'i', ' ', 'l', 'o', 'v', 'e', ' ', 'y', 'o',
				'u' };

		reverseWordByBlank(testSentense2);

		System.out.print("After reverse Word by blank "
				+ Arrays.toString(testSentense2));

		char[] newTest = "the sky is blue".toCharArray();

		reverseWordByBlank(newTest);
		System.out.println(Arrays.toString(newTest));

		lengthOfLongestSubstring();

		// return "blue is sky the".
		String reveseEachWord =  new TestReverseDiscreteWord.ReverseWordI().reveseEachWord("the sky is blue");
		System.out.println("reveseEachWord -- " + reveseEachWord);
		
		// return "Immutable is String".
		reveseEachWord = new TestReverseDiscreteWord.ReverseWordII().reverseWords("String is Immutable");
		System.out.println("reveseEachWord -- " + reveseEachWord);
		
	}

	private static void reverse(char[] src, int start, int end) {

		while (start < end) {
			char temp = src[start];
			src[start] = src[end];
			src[end] = temp;
			start++;
			end--;
		}

	}

	// reverse the each word before the blank
	private static void reverseWordByBlank(char[] string) {
		int i = 0;
		int start = 0;
		while (i < string.length) {
			if (string[i] != ' ') {
				i++;
			} else {
				reverse(string, start, i);
				start = i + 1;
				System.out.println("" + Arrays.toString(string));
			}
		}

	}
    /**
     * Given an input string, reverse the string word by word.
		For example,
		Given s = "the sky is blue",return "blue is sky the".
		这里采用将每个遇到单词翻转过来
		 然后将整个字符串翻转。注意翻转时候使用方法的坐标不要越界
     * @author liuxiangwin     *
     */
	public static class ReverseWordI {
		public static String reveseEachWord(String string) {
			int star = 0;		
			char[] cArray = string.toCharArray();
			/*int j = 0;
			 * while (j < string.length()) {
				if (cArray[j] == ' ') {
					reverse(cArray, star, j - 1);
					star = j + 1;
				}
				if (j == string.length() - 1) {
					reverse(cArray, star, j);
				}
				j++;
			}*/
			
			for (int i = 0, j = 0; j <= cArray.length; j++) {
				if (j == cArray.length || cArray[j] == ' ') {
					reverse(cArray, i, j-1);
					i = j + 1;
				}
			}
			
			int start = 0;
			int end = cArray.length-1;
			while (start < end) {
				char temp = cArray[start];
				cArray[start] = cArray[end];
				cArray[end] = temp;
				start++;
				end--;
			}
			return String.valueOf(cArray);
		}
	}

	/**
	 * Reverse Words in a String很类似，但是这里要求in-place， 
	 * 也就是说不需要开辟额外空间。
	 * 第一步就是将整个字符串翻转。然后从头逐步扫描，将每个遇到单词再翻转过来。
	 * 
	 * @author liuxiangwin *
	 */
	public static class ReverseWordII {
		public String reverseWords(String string) {
			char[] s = string.toCharArray();
			reverse(s, 0, s.length);
			for (int i = 0, j = 0; j <= s.length; j++) {
				if (j == s.length || s[j] == ' ') {
					reverse(s, i, j);
					i = j + 1;
				}
			}
			return String.valueOf(s);
		}

		private void reverse(char[] s, int begin, int end) {
			for (int i = 0; i < (end - begin) / 2; i++) {
				char temp = s[begin + i];
				s[begin + i] = s[end - i - 1];
				s[end - i - 1] = temp;
			}
		}
	}

	public static void lengthOfLongestSubstring() {
		String str = "abcbcbd";
		String sb = "";

		for (int i = 0; i < str.length(); i++) {

			if (sb.indexOf(str.charAt(i)) == -1) {
				sb += str.charAt(i);
			} else
				break;
		}
		System.out.println("Substring: " + sb + " Length: " + sb.length());
	}

}
