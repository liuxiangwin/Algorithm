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

		// ��content���ݴ�������ʽ�任��List��
		for (int i = 0; i < end; i++) {
			contentList.add(i, content[i]);
		}

		// ���������content��keyword
		System.out.print("[content]: ");
		for (int i = 0; i < content.length; i++)
			System.out.print(content[i] + " ");
		System.out.println();
		
		System.out.print("[keyword]: ");
		for (int i = 0; i < keyword.length; i++) {
			System.out.print(keyword[i] + " ");
		}
		System.out.println();
		
		// ������ժҪ
		result = contentList;
		System.out.println("[AllMatch]��");
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

	// �Ƿ񶼰������йؼ���
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

	// �Ƿ���������ؼ���
	static boolean isKeywordIn(List<String> arr, String key) {
		int i;
		for (i = 0; i < arr.size(); i++)
			if (arr.get(i) == key)
				return true;
		return false;
	}

	private static void getShortestSummary(int N) {
		int nTargetLen = N + 1; // ����Ŀ�곤��Ϊ�ܳ���+1
		int pBegin = 0; // ��ʼָ��
		int pEnd = 0; // ����ָ��
		int nLen = N; // Ŀ������ĳ���ΪN
		int nAbstractBegin = 0; // Ŀ��ժҪ����ʼ��ַ
		int nAbstractEnd = 0; // Ŀ��ժҪ�Ľ�����ַ

		while (true) {
			// ����������еĹؼ��ʣ����Һ����ָ��û��Խ�磬�����ƶ�ָ��
			while (!isAllExisted() && pEnd < nLen) {
				pEnd++;
			}

			// �����ҵ�һ�ΰ������йؼ�����Ϣ���ַ���
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
