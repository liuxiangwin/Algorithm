package com.liuxiangwin.datastruture.impl;

import java.util.Arrays;

public class TestBinaryHeap {	

	public static void main(String[] args) {

		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int length = array.length;
		buildHeap(array, length);// 建堆
		System.out.println(Arrays.toString(array));

		while (length > 1) {
			int tem = 0;
			tem = array[length - 1];
			array[length - 1] = array[0];
			array[0] = tem;// 将收尾交换
			length--;// 将最大节点从堆中删除
			ajustHeap(array, length, 0);// 调整堆，只需调整第一个节点即可
		}
		System.out.println(Arrays.toString(array));
	}
	
	
	public static void ajustHeap(int[] heap, int length, int index) {

		int left = 2 * index + 1;// 左孩子
		int right = 2 * index + 2;// 右孩子
		int big = index;// 较大的节点下标
		int item;
		while (left < length || right < length) {// 循环直到确定最终位置
			if (left < length && heap[left] > heap[big]) {
				big = left;
			}
			if (right < length && heap[right] > heap[big]) {
				big = right;
			}// 确定较大键值的下标
			if (index == big) {// 如果该节点满足要求，则跳出循环
				break;
			} else {// 否则与较大键值的孩子交换，并递归往下
				item = heap[index];
				heap[index] = heap[big];
				heap[big] = item;
				index = big;
				left = 2 * index + 1;
				right = 2 * 2 + 2;
			}
		}
	}

	public static void buildHeap(int[] array, int length) {
		// 从第一个非叶结点开始调整
		// 由于堆是完全二叉树，因此如果堆的总节点个数是偶数，则最后一个叶节点一定是其父节点的左孩子
		// 如果堆的总结点数是奇数，则非叶节点均包含两个孩子（扯远了）

		int begin = length % 2 == 0 ? length / 2 : (length - 1) / 2;
		for (int index = begin; index >= 0; index--) {
			ajustHeap(array, length, index);// 建堆的过程就是逐个调整的过程
		}
	}
}
