package com.liuxiangwin.Algorithm.String.test;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class TestStringPalindrome {

	/**
	 * 
	 * 1、判断一条单向链表是不是“回文”
	 * 
	 * 2、判断一个栈是不是“回文”

分析：对于栈的话，只需要将字符串全部压入栈，然后依次将各字符出栈，
这样得到的就是原字符串的逆置串，分别和原字符串各个字符比较，就可以判断了。
	 */
	public static void main(String[] args) {
		String test1 = "cddcbcbeffeghg";
		String str = "A man, a plan, a canal, Panama!";
		String test2 = "dooernedeevrvn";

		String googleString = "google";
		int count = findSymmetryStr(test1);//

		System.out.println(count);
	
		printAllPalindromes(test1);
		System.out.println("longestPrefixPalindrome google  "
				+ longestPrefixPalindrome(googleString));

		System.out.println("longestPrefixPalindrome cddcbcbeffeghg  "
				+ longestPrefixPalindrome(test1));

		// longestPrefixPalindrome("NILLINOISURB"));
        
		System.out.println("madam is Palindrome "+IsPalindrome("madam"));
	}

	public static boolean IsPalindrome(String string)
	{ 
		if (string == null || string.length() < 1)
			return false;

		int front = 0;
		int back = string.length() - 1;
		while (front < back) {
			if (string.charAt(front) != string.charAt(back)) {
				return false; // 不是回文，立即返回
			}
			front++;
			back--;
		}
		return true; // 是回文
	}
	
	
	public static boolean isCharPalindrome(String test) {
		String filterString = test.toLowerCase().replaceAll("[^0-9a-zA-Z]", "");
		for(int i = 0; i < filterString.length() ; i++){
			if(filterString.charAt(i) != filterString.charAt(filterString.length() - 1 - i)){
				return false;
			}
		}
		return true;
	}
	//如果不适用string toLowerCase replaceAll 就必须使用这个函数
	private boolean isAlphabet(char c) {
		return (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
	}
	
	// If is the palindrome then return the string
	public static String longestPrefixPalindrome(String string) {
		String defaultPrefix = string.substring(0, 1);
		for (int i = string.length() - 1; i >= 0; i--) {
			String maxPrefix = string.substring(0, i);
			if (isCharPalindrome(maxPrefix)) {
				return maxPrefix;
			}
		}
		return defaultPrefix;
	}

	
	public static void printAllPalindromes(String inputText) {
		if (inputText == null) {
			System.out.println("Input cannot be null!");
			return;
		}
		if (inputText.length() <= 2) {
			System.out.println("Minimum three characters should be present");
		}
		// ODD Occuring Palindromes
		int len = inputText.length();
		for (int i = 1; i < len - 1; i++) {
			for (int j = i - 1, k = i + 1; j >= 0 && k < len; j--, k++) {
				if (inputText.charAt(j) == inputText.charAt(k)) {
					System.out.println("The Odd Palindromes "
							+ inputText.subSequence(j, k + 1));
				} else {
					break;
				}
			}
		}
		// EVEN Occuring Palindromes
		for (int i = 1; i < len - 1; i++) {
			for (int j = i, k = i + 1; j >= 0 && k < len; j--, k++) {
				if (inputText.charAt(j) == inputText.charAt(k)) {
					System.out.println("The Even Palindromes "
							+ inputText.subSequence(j, k + 1));
				} else {
					break;
				}
			}
		}

	}

	public String str = "overflow";
	public ArrayList<String> possibilities = new ArrayList<String>();

	// public void main(String[] args) {
	// permu(new boolean[str.length()], "");
	// }

	public void permu(boolean[] used, String cur) {
		if (cur.length() == str.length()) {
			possibilities.add(cur);
			return;
		}
		for (int a = 0; a < str.length(); a++) {
			if (!used[a]) {
				used[a] = true;
				cur += str.charAt(a);
				permu(used, cur);
				used[a] = false;
				cur = cur.substring(0, cur.length() - 1);
			}
		}
	}

	public static int findSymmetryStr(String orgStr) {
		// 结果初始化
		int count = 0;

		// 当输入字符串不为null且长度大于1时进行查找,否则直接返回0
		if (orgStr != null && orgStr.length() > 1) {
			// 得到输入字符串的长度
			int size = orgStr.length();
			// 字符串的头字符索引
			int head;
			// 字符串从后向前遍历时的"尾"字符索引,即当前字符索引
			int current;
			// 字符串的头字符
			char headStr;
			// 字符串从后向前遍历时的"尾"字符
			char endStr;

			// 从前开始遍历字符串
			for (head = 0; head < size; head++) {
				// 取得头字符
				headStr = orgStr.charAt(head);
				// 指向输入字符串的最后
				current = size - 1;
				// 当尾字符索引等于头字符索引时退出循环
				while (current > head) {
					// 取得尾字符
					endStr = orgStr.charAt(current);
					// 如果头尾字符相等,则继续判断
					if (headStr == endStr) {
						// 取出头尾中间的子字符串,对其进行分析
						String newStr = orgStr.substring(head + 1, current);
						// 如果此子字符串的长度大于1,则进行递归
						if (newStr.length() > 1)
							// 递归得到此子字符串中对称的字符串个数
							count += findSymmetryStr(newStr);
						// 如果此子字符串只有1个或0个字符,则表明原头尾字符和此单个字符组成对称字符串
						else
							count++;
						// 将尾字符索引向前推1位
						current--;

					}
					// 如果头尾字符不相等,则将尾字符索引向前推1位
					else {
						current--;
					}
				}
			}
		}

		return count;
	}

	private static boolean isAnagram(String inputString) {
		int oddCount = 0;
		if (inputString == null || inputString.length() <= 0) {
			return false;
		}
		inputString = inputString.toLowerCase();

		Hashtable<String, Integer> ht = new Hashtable<String, Integer>();

		for (int i = 0; i < inputString.length(); i++) {
			String currentStr = String.valueOf(inputString.charAt(i));
			if (ht.containsKey(currentStr)) {

				ht.put(currentStr, ht.get(currentStr) + 1);
			} else {
				ht.put(currentStr, 1);
			}

		}
		Enumeration<Integer> values = ht.elements();
		while (values.hasMoreElements() && oddCount <= 1) {
			if (isOdd(values.nextElement())) {
				oddCount++;
			}
		}
		return oddCount <= 1;

	}

	private static boolean isOdd(int i) {
		if (i < 0)
			return false;
		else
			return i % 2 == 1;
	}
}
