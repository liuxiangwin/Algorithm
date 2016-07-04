package com.liuxiangwin.algor.leetcode.number;

public class PowerOfFour {
	public static boolean isPowerOfFour(int num) {
		if (num == 1) // 单独处理数字1
			return true;

		while (num % 4 == 0 && num != 0) {
			num = num / 4;
			if (num == 1)
				return true;
		}
		return false;
	}
	//4的次方的某个数必然：1. 满足二进制只有1位是1其余位都是0（通过每次将1左移2位得到），2. 这个数减1以后能被3整除：
	//[java] view plain copy print?在CODE上查看代码片派生到我的代码片
	public boolean isPowerOfFour2(int num) {  
	    return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;  
	} 
	
	
	// ---> ‭0100‬
	// 16 ---> ‭0001 0000‬
	// 64 ---> ‭0100 0000‬
	// 256 ---> ‭0001 0000 0000‬
	// 1024 ---> ‭0100 0000 0000
	// 4096 ---> ‬‭0001 0000 0000 0000
	// 从上述列出的几个连续的4的幂指数可以发现，
	// 这些数的二进制形式符合以下规律：除前四位剩余位数均为0，
	// 前四位只有两种形式即：0001和0100，
	// 即数字1后出现的0的个数为0个或2个，利用此规律，我们可以得到如下解题方法。代码如下（Java）‬
  
	
	
	
	public static boolean isPowerOfFourOptimize(int num) {
		if (num == 1) // 单独处理数字1
			return true;

		if (num == 0) // 单独处理数字0
			return false;

		String binaryCode = Integer.toBinaryString(num); // 获取给定数字的二进制形式（没有前置0补全，即以1开头）

		String lastPos = binaryCode.substring(1); // 获取二进制数除第一位之后的所有位数字
		int lastPosVal = Integer.valueOf(lastPos, 2); // 除第一位数之后所有位数组成的二进制数字的值

		if (lastPosVal == 0
				&& (lastPos.length() % 4 == 0 || lastPos.length() % 4 == 2)) // 满足条件则返回True
			return true;
		else
			return false;
	}

	public static void main(String args[]) {
		System.out.println(PowerOfFour.isPowerOfFour(32));
	}
}
