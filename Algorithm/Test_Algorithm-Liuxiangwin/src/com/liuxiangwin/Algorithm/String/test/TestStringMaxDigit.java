package com.liuxiangwin.Algorithm.String.test;

public class TestStringMaxDigit {

	/**
	 * Not clearly
	 * To be check the logic
	 */
	public static void main(String[] args) {
		String string = "sss12345ss1234sdfaf123456789asfdfs12345678901231a";
		String result = null;

		System.out.println(maxContunuNum(string, result));
	}

	private static int maxContunuNum(String inputstr, String outputstr) {

		char p = inputstr.charAt(0);
		int max = 0, num = 0;
		boolean set = false;
		char start = '\u0000';

		while (p != '\0') {
			if ((p >= '0') && (p <= '9')) {
				if (set == false)
					start = p; // 连续数字中只标记第一个数字的地址
				num++; // 记录数出现的次数
				set = true;
			} else {
				if (num > max) // 如果前面的一串数字是最长的
				{
					outputstr = String.valueOf(start); // 则把地址赋给outputstr
					max = num; // 并记下最长的数字串的个数
				}
				set = false; // 为下一轮连续数字做准备
				num = 0;
			}
			p++;
		}

		if (num > max) { // 防止最后一个字符是数字导致没有判断num>max
			outputstr = String.valueOf(start);
			max = num;
		}
		// cout << "最长的数字串为:" << endl;
		for (int i = 0; i < max; i++) // 输出最长的数字串
		{
		}
		// cout << *(outputstr + i);
		// cout << endl;
		return max;
	}

}
