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

		// int nTargetLen = N + 1; // 设置目标长度为总长度+1
		// int pBegin = 0; // 初始指针
		// int pEnd = 0; // 结束指针
		// int nLen = N; // 目标数组的长度为N
		// int nAbstractBegin = 0; // 目标摘要的起始地址
		// int nAbstractEnd = 0; // 目标摘要的结束地址
		//
		// while(true)
		// {
		// // 假设包含所有的关键词，并且后面的指针没有越界，往后移动指针
		// while(!isAllExisted() && pEnd < nLen)
		// {
		// pEnd++;
		// }
		//
		// // 假设找到一段包含所有关键词信息的字符串
		// while(isAllExisted())
		// {
		// if(pEnd – pBegin < nTargetLen)
		// {
		// nTargetLen = pEnd – pBegin;
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
