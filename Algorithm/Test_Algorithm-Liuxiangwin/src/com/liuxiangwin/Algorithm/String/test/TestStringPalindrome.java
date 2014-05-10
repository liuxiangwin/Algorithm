package com.liuxiangwin.Algorithm.String.test;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class TestStringPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String test1 = "cddcbcbeffeghg";
		String str = "A man, a plan, a canal, Panama!";
		String test2 = "dooernedeevrvn";

		String googleString = "google";
		int count = findSymmetryStr(test1);//

		System.out.println(count);
		// System.out.println("is a Anagram "+isAnagram("cddcbcbeffeghg"));
		// System.out.println("symmetry string count is : " + count);
		// printAllPalindromes("abcddcbaABCDEDCBA");
		// System.out.println(isCharPalindrome(test1));
		printAllPalindromes(test1);

		// System.out.println("isCharPalindrome dooernedeevrvn  "+isCharPalindrome(test2));

		// System.out.println("isAnagram dooernedeevrvn  "+isAnagram(test2));

		System.out.println("longestPrefixPalindrome google  "
				+ longestPrefixPalindrome(googleString));

		System.out.println("longestPrefixPalindrome cddcbcbeffeghg  "
				+ longestPrefixPalindrome(test1));

		// System.out.println("isCharPalindrome:"+
		// isCharPalindrome("A man, a plan, a canal, Panama!"));
		// System.out.println("longestPrefixPal:"+
		// longestPrefixPalindrome("NILLINOISURB"));

	}

	public static boolean isCharPalindrome(String test) {
		String filterString = test.toLowerCase().replaceAll("[^0-9a-zA-Z]", "");
		for (int i = 0; i < filterString.length() / 2; i++) {
			if (filterString.charAt(i) != filterString.charAt(filterString
					.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	// If is the palindrome then return the string
	public static String longestPrefixPalindrome(String test) {
		String defaultPrefix = test.substring(0, 1);
		for (int i = test.length() - 1; i >= 0; i--) {
			String maxPrefix = test.substring(0, i);
			if (isCharPalindrome(maxPrefix)) {
				return maxPrefix;
			}
		}
		return defaultPrefix;
	}

	public static boolean anagramtest(String s) {
		boolean flag = false;
		char[] c = s.toCharArray();
		if (s.length() == 2) {
			if (c[0] == c[1]) {
				flag = true;
			}
		} else if (s.length() > 2) {
			for (int start = 0, finish = s.length() - 1; start < finish; start++, finish--) {
				if (c[start] == c[finish]) {
					flag = true;
				}
			}
		}
		return flag;
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
		// �����ʼ��
		int count = 0;

		// �������ַ�����Ϊnull�ҳ��ȴ���1ʱ���в���,����ֱ�ӷ���0
		if (orgStr != null && orgStr.length() > 1) {
			// �õ������ַ����ĳ���
			int size = orgStr.length();
			// �ַ�����ͷ�ַ�����
			int head;
			// �ַ����Ӻ���ǰ����ʱ��"β"�ַ�����,����ǰ�ַ�����
			int current;
			// �ַ�����ͷ�ַ�
			char headStr;
			// �ַ����Ӻ���ǰ����ʱ��"β"�ַ�
			char endStr;

			// ��ǰ��ʼ�����ַ���
			for (head = 0; head < size; head++) {
				// ȡ��ͷ�ַ�
				headStr = orgStr.charAt(head);
				// ָ�������ַ��������
				current = size - 1;
				// ��β�ַ���������ͷ�ַ�����ʱ�˳�ѭ��
				while (current > head) {
					// ȡ��β�ַ�
					endStr = orgStr.charAt(current);
					// ���ͷβ�ַ����,������ж�
					if (headStr == endStr) {
						// ȡ��ͷβ�м�����ַ���,������з���
						String newStr = orgStr.substring(head + 1, current);
						// ��������ַ����ĳ��ȴ���1,����еݹ�
						if (newStr.length() > 1)
							// �ݹ�õ������ַ����жԳƵ��ַ�������
							count += findSymmetryStr(newStr);
						// ��������ַ���ֻ��1����0���ַ�,�����ԭͷβ�ַ��ʹ˵����ַ���ɶԳ��ַ���
						else
							count++;
						// ��β�ַ�������ǰ��1λ
						current--;

					}
					// ���ͷβ�ַ������,��β�ַ�������ǰ��1λ
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
