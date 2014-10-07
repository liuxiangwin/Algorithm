package com.liuxiangwin.algor.leetcode.string;


// Analysis: http://blog.csdn.net/lilong_dream/article/details/21694751


// Given a string containing just the characters 
//'(', ')', '{', '}', '[' and ']', 
// determine if the input string is valid.
// The brackets must close in the correct order, 
// "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		if (s.length() == 0) {
			return true;
		}

		Stack<Character> st = new Stack<Character>();
		st.push(s.charAt(0));

		for (int i = 1; i < s.length(); ++i) {
			if (!st.empty() && isMatch(st.peek(), s.charAt(i))) {
				st.pop();
			}
			else {
				st.push(s.charAt(i));
			}
		}
		
		if(st.empty()) {
			return true;
		}

		return false;
	}

	public boolean isMatch(char s, char p) {
		if ((s == '(' && p == ')') || (s == '{' && p == '}')
				|| (s == '[' && p == ']')) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		ValidParentheses slt = new ValidParentheses();
		//String s = "(]";
		String s = "()Sting";
		System.out.println(slt.isValid(s));
	}
}