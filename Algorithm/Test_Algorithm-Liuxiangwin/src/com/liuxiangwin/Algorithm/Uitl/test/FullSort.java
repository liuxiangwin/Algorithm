package com.liuxiangwin.Algorithm.Uitl.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FullSort {
	// 将NUM设置为待排列数组的长度即实现全排列
	private static int NUM = 3;

	public static void main(String[] args) {
		String[] datas = new String[] { "a", "b", "c", "d" };
		// sort(Arrays.asList(datas), new ArrayList());

		String testData = "abc";
		System.out.println(Arrays.toString(permutation(testData)));
	}

	private static String[] permutation(String orginal) {
		ArrayList<String> list = new ArrayList<String>();
		if (orginal.length() == 1) {
			return new String[] { orginal };
		} else {
			for (int i = 0; i < orginal.length(); i++) {
				String s = orginal.charAt(i) + "";
				String result = "";
				String resultA = result + s;
				System.out.println(orginal.substring(0, i));
				System.out.println(orginal.substring(i + 1, orginal.length()));
				
				String leftS = orginal.substring(0, i)
						+ orginal.substring(i + 1, orginal.length());
				for (String element : permutation(leftS)) {
					result = resultA + element;
					list.add(result);
				}
			}
			return (String[]) list.toArray(new String[list.size()]);
		}
	}

	/**
	 * 递归算法：将数据分为两部分，递归将数据从左侧移右侧实现全排列
	 * 
	 * @param datas
	 * @param target
	 */
	private static void sort(List datas, List target) {
		if (target.size() == NUM) {
			for (Object obj : target)
				System.out.print(obj);
			System.out.println();
			return;
		}
		for (int i = 0; i < datas.size(); i++) {
			List newDatas = new ArrayList(datas);
			List newTarget = new ArrayList(target);
			newTarget.add(newDatas.get(i));
			newDatas.remove(i);
			sort(newDatas, newTarget);
		}
	}

}
