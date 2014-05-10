package com.Alogrithm.google.test;

public class TestArrayByIncrementedOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = { 2, 7, 1, 1 };

		int arrLength = arr.length;

		incrementArr(arr, arrLength);

		print(arr, arrLength);
	}

    //����������һλ��9�Ļ����1��Ȼ��index--, ������ǵĻ�����array[index]�������1
	private static void incrementArr(int arr[], int length) {
		if (arr[length - 1] == 9) {//last position
			arr[length - 1] = 0;
			length--;
			incrementArr(arr, length);
		} else {
			arr[length - 1]++;//if not  euqals 9 then plus 1;
		}
	}
	
	private static void print(int[] arr, int arrLength) {
		for (int i = 0; i < arrLength; i++) {
			System.out.println(arr[i]);
		}
	}


}
