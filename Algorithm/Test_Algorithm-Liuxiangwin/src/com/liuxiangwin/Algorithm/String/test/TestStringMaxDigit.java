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
					start = p; // ����������ֻ��ǵ�һ�����ֵĵ�ַ
				num++; // ��¼�����ֵĴ���
				set = true;
			} else {
				if (num > max) // ���ǰ���һ�����������
				{
					outputstr = String.valueOf(start); // ��ѵ�ַ����outputstr
					max = num; // ������������ִ��ĸ���
				}
				set = false; // Ϊ��һ������������׼��
				num = 0;
			}
			p++;
		}

		if (num > max) { // ��ֹ���һ���ַ������ֵ���û���ж�num>max
			outputstr = String.valueOf(start);
			max = num;
		}
		// cout << "������ִ�Ϊ:" << endl;
		for (int i = 0; i < max; i++) // ���������ִ�
		{
		}
		// cout << *(outputstr + i);
		// cout << endl;
		return max;
	}

}
