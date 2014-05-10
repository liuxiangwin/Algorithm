package com.Alogrithm.Microsoft.Inteview.test;

public class TestStringToASCII {

	public static void main(String args[]) {
		String str = "Java practice session. ";

		for (int i = 0; i < str.length(); i++)
			System.out.println(str.charAt(i) + " as ASCII value of: "
					+ (int) str.charAt(i));
		
		
		toASCII(new StringBuilder(str));

	}

	private static void toASCII(StringBuilder sb) {
		int length = sb.length();
		int numberOffset = 0;
		for (int i = 0; i < length; i++) {
			String numberString = new String("" + (int) sb.charAt(numberOffset));
			System.out.println("numberString "+numberString);
			sb.insert(numberOffset, numberString);
			numberOffset += numberString.length();
			sb.deleteCharAt(numberOffset);
			System.out.println("deleteCharAt(numberOffset  "+sb);
		}
		System.out.println(sb.toString());
	}

}
