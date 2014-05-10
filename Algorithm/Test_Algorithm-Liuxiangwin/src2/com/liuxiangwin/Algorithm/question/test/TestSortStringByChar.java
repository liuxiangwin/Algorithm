package com.liuxiangwin.Algorithm.question.test;

import java.util.Dictionary;
import java.util.Hashtable;

public class TestSortStringByChar {
	public static void main(String args[])
	{
		char[] c = {'T', 'M', 'A'};
		String[] strArray = {"Adam","Martha","Terry"};
		//Output : "Terry", "Martha", "Adam"

		
	}

	private static void SortArrayByOrder(String[] sortOrder, String[] arr) {
		Hashtable<String, Integer> reverseSortOrder = new Hashtable<String, Integer>();
		int count = 0;
		for (String s : sortOrder)
		{
			//reverseSortOrder.get(s)=count++;
		}

		QuickSortByOrder(reverseSortOrder, arr, 0, arr.length - 1);
	}

	private static void QuickSortByOrder(Hashtable<String, Integer> sortOrder,
			String[] arr, int lo, int hi) {
		if (hi < lo)
			return;

		//int d = SortByOrderPartition(sortOrder, arr, lo, hi);
		//QuickSortByOrder(sortOrder, arr, lo, d - 1);
		//QuickSortByOrder(sortOrder, arr, d + 1, hi);
	}

//	private static int SortByOrderPartition(
//			Hashtable<String, Integer> sortOrder, String[] arr, int lo, int hi) {
//		int i = 0, j = hi + 1;
//		String v = arr[lo];
//		while (true) {
//			while (StringCompare(sortOrder, arr[++i], v) < 0)
//				if (i == hi)
//					break;
//			while (StringCompare(sortOrder, arr[--j], v) > 0)
//				if (j == lo)
//					break;
//			if (i >= j)
//				break;
//			StringExchange(arr, i, j);
//		}
//		StringExchange(arr, lo, j);
//		return j;
//	}

//	private static int StringCompare(Hashtable<String, Integer> sortOrder,
//			String x, String y) {
//		String fC = x[0].ToString();
//		String sC = y[0].ToString();
//		if (sortOrder[fC] < sortOrder[sC])
//			return -1;
//		else if (sortOrder[fC] > sortOrder[sC])
//			return 1;
//		else
//			return 0;
//	}

	private static void StringExchange(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
