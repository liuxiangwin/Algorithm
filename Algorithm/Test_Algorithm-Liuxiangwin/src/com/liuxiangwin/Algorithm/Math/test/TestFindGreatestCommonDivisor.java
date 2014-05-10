package com.liuxiangwin.Algorithm.Math.test;

public class TestFindGreatestCommonDivisor {
	/**
	 * 1.շת���������������һ����С��ȥ���ϴ����� ������õ������ǽ�С����Լ������������������������������Լ����
	 * ����������������ȥ��������ֱ�����õ������ǳ�����Լ��Ϊֹ��
	 * �磺��48��18�����Լ����48��18=2����12����������12���ǳ���18��Լ����
	 * ���ٳ�����18��12=1����6������6�Ѿ��ǳ���12��Լ���� ��48��18�����Լ����6����շת������Ҳ���ǡ�ŷ������㷨���� *
	 * 
	 * 
	 * 2.շת������������ýϴ�����ȥ��С����������õĲ��ǽ�С����Լ����
	 * �������������������Լ�����������ü�����ȥ�ֱ�����õĲ��Ǽ�����Լ��Ϊֹ��
	 * �磺��24��60�����Լ������60-24=36����Ϊ��36���Ǽ���24��Լ����
	 * ���ټ���36-24=12����12�Ǽ���24��Լ��������12����24��60�����Լ���� 

	 */
	public static void main(String[] args) {
		TestFindGreatestCommonDivisor gtCommon = new TestFindGreatestCommonDivisor();
		
		System.out.println(gtCommon.findGcdBySubtraction(24, 60));
		System.out.println(gtCommon.gcd1(48, 18));
		System.out.println(gtCommon.gcd2(888, 458));
	}
	
    int findGcdBySubtraction(int x,int y)
    {

        if(x < y)
             return findGcdBySubtraction(y, x);
        if(y == 0)
             return x;
           //x > y
        else
             return findGcdBySubtraction(x - y, y);

    }
    
	int gys1(int a, int b) // ѭ��ʵ��
	{
		int k, y;
		if (a < b) {
			k = a;
			a = b;
			b = k;
		}
		//48��18=2����12 ��18��12=1����6
		while (a % b != 0) {
			y = a % b;
			a = b;
			b = y;
		}
		return b;
	}

	// ѭ��ʵ��
	int gcd1(int a, int b) {
		int k = 0;
		do {
			// �õ����� 48��18=2����12 ��18��12=1����6
			k = a % b;
			// ����շת�����,�ѳ�������������
			a = b;
			// ������������
			b = k;
		} while (k != 0);
		// ���ر�����
		return a;
		// return k;
	}

	// ���ʵ��
	int gcd2(int a, int b) {
		// ֱ���������������˳�
		if (b == 0) {
			return a;
		}
		if (a < 0) {
			return gcd2(-a, b);
		}
		if (b < 0) {
			return gcd2(a, -b);
		}
		return gcd2(b, a % b);
	}

}
