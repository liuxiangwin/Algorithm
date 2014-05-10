package com.liuxiangwin.Algorithm.Math.test;

public class TestFindGreatestCommonDivisor {
	/**
	 * 1.辗转相除法。就是先用一个较小数去除较大数， 如果所得的余数是较小数的约数，则这个余数就是这两个数的最大公约数。
	 * 否则，我们再用余数去除除数，直到除得的余数是除数的约数为止。
	 * 如：求48和18的最大公约数，48÷18=2……12，由于余数12不是除数18的约数，
	 * 故再除，用18÷12=1……6，余数6已经是除数12的约数， 故48和18的最大公约数是6。“辗转除法”也就是“欧几里德算法”。 *
	 * 
	 * 
	 * 2.辗转相减法。就是用较大数减去较小数，如果所得的差是较小数的约数，
	 * 则差就是这两个数的最大公约数。否则，再用减数减去差，直到所得的差是减数的约数为止。
	 * 如：求24和60的最大公约数，用60-24=36，因为差36不是减数24的约数，
	 * 故再减，36-24=12，差12是减数24的约数，所以12就是24和60的最大公约数。 

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
    
	int gys1(int a, int b) // 循环实现
	{
		int k, y;
		if (a < b) {
			k = a;
			a = b;
			b = k;
		}
		//48÷18=2……12 用18÷12=1……6
		while (a % b != 0) {
			y = a % b;
			a = b;
			b = y;
		}
		return b;
	}

	// 循环实现
	int gcd1(int a, int b) {
		int k = 0;
		do {
			// 得到余数 48÷18=2……12 用18÷12=1……6
			k = a % b;
			// 根据辗转相除法,把除数赋给被除数
			a = b;
			// 余数赋给除数
			b = k;
		} while (k != 0);
		// 返回被除数
		return a;
		// return k;
	}

	// 逆归实现
	int gcd2(int a, int b) {
		// 直到满足此条件逆归退出
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
