package com.liuxiangwin.Algorithm.String.test;

public class TestStringInputCheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("checkInputIsInteger "+ checkInputIsInteger("123"));
		System.out.println("checkInputIsInteger "+ checkInputIsInteger("liuxiangwin"));

	}

	private static boolean checkInputIsInteger(String string) {
		boolean isInteger = false;
		try {
			Integer.parseInt(string);
			isInteger = true;
			return isInteger;

		} catch (NumberFormatException e) {
			isInteger = false;
		}
		return isInteger;

	}

}
