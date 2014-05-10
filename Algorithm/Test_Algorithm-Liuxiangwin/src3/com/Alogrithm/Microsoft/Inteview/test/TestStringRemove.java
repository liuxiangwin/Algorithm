package com.Alogrithm.Microsoft.Inteview.test;

public class TestStringRemove {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(removeStringByArray("alanliu", "ln"));

		System.out.println(removeBlank("M i chal"));
		
		
		System.out.println("alan Liu".replace(" ", ""));
	}
	
	public static String removeStringByArray(String string, String toRemove) {
		char[] a = string.toCharArray();
		char[] b = toRemove.toCharArray();
		int i = 0;
		String s = removeString(a, b[i]);
		i++;
		return i <= b.length - 1 ? removeString(s.toCharArray(), b[i]) : s;
	}
	
	
	public static String removeString(char[] a , char b) {
		//char[] a = string.toCharArray();
		//char[] b = toRemove.toCharArray();
		int index = 0;

		for (int i = 0; i < a.length; i++) {
			// The A[index] array is to accept the expect array value
			a[index] = a[i];
			// if (a[index] != b[0])
			if (a[index] != b)
				index++;
		}

		// Currently the a is the removed String array
		return new String(a, 0, index);
	}

	public static String removeBlank(String string) {
		char[] a = string.toCharArray();
		int index = 0;

		for (int i = 0; i < a.length; i++) {
			// The A[index] array is to accept the expect array value
			a[index] = a[i];
			// if (a[index] != b[0])
			if (a[index] != ' ')
				index++;

		}
		// Currently the a is the removed String array
		return new String(a, 0, index);

	}

}
