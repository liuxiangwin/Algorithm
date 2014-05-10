package com.liuxiangwin.Algorithm.String.test;

import java.util.Arrays;
import java.util.HashMap;

public class TestStringComonOperation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String LongString = "ABCDEFGHLMNOPQRS";
		String ShortString = "DCGSRQPOM";
		// System.out.println(checkStringContainSubString(LongString,
		// ShortString));
		System.out.println("Alan".length());
		System.out.println("reverseString no new space:  "+reverseStringNoNewSpace("Alan"));
		System.out.println("reverseString with new space: " +reverseString("Alan"));
		System.out.println("A l an");
		System.out.println(removeNullString("A l an"));
		
		
		String longString = "hAlan";
		String shortString = "Alan";
		
		
		System.out.println("contains string: "+checkStringContainSubString(longString,shortString));
		

		String[] firstArray = { "test1", "", "test2", "test4", "" };
		for (String value : firstArray) {
			if (value == "") {
				value = "Replace";
			}
		}
		System.out.println(Arrays.toString(firstArray));
	}
	//if only use yourself the length is length/2
	private static String reverseStringNoNewSpace(String string) {
		char[] result = string.toCharArray();
		for (int i = 0; i < string.length()/2; i++) {			
			char temp = result[i];
			result[i] = result[string.length() - i - 1];
			result[string.length() - i - 1] = temp;

		}
		//return String.valueOf(result);
		return new String(result,0,string.length());
		

	}	
	//use new space the length is i<string.length
	private static String reverseString(String string) {
		char[] result = new char[string.length()];
		for (int i = 0; i < string.length(); i++) {
			char temp = string.charAt(i);
			result[i] = string.charAt(string.length() - i - 1);
			result[string.length() - i - 1] = temp;

		}
		return String.valueOf(result);

	}

	private static String removeNullString(String string) {
		char[] result = new char[string.length()];
		for (int i = 0, j = 0; i < string.length(); i++) {
			// Character.
			// if(string.charAt(i)!= '\0')
			if (string.charAt(i) != '\u0000') {
				System.out.println("Not null character " + string.charAt(i));
				result[j++] = string.charAt(i);
			}

		}
		return String.valueOf(result);

	}

	private static boolean checkStringContainSubString(String longString,
			String shortString) {
		char[] longStrings = longString.toCharArray();
		char[] shortStrings = shortString.toCharArray();
		for (int i = 0; i < longStrings.length; i++) {// O(n*m)
			int j;
			for (j = 0; j < shortStrings.length; j++) // O(n*m)
			{
				if (longStrings[i+j] != shortStrings[j]) // 一一比较
				{
					break;
				}
			}
			if(j==shortString.length())
			{
				return true;
				//count++;
			}
		}
		return false;
	}


	
}
