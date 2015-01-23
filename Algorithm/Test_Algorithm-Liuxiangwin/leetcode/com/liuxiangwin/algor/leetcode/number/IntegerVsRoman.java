package com.liuxiangwin.algor.leetcode.number;
// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 18, 2014
// Source:   http://oj.leetcode.com/problems/integer-to-roman/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/22869803

// Given an integer, convert it to a roman numeral.
// Input is guaranteed to be within the range from 1 to 3999.


//http://blog.csdn.net/jellyyin/article/details/13165731

//如果当前处理的字符对应的值和上一个字符一样，那么临时变量加上这个字符。比如III = 3
//如果当前比前一个大，说明这一段的值应该是当前这个值减去前面记录下的临时变量中的值。比如IIV = 5 – 2
//如果当前比前一个小，那么就可以先将临时变量的值加到结果中，然后开始下一段记录。比如VI = 5 + 1
/**
 * 罗马数字有如下符号：
Ⅰ（1）Ⅴ（5）Ⅹ（10）L（50）C（100）D（500）M（1000）

计数规则：
1.若干相同数字连写表示的数是这些罗马数字的和，如III=3；

2.小数字在大数字前面表示的数是用大数字减去小数字，如IV＝4；
3.小数字在大数字后面表示的数是用大数字加上小数字，如VI=6;

组合规则：

(1)基本数字Ⅰ、X 、C 中的任何一个，自身连用构成数目，或者放在大数的右边连用构成数目，都不能超过三个；放在大数的左边只能用一个。

(2)不能把基本数字 V 、L 、D 中的任何一个作为小数放在大数的左边采用相减的方法构成数目；放在大数的右边采用相加的方式构成数目，只能使用一个。
(3)V 和 X 左边的小数字只能用Ⅰ。
(4)L 和 C 左边的小数字只能用×。
(5)D 和 M 左 边的小数字只能用 C 
 * @author liuxiangwin
 *
 */
public class IntegerVsRoman {
	public String intToRoman(int num) {
		int[] dic = { 1000, 900, 500, 400, 
				        100, 90, 50, 
				        40, 10, 9, 5, 4, 1 };
		String[] roman = { 
				"M", "CM", "D", "CD", 
				"C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };

		String result = "";

		for (int i = 0; num > 0; i++) {
			int count = num / dic[i];//遍历数组中看那个能进位数，或者说数大于这个数
			num %= dic[i];  //余下的数字继续循环

			while (count > 0) {//根据进位数来叠加
				result += roman[i];
				--count;
			}
		}
		return result;
	}
	
	        //基本字符	I	V	X	L	C	D	M
      //对应阿拉伯数字	1	5	10	50	100	500	1000
	public int romanToInt(String s) {
		if (s.length() == 0)
			return 0;

		int length = s.length();
		int result = charToInt(s.charAt(length-1));
		for (int i = length - 2; i >= 0; i--) {
			if (charToInt(s.charAt(i + 1)) <= charToInt(s.charAt(i)))
				//前面比后面大，加上现在的值				
				result += charToInt(s.charAt(i));
			else{
				result -= charToInt(s.charAt(i));//前面比后面（最后一位）
				//大,所以结果减去现在的值
			}				
		}
		return result;
	}
	
	
	public int romanToInt_hm(String s)  {
		/*
		 * unordered_map<char, int> kv ({ {'I', 1}, {'V',5}, {'X',10}, {'L',50},
		 * {'C',100}, {'D',500}, {'M',1000}, {'0', 0} });
		 */
		int result = 0;
		s += "0";
		for (int i = 0; i < s.length() - 1; i++) {
			// I比V对应的数值小，结果就是result + （-I)
			if (charToInt(s.charAt(i)) < charToInt(s.charAt(i + 1))) {
				result -= charToInt(s.charAt(i));
			} else {
				result += charToInt(s.charAt(i));
			}
		}	
		return result;
	}
	
	private int romanToInt2(String s) {
		int sum = 0;int j;
		for (int i = 0; i < s.length(); i++) {	
			j = i + 1;
			// j是后面一位的位置
			if (j < s.length()
					&& charToInt(s.charAt(j)) > charToInt(s.charAt(i))) {
				sum += charToInt(s.charAt(j)) - charToInt(s.charAt(i));
				i = j;
			} else {
				sum += charToInt(s.charAt(i));
			}
		}
		return sum;
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
		
		//System.out.println(slt.romanToInt("MCMXC"));
		System.out.println(slt.romanToInt2("MCMXC"));
		System.out.println(slt.romanToInt("MCMXC"));
		
		
	}
}