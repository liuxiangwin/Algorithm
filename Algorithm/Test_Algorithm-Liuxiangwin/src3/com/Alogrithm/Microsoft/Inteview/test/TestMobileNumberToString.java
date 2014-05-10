package com.Alogrithm.Microsoft.Inteview.test;

import java.util.HashMap;

public class TestMobileNumberToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void PrintTelephoneWords(int[] phoneNumber) {
		HashMap<Integer, String> dict = new HashMap<Integer, String>();
		dict.put(2, "ABC");
		dict.put(3, "DEF");
		dict.put(4, "GHI");
		dict.put(5, "JKL");
		dict.put(6, "MNO");
		dict.put(7, "PRS");
		dict.put(8, "TUV");
		dict.put(9, "WXY");

		char[] result = new char[phoneNumber.length];

		DoPrintTelephoneWords(phoneNumber, 0, result, dict);

	}

	private static void DoPrintTelephoneWords(int[] phoneNumber,
			int currentDigit, char[] result, HashMap<Integer, String> dict) {
		if (currentDigit >= phoneNumber.length) {
			System.out.println(result);
			return;
		}
		for (int i = 0; i < 3; i++) {
			if (phoneNumber[currentDigit] == 0	|| phoneNumber[currentDigit] == 1) {
				result[currentDigit] = phoneNumber[currentDigit] == 0 ? '0'	: '1';
			}
			else
			{	
				int currenDigit = phoneNumber[currentDigit];
				//result[currentDigit] = dict[phoneNumber[currentDigit]][i];
				//result[currentDigit] = dict.get(phoneNumber[currentDigit])
				DoPrintTelephoneWords(phoneNumber, currentDigit + 1, result, dict);
			}
			
		}
	}
}
