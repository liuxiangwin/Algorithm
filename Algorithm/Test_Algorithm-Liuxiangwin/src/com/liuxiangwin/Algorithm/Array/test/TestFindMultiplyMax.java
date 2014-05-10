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
		// 上面的数字很简单,口算也知道N-1个最大乘积为115200
		// 算法结果：
		System.out.println(" 算法结果：" + maxOfSubArray(array));
	}

	private static long maxOfSubArray(TestFindMultiplyMax arr) {
		// 最大值
		long max = 0;
		int size = arr.size();
		// s[i]表示前i个元素的乘积,可知s[i]=s[i-1]*arr.get(i-1) 其中(1<=i<=N)
		long[] s = new long[size + 1];
		s[0] = 1;
		// t[i]表示i后面元素的乘积，可知t[i]=t[i+1]*arr.get(i) 其中(1<=i<=N)
		long[] t = new long[size + 1];
		t[size] = 1;
		// 设p[i]为除第i个元素之外的其他元素之积，即：p[i]=s[i-1]*t[i+1];
		long[] p = new long[size + 1];

		// 求出 s数组
		for (int i = 1; i <= size; i++) {
			s[i] = s[i - 1] * ((Integer) arr.get(i - 1));
		}
		// 求出t数组
		for (int i = size - 1; i >= 0; i--) {
			t[i] = t[i + 1] * ((Integer) arr.get(i));
		}
		// 计算 p数组
		for (int i = 1; i <= size; i++) {
			p[i] = s[i - 1] * t[i];
			if (p[i] > max) {
				max = p[i];
			}
		}
		return max;
	}



}
