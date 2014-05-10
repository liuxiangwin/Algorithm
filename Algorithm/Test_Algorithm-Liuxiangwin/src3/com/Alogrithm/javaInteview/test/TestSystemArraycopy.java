package com.Alogrithm.javaInteview.test;

import java.util.Arrays;

public class TestSystemArraycopy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] ids = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(ids)); // [1, 2, 3, 4, 5]
		// 把从索引0开始的2个数字复制到索引为3的位置上
		System.arraycopy(ids, 0, ids, 3, 2);
		System.out.println(Arrays.toString(ids)); // [1, 2, 3, 1, 2]

		int[] ids2 = new int[6];
		System.arraycopy(ids, 1, ids2, 0, 3);
		//if the orginal array no new value,then the current value is 0
		System.out.println(Arrays.toString(ids2)); // [2, 3, 1, 0, 0, 0]
	}

}
