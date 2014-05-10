package com.liuxiangwin.Algorithm.Common.test;

import java.util.ArrayList;
import java.util.List;

public class DivideNumber {

	/**
	 * To be understand the logic ????
	 */
	public static void main(String[] args) {
		Integer[] array = { 3, 2, 4, 3, 6 };
		int max = new DivideNumber().MaxPartsNumber(array);
		System.out.println(max);
	}

	public int MaxPartsNumber(Integer[] array) {
		List<Integer> list = new ArrayList<Integer>();
		for (Integer value : array) {
			list.add(value);
		}

		int sum = 0;
		for (int i : array) {
			sum += i;
		}
		for (int i = array.length; i > 0; i--) {
			if (sum % i == 0) {
				if (IfExist(list, sum / i, sum / i)) {
					return i;
				}
			}
		}
		return 1;
	}

	private boolean IfExist(List<Integer> rootList, int number,
			int orginalNumber) {
		if (rootList.size() == 0 && number == orginalNumber) {
			return true;
		}
		boolean ifExist = false;
		for (int i = 0; i < rootList.size(); i++) {
			List<Integer> childList = new ArrayList<Integer>();
			for (int j = 0; j < rootList.size(); j++) {
				if (j != i) {
					childList.add(rootList.get(j));
				}
			}
			if (rootList.get(i) == number) {
				ifExist = ifExist
						|| IfExist(childList, orginalNumber, orginalNumber);

			} else if (rootList.get(i) < number) {
				ifExist = ifExist
						|| IfExist(childList, number - rootList.get(i),
								orginalNumber);
			}

		}

		return ifExist;

	}

}
