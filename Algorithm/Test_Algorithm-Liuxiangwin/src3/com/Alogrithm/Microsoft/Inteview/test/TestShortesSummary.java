package com.Alogrithm.Microsoft.Inteview.test;

import java.util.ArrayList;
import java.util.List;

public class TestShortesSummary {

	private static String content[] = { "a", "c", "d", "a", "c", "b", "d", "e",
			"a", "a", "b" };
	private static String keyword[] = { "b", "c", "d" };

	private static List<String> contentList = new ArrayList<String>();

	public static void main(String args[]) {
		List<String> result = new ArrayList<String>();
		int begin = 0;
		int end = content.length;

		// 将content内容从数组形式变换成List型
		for (int i = 0; i < end; i++) {
			contentList.add(i, content[i]);
		}

		// 输出给定的content和keyword
		System.out.print("[content]: ");
		for (int i = 0; i < content.length; i++)
			System.out.print(content[i] + " ");
		System.out.println();
		
		System.out.print("[keyword]: ");
		for (int i = 0; i < keyword.length; i++) {
			System.out.print(keyword[i] + " ");
		}
		System.out.println();
		
		// 输出最短摘要
		result = contentList;
		System.out.println("[AllMatch]：");
		for (end = content.length; end - begin >= keyword.length; end--) 
		{
			for (begin = 0; end - begin >= keyword.length; begin++) {
				if (isAllHave(contentList.subList(begin, end), keyword)
						&& result.size() > contentList.subList(begin, end)
								.size()) {
					result = contentList.subList(begin, end);
					System.out.	println("begin is :"+ begin +", end is: "+end
						+","+  result);
				}
			}
			begin = 0;
		}
		System.out.println("[ShortestMatch]: " + result);

	}

	// 是否都包含所有关键字
	static boolean isAllHave(List<String> arr, String key[]) {
		boolean is = false;
		int temp = 0;
		for (int i = 0; i < key.length; i++)
			if (isKeywordIn(arr, key[i]))
				temp++;
		if (temp == key.length)
			is = true;
		return is;
	}

	// 是否包含单个关键字
	static boolean isKeywordIn(List<String> arr, String key) {
		int i;
		for (i = 0; i < arr.size(); i++)
			if (arr.get(i) == key)
				return true;
		return false;
	}

	private static void getShortestSummary(int N) {
		int nTargetLen = N + 1; // 设置目标长度为总长度+1
		int pBegin = 0; // 初始指针
		int pEnd = 0; // 结束指针
		int nLen = N; // 目标数组的长度为N
		int nAbstractBegin = 0; // 目标摘要的起始地址
		int nAbstractEnd = 0; // 目标摘要的结束地址

		while (true) {
			// 假设包含所有的关键词，并且后面的指针没有越界，往后移动指针
			while (!isAllExisted() && pEnd < nLen) {
				pEnd++;
			}

			// 假设找到一段包含所有关键词信息的字符串
			while (isAllExisted()) {
				if (pEnd - pBegin < nTargetLen) {
					nTargetLen = pEnd - pBegin;
					nAbstractBegin = pBegin;
					nAbstractEnd = pEnd - 1;
				}
				pBegin++;
			}
			if (pEnd >= N)
				break;
		}

	}

	private static boolean isAllExisted() {
		return true;
	}

}
