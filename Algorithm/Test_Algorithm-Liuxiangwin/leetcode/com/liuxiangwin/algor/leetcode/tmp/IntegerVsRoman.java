package com.liuxiangwin.algor.leetcode.tmp;
// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 18, 2014
// Source:   http://oj.leetcode.com/problems/integer-to-roman/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/22869803

// Given an integer, convert it to a roman numeral.
// Input is guaranteed to be within the range from 1 to 3999.


//http://blog.csdn.net/jellyyin/article/details/13165731

//�����ǰ������ַ���Ӧ��ֵ����һ���ַ�һ������ô��ʱ������������ַ�������III = 3
//�����ǰ��ǰһ����˵����һ�ε�ֵӦ���ǵ�ǰ���ֵ��ȥǰ���¼�µ���ʱ�����е�ֵ������IIV = 5 �C 2
//�����ǰ��ǰһ��С����ô�Ϳ����Ƚ���ʱ������ֵ�ӵ�����У�Ȼ��ʼ��һ�μ�¼������VI = 5 + 1
/**
 * �������������·��ţ�
��1������5������10��L��50��C��100��D��500��M��1000��

��������
1.������ͬ������д��ʾ��������Щ�������ֵĺͣ���III=3��

2.С�����ڴ�����ǰ���ʾ�������ô����ּ�ȥС���֣���IV��4��
3.С�����ڴ����ֺ����ʾ�������ô����ּ���С���֣���VI=6;

��Ϲ���

(1)�������֢�X ��C �е��κ�һ�����������ù�����Ŀ�����߷��ڴ������ұ����ù�����Ŀ�������ܳ������������ڴ��������ֻ����һ����

(2)���ܰѻ������� V ��L ��D �е��κ�һ����ΪС�����ڴ�������߲�������ķ���������Ŀ�����ڴ������ұ߲�����ӵķ�ʽ������Ŀ��ֻ��ʹ��һ����
(3)V �� X ��ߵ�С����ֻ���â�
(4)L �� C ��ߵ�С����ֻ���á���
(5)D �� M �� �ߵ�С����ֻ���� C 
 * @author liuxiangwin
 *
 */
public class IntegerVsRoman {
	public String intToRoman(int num) {
		int[] base = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] roman = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };

		String result = "";

		for (int i = 0; num > 0; ++i) {
			int count = num / base[i];
			num %= base[i];

			while (count > 0) {
				result += roman[i];
				--count;
			}
		}

		return result;
	}
	
	
	
	public static int romanToInt(String s) {
        int i, total, pre, cur;

        total = charToInt(s.charAt(0));

        for (i = 1; i < s.length(); i++) {
            pre = charToInt(s.charAt(i - 1));
            cur = charToInt(s.charAt(i));

            if (cur <= pre) {
                total += cur;
            } else {
                total = total - pre * 2 + cur;
            }
        }
        return total;
    }
	
	public int romanToInt2(String s) {
		if (s.length() == 0)
			return 0;

		int length = s.length();
		int result = s.charAt(length-1);
		for (int i = length - 2; i >= 0; i--) {
			if (charToInt(s.charAt(i + 1)) <= charToInt(s.charAt(i)))
				result += charToInt(s.charAt(i));
			else
				result -= charToInt(s.charAt(i));
		}
		return result;
	}

	
	
	public static int charToInt(char c) {
        switch(c) {
            case 'I': return 1; 
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
	
	public static void main(String[] args) {
		IntegerVsRoman slt = new IntegerVsRoman();
		System.out.println(slt.intToRoman(321));
	}
}