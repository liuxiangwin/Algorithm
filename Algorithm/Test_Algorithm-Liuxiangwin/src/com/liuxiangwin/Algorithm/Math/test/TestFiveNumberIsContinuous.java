package com.liuxiangwin.Algorithm.Math.test;

public class TestFiveNumberIsContinuous {
	//To understand the logic
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,17 };
		int[] chars = { 9, 11, 13, 0, 0 };
		int[] chars2 = { 9, 8, 4, 0, 0 };
		System.out.println(IfExist(array, chars));
		System.out.println(IfExist(array, chars2));

	}

	public static boolean IfExist(int[] array, int[] chars) {

		if (chars.length != 5 && array.length < 5) {
			System.out.println("Not Exist");
		}
		for (int i = 0; i <= array.length - 5; i++) {

			if (IfMatch(new int[] { array[i], array[i + 1], array[i + 2],
					array[i + 3], array[i + 4] }, chars)) {
				return true;
			}
		}
		return false;
	}

	private static boolean IfMatch(int[] chars1, int[] chars2) {
		boolean[] matchResult = new boolean[5];
		for (int i : chars1) {
			for (int j = 0; j < 5; j++) {
				if (matchResult[j] == false && chars2[j] == i) {
					matchResult[j] = true;
				}
			}
		}
		for (int i = 0; i < 5; i++) {
			if (matchResult[i] == false && chars2[i] != 0) {
				return false;
			}
		}
		return true;
	}

}
