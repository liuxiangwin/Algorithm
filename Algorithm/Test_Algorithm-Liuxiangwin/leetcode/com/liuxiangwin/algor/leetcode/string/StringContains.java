package com.liuxiangwin.algor.leetcode.string;

public class StringContains {
	 /**
     *  * ����������
     *  ���������ֱ�����ĸ��ɵ��ַ���A���ַ���B���ַ���B�ĳ��ȱ��ַ���A�̡����ʣ���������ж��ַ���B
     *  ��������ĸ�Ƿ����ַ���A�Ϊ�˼���������ǹ涨������ַ���ֻ������дӢ����ĸ������String A��ABCD��String B��BAD��
     *  ����true��string A��ABCD��string B��BCE������false��String A��ABCD��String B��AA������true��
     *
     * ˼·��
     *  ˼·һ�������ַ���B���ж�ÿһ���ַ��Ƿ�������ַ���A�У�ʱ�临�Ӷ�O(n*m)���ռ临�Ӷ�O(1);
     *  ˼·�����ȶ������ַ�������Ȼ��ͬʱ�����ַ���A��B���ж�B�е�ÿһ���ַ��Ƿ����ַ���A�С�ʱ�临�Ӷ�O(nlogn)���ռ临�Ӷ�O(1)��
     *  ˼·������ÿһ���ַ�ӳ�䵽һ�������ϣ����ַ���A�е�ÿһ���ַ���ʾ�����������ۻ���Ȼ������ַ���B����ÿһ���ַ���ʾ����
     *  ��ȥ���ַ���A���ۻ����ж������Ƿ�Ϊ0��ʱ�临�Ӷȣ�O(n)���ռ临�Ӷ�O(1)�����ܴ��ڵ����⣺�˻�ʱ���ܻ������
     *  ˼·�ģ��������ʹ��Java�е����ݽṹ��HashMap��Set���Ժܷ���ؽ�����⣻������ܣ����ǿ��Թ���һ����ǩ��������ÿһ����
     *  ��ӳ��Ϊ����(��Χ��0��26)��Ȼ�����A�е�ÿһ���ַ�����32λ�����Ķ�Ӧλ��1(������ʼΪ0)��������B�е�ÿһ���ַ����ж�
     *  ÿһ���ַ�������������������Ƿ�����λ��ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(1)��˼·��Ϊ�����㷨��
     *
     *  ���������˼·�ĵ�ʾ�����롣
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean hashCheck(char[] s1, char[] s2) {
        int mask = 0;
        for (char c: s1) {
            mask = mask | (1 << (c - 'A'));
        }
        for (char c: s2) {
            if ((mask & (1 << (c - 'A'))) == 0) {
                return false;
            }
        }
       return true;
    }
    
	public static boolean hashUniqueChar(char[] s1) {
		int mask = 0;
		for (char c : s1) {
			if ((mask & (1 << (c - 'A'))) > 0) {
				//ֻ����ͬһ��λ�ó��ֲŻ�&����0 //����ÿ���Ժ󶼻������ó�0				
				return false;
			}
			mask = mask | (1 << (c - 'A'));
		}
		return true;
	}

    
	public static void main(String[] args) {
		StringContains  stringContains = new StringContains();
		char[] longString = "Alan is dilegent guy".toCharArray();
		char[] shortString = "dile".toCharArray();
		System.out.println(stringContains.hashCheck(longString, shortString));
	     
		
		
		String[] sString= {"hello","july"};

		char[] lString="hellomehellojuly".toCharArray();
		
		System.out.println(stringContains.hashUniqueChar(lString));
		
		char[] lString2="helo".toCharArray();
		
		System.out.println(stringContains.hashUniqueChar(lString2));
		
		
		
		System.out.println(1&1);
	
	
	}

}
