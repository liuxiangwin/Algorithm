package com.liuxiangwin.alogrithm.developer.tey;

public class StringContain {

	/**
	 * * ���������� ���������ֱ�����ĸ��ɵ��ַ���A���ַ���B���ַ���B�ĳ��ȱ��ַ���A�̡����ʣ���������ж��ַ���B
	 * ��������ĸ�Ƿ����ַ���A�Ϊ�˼���������ǹ涨������ַ���ֻ������дӢ����ĸ������String A��ABCD��String B��BAD��
	 * ����true��string A��ABCD��string B��BCE������false��String A��ABCD��String
	 * B��AA������true��
	 *
	 * ˼·�� ˼·һ�������ַ���B���ж�ÿһ���ַ��Ƿ�������ַ���A�У�ʱ�临�Ӷ�O(n*m)���ռ临�Ӷ�O(1);
	 * ˼·�����ȶ������ַ�������Ȼ��ͬʱ�����ַ���A��B���ж�B�е�ÿһ���ַ��Ƿ����ַ���A�С�ʱ�临�Ӷ�O(nlogn)���ռ临�Ӷ�O(1)��
	 * ˼·������ÿһ���ַ�ӳ�䵽һ�������ϣ����ַ���A�е�ÿһ���ַ���ʾ�����������ۻ���Ȼ������ַ���B����ÿһ���ַ���ʾ����
	 * ��ȥ���ַ���A���ۻ����ж������Ƿ�Ϊ0��ʱ�临�Ӷȣ�O(n)���ռ临�Ӷ�O(1)�����ܴ��ڵ����⣺�˻�ʱ���ܻ������
	 * ˼·�ģ��������ʹ��Java�е����ݽṹ��HashMap��Set���Ժܷ���ؽ�����⣻������ܣ����ǿ��Թ���һ����ǩ��������ÿһ����
	 * ��ӳ��Ϊ����(��Χ��0��26)��Ȼ�����A�е�ÿһ���ַ�����32λ�����Ķ�Ӧλ��1(������ʼΪ0)��������B�е�ÿһ���ַ����ж�
	 * ÿһ���ַ�������������������Ƿ�����λ��ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(1)��˼·��Ϊ�����㷨��
	 *
	 * ���������˼·�ĵ�ʾ�����롣
	 *
	 * @param string1
	 * @param string2
	 * @return
	 */
	public static boolean hashCheck(char[] string1, char[] string2) {
		int mask = 0;
		for (char string : string1) {
			mask = mask | (1 << (string - 'A'));
		}
		for (char string : string2) {
			if ((mask & (1 << (string - 'A'))) == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]) {

		System.out.println(hashCheck("ABCD".toCharArray(), "AD".toCharArray()));
	}
}
