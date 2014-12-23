package com.liuxiangwin.algor.leetcode.stackuse;


// Analysis: http://blog.csdn.net/lilong_dream/article/details/21694751


// Given a string containing just the characters 
//'(', ')', '{', '}', '[' and ']', 
// determine if the input string is valid.
// The brackets must close in the correct order, 
// "()" and "()[]{}" are all valid but "(]" and "([)]" are not.


//LeetCode Ö®¶ÑÕ» stack
//http://blog.csdn.net/sbitswc/article/details/20685253
import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String string) {
		if (string.length() == 0) {
			return true;
		}

		Stack<Character> stack = new Stack<Character>();
		stack.push(string.charAt(0));

		for (int i = 1; i < string.length(); ++i) {
			if (!stack.empty() && 
				isMatch(stack.peek(), string.charAt(i))) {
				stack.pop();
			}
			else {
				stack.push(string.charAt(i));
			}
		}		
		if(stack.empty()) {
			return true;
		}
		return false;
	}

	public boolean isMatch(char cur, char pre) {
		if ((cur == '(' && pre == ')') || (cur == '{' && pre == '}')
				|| (cur == '[' && pre == ']')) {
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