package com.liuxiangwin.algor.leetcode.string;
// Analysis: http://blog.csdn.net/lilong_dream/article/details/19677643

// Implement atoi to convert a string to an integer.
// Hint: Carefully consider all possible input cases. 
// If you want a challenge, please do not see below and ask yourself what are the possible input cases.
// Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
// You are responsible to gather all the input requirements up front.

public class StringToInteger_atoi {
	private int INT_MAX = Integer.MAX_VALUE;
	private int INT_MIN = Integer.MIN_VALUE;
	
	public int atoi(String str) {
		String s = str.trim();

		if (s.length() == 0) {
			return 0;
		}		
		
		int sign = 1;
		int result = 0;	
		int index = 0;
		
		if (s.charAt(0) == '-') {
			sign = -1;
			++index;
		} else if (s.charAt(0) == '+') {
			++index;
		}

		for (; index < s.length(); ++index) {
			char digit = s.charAt(index);
			if (digit >= '0' && digit <= '9') {
				if (result > INT_MAX / 10 || digit - '0' > INT_MAX - result * 10) {
					return sign == -1 ? INT_MIN : INT_MAX;
				}

				result = result * 10 + (digit - '0');
			} else {
				break;//每一个字符不是在0到就之间的就break
			}
		}

		return sign * result;
	}
	
	


	public static void main(String[] args) {
		StringToInteger_atoi slt = new StringToInteger_atoi();
		String str = "-2147483649";
		int result = slt.atoi(str);
		System.out.print(result);
		
		
	}
}

class IntergerToSring{
	final static int [] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
        99999999, 999999999, Integer.MAX_VALUE };
	
	 public static String toString(int i) {
	        if (i == Integer.MIN_VALUE)
	            return "-2147483648";
	        int size = (i < 0) ? stringSize(-i) + 1 : stringSize(i);
	        char[] buf = new char[size];
	        getChars(i, size, buf);
	        //return new String(buf, true);
	        return new String(buf);
	    }
	 // Requires positive x
	    static int stringSize(int x) {
	        for (int i=0; ; i++)
	            if (x <= sizeTable[i])
	                return i+1;
	    }
	    
	    static void getChars(int i, int index, char[] buf) {
	        int q, r;
	        int charPos = index;
	        char sign = 0;

	        if (i < 0) {
	            sign = '-';
	            i = -i;
	        }

	        // Generate two digits per iteration
	        while (i >= 65536) {
	            q = i / 100;
	        // really: r = i - (q * 100);
	            r = i - ((q << 6) + (q << 5) + (q << 2));
	            i = q;
	            //buf [--charPos] = DigitOnes[r];
	            buf [--charPos] = '0';
	            buf [--charPos] = '0';
	        }

	        // Fall thru to fast mode for smaller numbers
	        // assert(i <= 65536, i);
	        for (;;) {
	            q = (i * 52429) >>> (16+3);
	            r = i - ((q << 3) + (q << 1));  // r = i-(q*10) ...
	            //buf [--charPos] = digits [r];
	            buf [--charPos] = '0';
	            i = q;
	            if (i == 0) break;
	        }
	        if (sign != 0) {
	            buf [--charPos] = sign;
	        }
	    }

}