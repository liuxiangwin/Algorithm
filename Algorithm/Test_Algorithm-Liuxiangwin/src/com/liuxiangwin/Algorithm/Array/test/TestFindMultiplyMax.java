package com.liuxiangwin.Algorithm.Array.test;
import java.util.ArrayList;


public class TestFindMultiplyMax<E> extends ArrayList<E>{

	private static final long serialVersionUID = 7799621696481440826L;
	
	public static void main(String[] args) {
		TestFindMultiplyMax<Integer> array = new TestFindMultiplyMax<Integer>();
		array.add(1);
		array.add(4);
		array.add(6);
		array.add(10);
		array.add(12);
		array.add(40);
		// ��������ֺܼ�,����Ҳ֪��N-1�����˻�Ϊ115200
		// �㷨�����
		System.out.println(" �㷨�����" + maxOfSubArray(array));
	}

	private static long maxOfSubArray(TestFindMultiplyMax arr) {
		// ���ֵ
		long max = 0;
		int size = arr.size();
		// s[i]��ʾǰi��Ԫ�صĳ˻�,��֪s[i]=s[i-1]*arr.get(i-1) ����(1<=i<=N)
		long[] s = new long[size + 1];
		s[0] = 1;
		// t[i]��ʾi����Ԫ�صĳ˻�����֪t[i]=t[i+1]*arr.get(i) ����(1<=i<=N)
		long[] t = new long[size + 1];
		t[size] = 1;
		// ��p[i]Ϊ����i��Ԫ��֮�������Ԫ��֮��������p[i]=s[i-1]*t[i+1];
		long[] p = new long[size + 1];

		// ��� s����
		for (int i = 1; i <= size; i++) {
			s[i] = s[i - 1] * ((Integer) arr.get(i - 1));
		}
		// ���t����
		for (int i = size - 1; i >= 0; i--) {
			t[i] = t[i + 1] * ((Integer) arr.get(i));
		}
		// ���� p����
		for (int i = 1; i <= size; i++) {
			p[i] = s[i - 1] * t[i];
			if (p[i] > max) {
				max = p[i];
			}
		}
		return max;
	}



}
