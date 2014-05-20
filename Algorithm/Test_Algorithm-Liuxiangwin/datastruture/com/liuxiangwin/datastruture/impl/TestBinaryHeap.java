package com.liuxiangwin.datastruture.impl;

import java.util.Arrays;

public class TestBinaryHeap {	

	public static void main(String[] args) {

		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int length = array.length;
		buildHeap(array, length);// ����
		System.out.println(Arrays.toString(array));

		while (length > 1) {
			int tem = 0;
			tem = array[length - 1];
			array[length - 1] = array[0];
			array[0] = tem;// ����β����
			length--;// �����ڵ�Ӷ���ɾ��
			ajustHeap(array, length, 0);// �����ѣ�ֻ�������һ���ڵ㼴��
		}
		System.out.println(Arrays.toString(array));
	}
	
	
	public static void ajustHeap(int[] heap, int length, int index) {

		int left = 2 * index + 1;// ����
		int right = 2 * index + 2;// �Һ���
		int big = index;// �ϴ�Ľڵ��±�
		int item;
		while (left < length || right < length) {// ѭ��ֱ��ȷ������λ��
			if (left < length && heap[left] > heap[big]) {
				big = left;
			}
			if (right < length && heap[right] > heap[big]) {
				big = right;
			}// ȷ���ϴ��ֵ���±�
			if (index == big) {// ����ýڵ�����Ҫ��������ѭ��
				break;
			} else {// ������ϴ��ֵ�ĺ��ӽ��������ݹ�����
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
		// �ӵ�һ����Ҷ��㿪ʼ����
		// ���ڶ�����ȫ���������������ѵ��ܽڵ������ż���������һ��Ҷ�ڵ�һ�����丸�ڵ������
		// ����ѵ��ܽ���������������Ҷ�ڵ�������������ӣ���Զ�ˣ�

		int begin = length % 2 == 0 ? length / 2 : (length - 1) / 2;
		for (int index = begin; index >= 0; index--) {
			ajustHeap(array, length, index);// ���ѵĹ��̾�����������Ĺ���
		}
	}
}
