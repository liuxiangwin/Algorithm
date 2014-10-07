package com.Alogrithm.google.test;

public class TestFindIndexOfNextGreater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[] { 2, 10, 5, 6, 80 };

		System.out.println("Find the next larger num than 6 in array "
				+ FindIndexOfNextGreater(array, 6));

		System.out.println("Find the next larger num 20 in array "
				+ FindIndexOfNextGreater(array, 20));

	}

	private static int FindIndexOfNextGreater(int intArray[], int A) {
		int index = -1;
		for (int i = 0; i < intArray.length; ++i) {
			if (intArray[i] > A) {
				if (index == -1 || intArray[i] < intArray[index]) {
					index = i;
					System.out.println("index is " + index);
				}

			}
		}

		// return index;
		return intArray[index];
	}

}
