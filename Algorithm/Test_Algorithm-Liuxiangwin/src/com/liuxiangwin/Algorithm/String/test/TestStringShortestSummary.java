package com.liuxiangwin.Algorithm.String.test;

public class TestStringShortestSummary {
	public static void main(String args[]) {
		String string7 = "javajava";

		System.out.println(string7.indexOf("java", 2));// 4
		
		System.out.println(string7.indexOf("java", 3));// 4
		
		System.out.println(string7.indexOf("java", 4));// 4
		
		System.out.println(string7.indexOf("java", 5));// -1
		
		System.out.println(string7.indexOf("java", 1));// -1

	}

	private static void checkStringShortestSummary() {

		// int nTargetLen = N + 1; // ����Ŀ�곤��Ϊ�ܳ���+1
		// int pBegin = 0; // ��ʼָ��
		// int pEnd = 0; // ����ָ��
		// int nLen = N; // Ŀ������ĳ���ΪN
		// int nAbstractBegin = 0; // Ŀ��ժҪ����ʼ��ַ
		// int nAbstractEnd = 0; // Ŀ��ժҪ�Ľ�����ַ
		//
		// while(true)
		// {
		// // ����������еĹؼ��ʣ����Һ����ָ��û��Խ�磬�����ƶ�ָ��
		// while(!isAllExisted() && pEnd < nLen)
		// {
		// pEnd++;
		// }
		//
		// // �����ҵ�һ�ΰ������йؼ�����Ϣ���ַ���
		// while(isAllExisted())
		// {
		// if(pEnd �C pBegin < nTargetLen)
		// {
		// nTargetLen = pEnd �C pBegin;
		// nAbstractBegin = pBegin;
		// nAbstractEnd = pEnd-1;
		// }
		// pBegin++;
		// }
		// if(pEnd >= N)
		// break;
		// }
		//
		// }

	}

}
