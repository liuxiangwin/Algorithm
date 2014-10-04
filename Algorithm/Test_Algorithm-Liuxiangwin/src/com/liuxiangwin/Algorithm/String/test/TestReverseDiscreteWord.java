package com.liuxiangwin.Algorithm.String.test;

import java.util.Arrays;

public class TestReverseDiscreteWord {

	/**
	 * Attention this case the String array is a char array
	 */
	public static void main(String[] args) {
		char[] sentense = {'i',' ','l','o','v','e',' ','y','o','u'};
		
		System.out.println("Before reverse"+Arrays.toString(sentense));
        
		reverse(sentense,0,sentense.length-1);
        
        System.out.println("After reverse"+Arrays.toString(sentense));
        
        
        char[] testSentense2 = {'i',' ','l','o','v','e',' ','y','o','u'};

        reverseWordByBlank(testSentense2);        

        System.out.print("After reverse Word by blank "+Arrays.toString(testSentense2));
        
        char [] newTest = "the sky is blue".toCharArray();
        		
        reverseWordByBlank(newTest);
        System.out.println(Arrays.toString(newTest));
        
        lengthOfLongestSubstring();


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
    //reverse the each word before the blank
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
	
	private static void reverseWordByWord(char[] string) {
        int i =0;
        int j= string.length-1;
		while (i < j) {
			if(string[i]==' '&& string[j]==' ')
			{
				char temp = string[i];
				string[i] = string[j];
				string[j] = temp;			
				i++;
				j--;
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
		System.out.println("Substring: "+sb+" Length: " + sb.length());
		}

}
